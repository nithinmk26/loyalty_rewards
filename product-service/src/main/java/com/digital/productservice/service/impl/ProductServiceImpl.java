package com.digital.productservice.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.digital.productservice.dto.ProductDto;
import com.digital.productservice.entity.Product;
import com.digital.productservice.dto.ProductDetailsData;
import com.digital.productservice.entity.Product;
import com.digital.productservice.exception.ProductServiceFetchingException;
import com.digital.productservice.repository.ProductRepository;
import com.digital.productservice.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
  private ProductRepository productRepository;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public String deleteProductByID(int id) {
		productRepository.deleteById(id);
		return "Successfully deleted";
	}

	@Override
	public String updateProductByID(int id , ProductDto productDto) {
		// TODO Auto-generated method stub
	if(productRepository.existsById(id))
  {
		Product product = modelMapper.map(productDto, Product.class);
		productRepository.saveAndFlush(product);
	}	
		return "updated";

	@Override
	public List<ProductDetailsData> getAllProducts() throws ProductServiceFetchingException {
		List<Product> productList = productRepository.findAll();
		productList.stream().findAny().orElseThrow(()->new ProductServiceFetchingException("NO Products Found in Database"));
		return productList.stream().map(product ->modelMapper.map(product, ProductDetailsData.class)).collect(Collectors.toList());
	}

	@Override
	public ProductDetailsData fetchProductById(int productId) throws ProductServiceFetchingException {
		Optional<Product> prdrsp = productRepository.findById(productId);
		return prdrsp.map(obj->modelMapper.map(obj, ProductDetailsData.class)).orElseThrow(()->new ProductServiceFetchingException(String.format("Product with product id %d id not found in Database", productId)));
	}



}
