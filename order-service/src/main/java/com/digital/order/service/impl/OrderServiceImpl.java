package com.digital.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.digital.order.dao.OrderDao;
import com.digital.order.dto.CartResponseDto;
import com.digital.order.dto.ItemDto;
import com.digital.order.dto.PaymentDto;
import com.digital.order.dto.UpiPaymentDto;
import com.digital.order.dto.VoucherUserDto;
import com.digital.order.entity.Order;
import com.digital.order.entity.Order.paymentmode;
import com.digital.order.exception.LoyaltyRewardsGlobalAppException;
import com.digital.order.exception.OrderPaymentException;
import com.digital.order.exception.OrderPersistanceException;
import com.digital.order.proxy.CartProxy;
import com.digital.order.proxy.LoyaltyProxy;
import com.digital.order.proxy.ProductProxy;
import com.digital.order.service.IOrderService;
import com.digital.order.utilitymethods.UtilityMethods;

import feign.FeignException;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private CartProxy cartProxy;

	@Autowired
	private LoyaltyProxy loyaltyProxy;
	
	@Autowired
	private ProductProxy productProxy;

	@Value("${loyalty.utilization.discount}")
	private int loyaltyRewardsUtilizationDiscounts;

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	private static final String LOYALTY_ORDER_CREATION = "loyaltyManagementTopic";

	@Override
	public String orderByCash(String userId, String voucherCode) throws LoyaltyRewardsGlobalAppException {
		orderThroughVoucherCode(userId, voucherCode);
		return "Ordered successfully";
	}

	public String orderByCard(PaymentDto paymentDto, String userId, String voucherCode)
			throws LoyaltyRewardsGlobalAppException {
		String value = "";
		int numberOfDigits = String.valueOf(paymentDto.getCardNumber()).length();
		int cvvnum = String.valueOf(paymentDto.getCvv()).length();
		if (numberOfDigits == 16 && cvvnum == 3) {
			orderThroughVoucherCode(userId, voucherCode);
			value = "Order placed succesfully";
		} else {
			throw new OrderPaymentException("Incorrect card Details ....Check and try again!!");
		}
		return value;
	}

	@Override
	public String orderByUpi(UpiPaymentDto upiPaymentDto, String userId, String voucherCode)
			throws LoyaltyRewardsGlobalAppException {
		String value = "";
		int numberOfDigits = String.valueOf(upiPaymentDto.getPhonenumber()).length();
		if (numberOfDigits == 10) {
			orderThroughVoucherCode(userId, voucherCode);
			value = "Order placed succesfully";
		} else {
			throw new OrderPaymentException("Incorrect UPI Details ....Check and try again!!");
		}
		return value;
	}

	public double fetchUserLoyaltyPoints(String userId) {
		return loyaltyProxy.fetchUserLoyaltyPoints(userId).getBody();
	}

	public int checkVoucherValidityAndFetchVoucher(String voucherCode, String userId)
			throws LoyaltyRewardsGlobalAppException {
		return loyaltyProxy.validateVocherCode(userId, voucherCode).getBody();
	}

	public Order voucherUtilization(String userId, String voucherCode, Order orderDetail)
			throws LoyaltyRewardsGlobalAppException {
		int voucherDiscountPercentage = checkVoucherValidityAndFetchVoucher(voucherCode, userId);
		// get voucher discount and apply to order price
		orderDetail.setTotalPrice(
				orderDetail.getTotalPrice() - ((voucherDiscountPercentage * orderDetail.getTotalPrice()) / 100));
		return orderDetail;
	}

	public Order loyaltyPointsUlitization(String userId, String voucherCode, Order orderDetail) {
		VoucherUserDto voucherUserDto = new VoucherUserDto();
		voucherUserDto.setUserId(userId);
		voucherUserDto.setVoucherCode(voucherCode);
		double availableLoyaltypoints = fetchUserLoyaltyPoints(userId);
		double loyaltyUtilizablePoints = (loyaltyRewardsUtilizationDiscounts * orderDetail.getTotalPrice()) / 100;
		if (availableLoyaltypoints < loyaltyUtilizablePoints) {  //500<159
			orderDetail.setTotalPrice(orderDetail.getTotalPrice() - availableLoyaltypoints);
			voucherUserDto.setUtilizedLoyaltyPoints(availableLoyaltypoints);
		} else {
			orderDetail.setTotalPrice(orderDetail.getTotalPrice() - loyaltyUtilizablePoints);
			voucherUserDto.setUtilizedLoyaltyPoints(loyaltyUtilizablePoints);
		}
		orderDetail.setPaymentMode(paymentmode.CASH);
		voucherUserDto.setOrderAmount(orderDetail.getTotalPrice());
		kafkaTemplate.send(LOYALTY_ORDER_CREATION, voucherUserDto);
		return orderDetail;
	} 

	public void orderThroughVoucherCode(String userId, String voucherCode) throws LoyaltyRewardsGlobalAppException {
		try {
			CartResponseDto cartResponseDto = cartProxy.getCartByUserId(userId).getBody();
			Order orderDetail = UtilityMethods.convertCartDtotoEntity(cartResponseDto);
			if (voucherCode !=null) {
				orderDetail = voucherUtilization(userId, voucherCode, orderDetail);
			}
			orderDetail = loyaltyPointsUlitization(userId, voucherCode, orderDetail);
			for (ItemDto item : cartResponseDto.getItemList()) {
				productProxy.updateProductByIdAndQuantity(item.getProductId(), item.getQuantity());//Have to Send List and varify list directly in product service ....DONT DO THIS AGAIN...!!!
			}
			orderDao.addToOrder(orderDetail);
			cartProxy.deleteCartDetails(userId);
		} catch (FeignException e) {
			throw new OrderPersistanceException(e.contentUTF8());
		}
		catch (Exception e) {
			throw new OrderPersistanceException("Couldnt order the product !! Try again ...");
		}
	}
}