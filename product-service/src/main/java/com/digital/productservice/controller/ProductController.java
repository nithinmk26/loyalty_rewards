package com.digital.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

	
	@GetMapping("/abc")
	public String getAllProducts(){
		return " Welcome to Screen";
	}

	@GetMapping("/bcd")
	public String getHome(){
		return " Welcome to BCD";
	}
	
}
