package com.digital.productservice.service;

import java.util.List;

import com.digital.productservice.dto.HouseHoldDto;

public interface IHouseHoldService {
	
	public String saveHouseHoldData(HouseHoldDto houseHoldDto);

	public List<HouseHoldDto> getAllHouseHoldProducts();
	
}
