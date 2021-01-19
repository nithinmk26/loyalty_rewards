package com.digital.productservice.service;

import java.util.List;

import com.digital.productservice.dto.ApparelDataDto;
import com.digital.productservice.exception.ProductServicePersistingException;


public interface IApparelDataService {
	
	public String saveApparelData(ApparelDataDto appareldata) throws ProductServicePersistingException;
  
	public List<ApparelDataDto> getAllApparelProducts() throws ProductServicePersistingException;
}
