package com.digital.productservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.productservice.entity.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

	
	@GetMapping("/")
	public List<Product> getAllProducts(){
		return null;
	}
	
	
	
		
}
