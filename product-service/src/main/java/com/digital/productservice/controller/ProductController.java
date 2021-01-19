package com.digital.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.productservice.dto.ApparelDataDto;
import com.digital.productservice.dto.BookDataDto;
import com.digital.productservice.dto.ElectronicAppliancesDto;
import com.digital.productservice.dto.HouseHoldItemDto;
import com.digital.productservice.dto.ProductDetailsData;
import com.digital.productservice.exception.LoyaltyRewardsGlobalAppException;
import com.digital.productservice.facade.ProductFacade;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author 
 *
 */
@RestController
@RequestMapping("/product")
@Api(value = "Product Service", description = "List of API's Available for Product Search and Product persisting.", tags = { "Product Service" })
public class ProductController {

	@Autowired
	private ProductFacade productFacade;

	@GetMapping("/book")
	@ApiOperation(value = " Fetching All Book Details from Database....")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Fetched List Of Book information"),
			@ApiResponse(code = 404,message = "Books Not Found in Database .."),
			@ApiResponse(code = 400,message = "Bad Request .."),@ApiResponse(code = 500,message = "Internal Server Error ..")})
	public ResponseEntity<List<BookDataDto>> getAllBookProducts() throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(productFacade.getAllBookProducts(),HttpStatus.OK);
	}

	@GetMapping("/apparel")
	@ApiOperation(value = " Fetching All Apparel Details from Database....")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Fetched List Of Apparel information"),
			@ApiResponse(code = 404,message = "Apparel Not Found in Database .."),
			@ApiResponse(code = 400,message = "Bad Request .."),@ApiResponse(code = 500,message = "Internal Server Error ..")})
	public ResponseEntity<List<ApparelDataDto>> getAllApparelProducts() throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(productFacade.getAllApparelProducts(),HttpStatus.OK);
	}

	@GetMapping("/electronic")
	@ApiOperation(value = " Fetching All Electronics Details from Database....")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Fetched List Of Electronics information"),
			@ApiResponse(code = 404,message = "Books Not Found in Database .."),
			@ApiResponse(code = 400,message = "Bad Request .."),@ApiResponse(code = 500,message = "Internal Server Error ..")})
	public ResponseEntity<List<ElectronicAppliancesDto>> getAllElectronicProducts(){
		return new ResponseEntity<>(productFacade.getAllElectronicProducts(),HttpStatus.OK);
	}

	@GetMapping("/household")
	@ApiOperation(value = " Fetching All HouseHoldItems Details from Database....")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Fetched List Of HouseHoldItems information"),
			@ApiResponse(code = 404,message = "Books Not Found in Database .."),
			@ApiResponse(code = 400,message = "Bad Request .."),@ApiResponse(code = 500,message = "Internal Server Error ..")})
	public ResponseEntity<List<HouseHoldItemDto>> getAllHouseProducts() throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(productFacade.getAllHouseHoldProducts(),HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete Product From DB based on Product ID....")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Deleted Product information from DB"),
			@ApiResponse(code = 404,message = "Product Not Found in Database .."),
			@ApiResponse(code = 400,message = "Bad Request .."),@ApiResponse(code = 500,message = "Internal Server Error ..")})
	public ResponseEntity<String> deleteProductById(@PathVariable int id)
	{
		return new ResponseEntity<>(productFacade.deleteProductByID(id),HttpStatus.OK);
	}

	@PostMapping("/book")
	@ApiOperation(value = "Persist Book Details in Database....")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully saved Book information in DB"),
			@ApiResponse(code = 400,message = "Bad Request .."),@ApiResponse(code = 500,message = "Internal Server Error ..")})
	public ResponseEntity<String> saveBookProduct(@RequestBody BookDataDto bookdata) throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(productFacade.saveBookData(bookdata),HttpStatus.CREATED);
	}

	@PostMapping("/apparel")
	@ApiOperation(value = "Persist Apparrel Details in Database....")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully saved Book information in DB"),
			@ApiResponse(code = 400,message = "Bad Request .."),@ApiResponse(code = 500,message = "Internal Server Error ..")})
	public ResponseEntity<String> saveApparelData(@RequestBody ApparelDataDto apparelDataDto) throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(productFacade.saveApparelData(apparelDataDto),HttpStatus.CREATED);
	}

	@PostMapping("/electronic")
	@ApiOperation(value = "Persist Electronics Details in Database....")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully saved Electronics information in DB"),
			@ApiResponse(code = 400,message = "Bad Request .."),@ApiResponse(code = 500,message = "Internal Server Error ..")})
	public ResponseEntity<String> saveElectronicApplianceData(@RequestBody ElectronicAppliancesDto electronicAppliancesDto) throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(productFacade.saveElectronicApplianceData(electronicAppliancesDto),HttpStatus.CREATED);
	}

	@PostMapping("/household")
	@ApiOperation(value = "Persist HouseHoldItem Details in Database....")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully saved HouseHoldItem information in DB"),
			@ApiResponse(code = 400,message = "Bad Request .."),@ApiResponse(code = 500,message = "Internal Server Error ..")})
	public ResponseEntity<String> saveHouseHoldData(@RequestBody HouseHoldItemDto houseHoldItemDto) throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(productFacade.saveHouseHoldData(houseHoldItemDto),HttpStatus.CREATED);
	}

	@GetMapping("/all")
	@ApiOperation(value = "Fetch all product Details from Database....")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Fetched product details from DB"),
			@ApiResponse(code = 404,message = "No Products found in DB .."),
			@ApiResponse(code = 400,message = "Bad Request .."),@ApiResponse(code = 500,message = "Internal Server Error ..")})
	public ResponseEntity<List<ProductDetailsData>> getAllProducts() throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(productFacade.getAllProducts(),HttpStatus.OK);
	}

	@GetMapping("/{productId}")
	@ApiOperation(value = "Fetch product based on Product ID from Database....")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Fetched product details from DB"),
			@ApiResponse(code = 404,message = "No Products found in DB .."),
			@ApiResponse(code = 400,message = "Bad Request .."),@ApiResponse(code = 500,message = "Internal Server Error ..")})
	public ResponseEntity<ProductDetailsData> fetchProductById(@PathVariable int productId) throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(productFacade.fetchProductById(productId),HttpStatus.OK);
	}



}
