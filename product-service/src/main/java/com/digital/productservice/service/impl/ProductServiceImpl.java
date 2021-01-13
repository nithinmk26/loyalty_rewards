package com.digital.productservice.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.productservice.dto.HouseHoldDto;
import com.digital.productservice.dto.ProductDto;
import com.digital.productservice.entity.Product;
import com.digital.productservice.repository.ProductServiceRepository;
import com.digital.productservice.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductServiceRepository productRepo;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	
	@Override
	public List<Product> getAllProoducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteProductByID(int id) {
		productRepo.deleteById(id);
		return "Successfully deleted";
	}

	@Override
	public String updateProductByID(int id , ProductDto productDto) {
		// TODO Auto-generated method stub
	if(productRepo.existsById(id))
	{
		
		Product product = modelMapper.map(productDto, Product.class);
		productRepo.saveAndFlush(product);
	}	
		return "updated";
	}



}
