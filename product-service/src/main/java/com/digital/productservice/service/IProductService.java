package com.digital.productservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.digital.productservice.dto.ProductDetailsData;
import com.digital.productservice.exception.ProductServiceFetchingException;

/**
 * @author Loyalty_digiTeam
 *
 */
@Service
public interface IProductService {

	/**
	 * @param id
	 * @return
	 */
	public String deleteProductByID (int id);

	/**
	 * @return
	 * @throws ProductServiceFetchingException 
	 */
	public List<ProductDetailsData> getAllProducts() throws ProductServiceFetchingException;

	public ProductDetailsData fetchProductById(int productId) throws ProductServiceFetchingException;

}
