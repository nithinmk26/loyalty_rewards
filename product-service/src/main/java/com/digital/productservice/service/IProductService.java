package com.digital.productservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.digital.productservice.dto.ProductDetailsData;
import com.digital.productservice.dto.model.ProductItemModel;
import com.digital.productservice.exception.LoyaltyRewardsGlobalAppException;
import com.digital.productservice.exception.ProductServiceFetchingException;
import com.digital.productservice.exception.ProductUnavailabilityException;

/**
 * @author Loyalty_digiTeam
 *
 */
@Service
public interface IProductService {

	/**
	 * @param id
	 * @return
	 * @throws LoyaltyRewardsGlobalAppException 
	 */
	public String deleteProductByID (int id) throws LoyaltyRewardsGlobalAppException;

	/**
	 * @return
	 * @throws ProductServiceFetchingException 
	 */
	public List<ProductDetailsData> getAllProducts() throws ProductServiceFetchingException;

	/**
	 * @param productId
	 * @return
	 * @throws ProductServiceFetchingException
	 */
	public ProductDetailsData fetchProductById(int productId) throws ProductServiceFetchingException;

	/**
	 * @param productItemModel
	 * @return
	 * @throws ProductUnavailabilityException 
	 */
	public Boolean getAllProductAvailability(List<ProductItemModel> productItemModel) throws ProductUnavailabilityException;

	/**
	 * @param productId
	 * @param quantity
	 * @throws LoyaltyRewardsGlobalAppException 
	 */
	public void updateProductByIdAndQuantity(int productId, int quantity) throws LoyaltyRewardsGlobalAppException;

}
