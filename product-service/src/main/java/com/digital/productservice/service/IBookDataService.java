package com.digital.productservice.service;

import java.util.List;

import com.digital.productservice.dto.BookDataDto;

public interface IBookDataService {
	
	public String saveBookData(BookDataDto bookdata);
	
	public List<BookDataDto> getAllBookProducts();

}
