package com.digital.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.productservice.dto.ApparelDataDto;
import com.digital.productservice.dto.BookDataDto;
import com.digital.productservice.dto.ElectronicAppliancesDto;
import com.digital.productservice.dto.HouseHoldItemDto;
import com.digital.productservice.dto.ProductDetailsData;
import com.digital.productservice.exception.LoyaltyRewardsGlobalAppException;
import com.digital.productservice.exception.ProductServiceFetchingException;
import com.digital.productservice.service.IApparelDataService;
import com.digital.productservice.service.IBookDataService;
import com.digital.productservice.service.IElectronicApplianceService;
import com.digital.productservice.service.IHouseHoldService;
import com.digital.productservice.service.IProductService;

/**
 * @author 
 *
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@Autowired
	private IElectronicApplianceService electronicApplianceservice;
	
	@Autowired
	private IHouseHoldService houseHoldService;
	
	@Autowired
	private IBookDataService bookDataService;
	
	@Autowired
	private IApparelDataService apparelDataService;

	@GetMapping("/books")
	public ResponseEntity<List<BookDataDto>> getAllBookProducts() throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(bookDataService.getAllBookProducts(),HttpStatus.OK);
	}
	
	@PostMapping("/book")
	public ResponseEntity<String> saveBookProduct(@RequestBody BookDataDto bookdata) throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(bookDataService.saveBookData(bookdata),HttpStatus.CREATED);
	}
	
	@PostMapping("/apparel")
	public ResponseEntity<String> saveApparelData(@RequestBody ApparelDataDto apparelDataDto) throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(apparelDataService.saveApparelData(apparelDataDto),HttpStatus.CREATED);
	}
	
	@PostMapping("/electronics")
	public ResponseEntity<String> saveElectronicApplianceData(@RequestBody ElectronicAppliancesDto electronicAppliancesDto) throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(electronicApplianceservice.saveElectronicApplianceData(electronicAppliancesDto),HttpStatus.CREATED);
	}
	
	@PostMapping("/house")
	public ResponseEntity<String> saveHouseHoldData(@RequestBody HouseHoldItemDto houseHoldItemDto) throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(houseHoldService.saveHouseHoldData(houseHoldItemDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<ProductDetailsData>> getAllProducts() throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<ProductDetailsData> fetchProductById(@PathVariable int productId) throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(productService.fetchProductById(productId),HttpStatus.OK);
	}
	
//	@PutMapping("/{productId}")
//	public ResponseEntity<String> updateProductById(@PathVariable int productId, @RequestBody ProductDetailsData productDetailsToUpdate) throws LoyaltyRewardsGlobalAppException{
//		return new ResponseEntity<>(productService.updateProductById(productId),HttpStatus.OK);
//	}
	

	 
	 
	
}
