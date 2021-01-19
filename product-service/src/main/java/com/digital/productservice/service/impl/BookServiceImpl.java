package com.digital.productservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.productservice.dto.BookDataDto;
import com.digital.productservice.entity.BookData;
import com.digital.productservice.exception.ProductServiceFetchingException;
import com.digital.productservice.exception.ProductServicePersistingException;
import com.digital.productservice.repository.BookDataRepository;
import com.digital.productservice.service.IBookDataService;

@Service
public class BookServiceImpl implements IBookDataService {

	@Autowired
	private BookDataRepository bookDataRepository;

	private ModelMapper modelMapper = new ModelMapper();


	@Override
	public String saveBookData(BookDataDto bookdata) throws ProductServicePersistingException {
		try {
			BookData bookentitydata = modelMapper.map(bookdata, BookData.class);
			bookentitydata = bookDataRepository.save(bookentitydata);
			return String.format("Book Successfully saved in DB with Product Id %d",bookentitydata.getId());
		}
		catch (RuntimeException e) {
			throw new ProductServicePersistingException("Unable to save the Data...!!! Please try again");
		}
	}

	@Override
	public List<BookDataDto> getAllBookProducts() throws ProductServiceFetchingException {
		List<BookData> bookdata = bookDataRepository.findAll();
		bookdata.stream().findAny().orElseThrow(()->new ProductServiceFetchingException("No Products Found in Database"));
		return bookdata.stream().map((product)->modelMapper.map(product,BookDataDto.class)).collect(Collectors.toList());

	}

}
