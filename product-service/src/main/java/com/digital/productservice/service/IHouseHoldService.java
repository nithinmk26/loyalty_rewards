package com.digital.productservice.service;

import com.digital.productservice.dto.HouseHoldItemDto;
import com.digital.productservice.exception.ProductServicePersistingException;

public interface IHouseHoldService {
	
	public String saveHouseHoldData(HouseHoldItemDto houseHoldDto) throws ProductServicePersistingException;

}
