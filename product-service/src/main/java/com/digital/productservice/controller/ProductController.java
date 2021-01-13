package com.digital.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.productservice.dto.ApparelDataDto;
import com.digital.productservice.dto.BookDataDto;
import com.digital.productservice.dto.ProductDto;
import com.digital.productservice.entity.BookData;
import com.digital.productservice.entity.Product;
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

	@GetMapping("/book")
	public ResponseEntity<List<BookDataDto>> getAllBookProducts(){
		return new ResponseEntity<>(bookDataService.getAllBookProducts(),HttpStatus.OK);
	}
	
	@GetMapping("/apparel")
	public ResponseEntity<List<ApparelDataDto>> getAllApparelProducts(){
		return new ResponseEntity<>(apparelDataService.getAllApparelProducts(),HttpStatus.OK);
	}
	
	@GetMapping("/electronic")
	public ResponseEntity<List<ApparelDataDto>> getAllElectronicProducts(){
		return new ResponseEntity<>(apparelDataService.getAllApparelProducts(),HttpStatus.OK);
	}
	
	@GetMapping("/household")
	public ResponseEntity<List<ApparelDataDto>> getAllHouseProducts(){
		return new ResponseEntity<>(apparelDataService.getAllApparelProducts(),HttpStatus.OK);
	}
	
	@PostMapping("/book")
	public ResponseEntity<String> saveBookProducts(@RequestBody BookDataDto bookdata){

		return new ResponseEntity<>(bookDataService.saveBookData(bookdata),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> saveBookProducts(@PathVariable int id , @RequestBody ProductDto productDto)
	{
		return new ResponseEntity<>(productService.updateProductByID(id, productDto),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable int id)
	{
		return new ResponseEntity<>(productService.deleteProductByID(id),HttpStatus.OK);
	}
	
	
	
}
