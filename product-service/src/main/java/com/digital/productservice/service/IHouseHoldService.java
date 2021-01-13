package com.digital.productservice.service;

import java.util.List;

import com.digital.productservice.dto.HouseHoldItemDto;
import com.digital.productservice.exception.ProductServicePersistingException;

public interface IHouseHoldService {

	public String saveHouseHoldData(HouseHoldItemDto houseHoldDto) throws ProductServicePersistingException;

	public List<HouseHoldItemDto> getAllHouseHoldProducts();

}
