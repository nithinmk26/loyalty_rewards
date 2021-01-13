package com.digital.productservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.digital.productservice.dto.ProductDto;
import com.digital.productservice.entity.Product;

/**
 * @author Loyalty_digiTeam
 *
 */
@Service
public interface IProductService {
	
	
	/**
	 * @return
	 */
	public List<Product> getAllProoducts();
	
	/**
	 * @param id
	 * @return
	 */
	public String deleteProductByID (int id);
	
	/**
	 * @param id
	 * @return
	 */
	public String updateProductByID(int id , ProductDto productDto);
	
	

}
