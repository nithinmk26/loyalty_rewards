package com.digital.productservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.productservice.dto.ProductDetailsData;
import com.digital.productservice.dto.model.ProductItemModel;
import com.digital.productservice.entity.Product;
import com.digital.productservice.exception.LoyaltyRewardsGlobalAppException;
import com.digital.productservice.exception.ProductServiceFetchingException;
import com.digital.productservice.exception.ProductUnavailabilityException;
import com.digital.productservice.repository.ProductRepository;
import com.digital.productservice.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository productRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public String deleteProductByID(int id) throws LoyaltyRewardsGlobalAppException {
		if(productRepository.existsById(id)) {
		productRepository.deleteById(id);
		}
		else
			throw new ProductServiceFetchingException(String.format("Product With ID %s is not found in Database...",id));
		return "Successfully deleted";
	}

	@Override
	public List<ProductDetailsData> getAllProducts() throws ProductServiceFetchingException {
		List<Product> productList = productRepository.findAll();
		productList.stream().findAny().orElseThrow(()->new ProductServiceFetchingException("NO Products Found in Database"));
		return productList.stream().map(product ->modelMapper.map(product, ProductDetailsData.class)).collect(Collectors.toList());
	}

	@Override
	public ProductDetailsData fetchProductById(int productId) throws ProductServiceFetchingException {
		Optional<Product> productResponse = productRepository.findById(productId);
		return productResponse.map(obj->modelMapper.map(obj, ProductDetailsData.class)).orElseThrow(()->new ProductServiceFetchingException(String.format("Product with product id %d id not found in Database", productId)));
	}

	@Override
	public Boolean getAllProductAvailability(List<ProductItemModel> productItemModels) throws ProductUnavailabilityException {
		Set<Integer> setOfProductIds = productItemModels.stream().map(item->item.getProductId()).collect(Collectors.toSet());
		List<Product> productsFetchedFromDB = productRepository.findAllById(setOfProductIds);
		
		List<String> productUnavailability = verifyAvailabilityOfProducts(productItemModels,productsFetchedFromDB);
		if (!productUnavailability.isEmpty()) {
			StringBuilder message = new StringBuilder();
			for (String msg : productUnavailability) {
				message = message.append(System.lineSeparator()).append(msg);
			}
			throw new ProductUnavailabilityException(message.toString());
		}
		return true;
	}
	
	public List<String> verifyAvailabilityOfProducts(List<ProductItemModel> productItemModels,List<Product> productsFetchedFromDB){
		List<String> productUnavailability = new ArrayList<>();
		for (ProductItemModel productInCart : productItemModels) {
			boolean result = true;
			for (Product productInDB : productsFetchedFromDB) {
				if(productInDB.getId() == productInCart.getProductId()) {
					if(productInCart.getQuantity() <= productInDB.getQuantity()) {
						result = false;
					}
					else if(productInCart.getQuantity() > productInDB.getQuantity()) {
						productUnavailability.add(String.format("Product ID %d doesnt have %d quantity in DB, To Make a purchase please reduce to %d or below",productInCart.getProductId(), productInCart.getQuantity(),productInDB.getQuantity()));
						result = false;
					}
				}
			}
			if(result) {
				productUnavailability.add(String.format("Product ID - %d is not found in Inventory",productInCart.getProductId()));
			}
		}
		return productUnavailability;
	}

	@Override
	public void updateProductByIdAndQuantity(int productId, int quantity) throws LoyaltyRewardsGlobalAppException {
		Optional<Product> product = productRepository.findById(productId);
		if(product.get().getQuantity() < quantity) {
			throw new ProductServiceFetchingException(String.format(" Product Id %d does not have %d quatity available..", productId, quantity));
		}
		product.get().setQuantity(product.get().getQuantity() - quantity);
		if(product.get().getQuantity() == 0) {
			productRepository.deleteById(productId);
		}
		else {
			productRepository.saveAndFlush(product.get());
		}
	}



}
