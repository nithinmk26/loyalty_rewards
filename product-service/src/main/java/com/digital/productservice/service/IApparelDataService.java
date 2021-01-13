package com.digital.productservice.service;

import java.util.List;

import com.digital.productservice.dto.ApparelDataDto;
import com.digital.productservice.dto.BookDataDto;

public interface IApparelDataService {
	
	public String saveApparelData(ApparelDataDto appareldata);
	
	public List<ApparelDataDto> getAllApparelProducts();
}
