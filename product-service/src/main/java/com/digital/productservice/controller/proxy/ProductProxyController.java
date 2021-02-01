package com.digital.productservice.controller.proxy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.productservice.dto.model.ProductItemModel;
import com.digital.productservice.exception.LoyaltyRewardsGlobalAppException;
import com.digital.productservice.facade.ProductFacade;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/product")
@Api(value = "Product Proxy Service", description = "List of API's Available for Product Proxies Consumed by other services.", tags = { "Product proxy Service" })
public class ProductProxyController {
	
	@Autowired
	private ProductFacade productFacade;
	
	@PostMapping("/avilability")
	@ApiOperation(value = " Varify the Product Availability from DataBase....")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Varified the availability of the product"),
			@ApiResponse(code = 404,message = "Books Not Found in Database .."),
			@ApiResponse(code = 400,message = "Bad Request .."),@ApiResponse(code = 500,message = "Internal Server Error ..")})
	public ResponseEntity<Boolean> getAllProductAvailability(@RequestBody List<ProductItemModel> productItemModel) throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(productFacade.getAllProductAvailability(productItemModel),HttpStatus.OK);
	}

}
