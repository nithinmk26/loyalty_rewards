/**
 * 
 */
package com.digital.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.cart.repository.CartRepository;

import io.swagger.annotations.Api;

/**
 * @author Loyalty_Digiteam
 *
 */
@RestController
@Api(value = "Cart Service", description = "List of API's Available for Cart CRUD.", tags = { "Cart Service" })
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartRepository cartRepo;
	
//	@PostMapping("/add")
//	public CartDetail addCart(@RequestBody CartDetail cartDetail) {
//		return cartRepo.save(cartDetail);
//	}
//	
//	@GetMapping("/get")
//	public List<CartDetail> get() {
//		List<CartDetail> cartDetails =  new ArrayList<>();
//		cartDetails =  cartRepo.findAll();
//		return cartDetails;
//	}

//	@GetMapping("/book")
//	@ApiOperation(value = " Fetching All Book Details from Database....")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Fetched List Of Book information"),
//			@ApiResponse(code = 404,message = "Books Not Found in Database .."),
//			@ApiResponse(code = 400,message = "Bad Request .."),@ApiResponse(code = 500,message = "Internal Server Error ..")})
//	public ResponseEntity<List<BookDataDto>> getAllBookProducts() throws LoyaltyRewardsGlobalAppException{
//		return new ResponseEntity<>(bookDataService.getAllBookProducts(),HttpStatus.OK);
//	}

}
