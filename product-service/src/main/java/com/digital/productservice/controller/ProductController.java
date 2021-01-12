package com.digital.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

	
	@GetMapping("/")
	public String getAllProducts(){
		return " Welcome to Screen";
	}

	@GetMapping("/homePage")
	public String getHome(){
		return " Welcome to home Screen";
	}
	
}
