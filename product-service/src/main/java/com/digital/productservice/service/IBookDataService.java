package com.digital.productservice.service;

import java.util.List;

import com.digital.productservice.dto.BookDataDto;
import com.digital.productservice.exception.LoyaltyRewardsGlobalAppException;
import com.digital.productservice.exception.ProductServicePersistingException;

public interface IBookDataService {
	
	
	public List<BookDataDto> getAllBookProducts();

	public String saveBookData(BookDataDto bookdata) throws ProductServicePersistingException;

}
