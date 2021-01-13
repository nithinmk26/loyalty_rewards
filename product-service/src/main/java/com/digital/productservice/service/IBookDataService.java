package com.digital.productservice.service;

import java.util.List;

import com.digital.productservice.dto.BookDataDto;
import com.digital.productservice.exception.LoyaltyRewardsGlobalAppException;
import com.digital.productservice.exception.ProductServiceFetchingException;
import com.digital.productservice.exception.ProductServicePersistingException;

public interface IBookDataService {
	
	
	public List<BookDataDto> getAllBookProducts() throws ProductServiceFetchingException;

	public String saveBookData(BookDataDto bookdata) throws ProductServicePersistingException;

}
