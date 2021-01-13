package com.digital.productservice.service.impl;


import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.digital.productservice.entity.HouseHoldItemData;
import com.digital.productservice.dto.HouseHoldItemDto;
import com.digital.productservice.entity.HouseHoldItemData;
import com.digital.productservice.exception.ProductServicePersistingException;
import com.digital.productservice.repository.HouseHoldItemRepository;
import com.digital.productservice.service.IHouseHoldService;

@Service
public class HouseHoldServiceImpl implements IHouseHoldService {
  
	@Autowired
	private HouseHoldItemRepository houseHoldItemRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public String saveHouseHoldData(HouseHoldItemDto houseHoldDto) throws ProductServicePersistingException {
		try{
			HouseHoldItemData houseHoldData = modelMapper.map(houseHoldDto, HouseHoldItemData.class);
		houseHoldData = houseHoldItemRepository.save(houseHoldData);
		return String.format("Apparel Data Successfully saved in DB with Product Id %d",houseHoldData.getId());
		}catch (RuntimeException e) {
			throw new ProductServicePersistingException("Unable to save the Data...!!! Please try again");

		}
	}

	@Override
	public List<HouseHoldItemDto> getAllHouseHoldProducts() {
		List<HouseHoldItemData> housedata = houseHoldItemRepository.findAll();
		List<HouseHoldItemDto> housedatadto = new ArrayList<HouseHoldItemDto>();
		for (HouseHoldItemData housedtoobj : housedata) {
		
			HouseHoldDto houseDataDto = modelMapper.map(housedtoobj, HouseHoldDto.class);
			housedatadto.add(houseDataDto);
		}
		return housedatadto;
	}
		
	
}
