package com.digital.order.utilitymethods;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.modelmapper.ModelMapper;

import com.digital.order.dto.CartResponseDto;
import com.digital.order.dto.ItemDto;
import com.digital.order.entity.Items;
import com.digital.order.entity.Order;

public class UtilityMethods {
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	
	public static Order convertCartDtotoEntity(CartResponseDto cartDto) {
		Order orderDetail = new Order();
		List<Items> itemList = new ArrayList();
		for (ItemDto item : cartDto.getItemList()) {
			itemList.add(modelMapper.map(item, Items.class));
		}
		orderDetail.setItemList(itemList);
		orderDetail.setUserName(cartDto.getUserName());
		orderDetail.setUserId(cartDto.getUserId());
		orderDetail.setTotalPrice(cartDto.getCartValue());
		orderDetail.setNumOfItems(cartDto.getNumOfItemsInCart());
		return orderDetail;

	}

}