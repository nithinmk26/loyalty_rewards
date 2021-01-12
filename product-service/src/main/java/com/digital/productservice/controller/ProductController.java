package com.digital.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.productservice.service.IApparelDataService;
import com.digital.productservice.service.IBookDataService;
import com.digital.productservice.service.IElectronicApplianceService;
import com.digital.productservice.service.IHouseHoldService;
import com.digital.productservice.service.IProductService;

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
	
	
	@GetMapping("/abc")
	public String getAllProducts(){
		return " Welcome to Screen";
	}
	
}