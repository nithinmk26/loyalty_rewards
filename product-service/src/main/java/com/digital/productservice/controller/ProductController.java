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
	
	@GetMapping("/2")
	public List<Product> getAllProducts2(){
		return null;
	}
	
	@GetMapping("/3")
	public List<Product> getAllProducts3(){
		return null;
	}

	@GetMapping("/fromnithin1")
	public List<Product> getAllProductsFromNithin(){
		return null;
	}
	
	@GetMapping("/fromNithin")
	public List<Product> getAllProductsFromKoms(){
		return null;
	}
	
	@GetMapping("/fromKoms")
	public List<Product> getAllProductsFromKoms1(){
		return null;
	}
	
}
