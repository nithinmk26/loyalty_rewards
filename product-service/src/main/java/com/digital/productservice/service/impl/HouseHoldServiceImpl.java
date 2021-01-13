package com.digital.productservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.productservice.dto.BookDataDto;
import com.digital.productservice.dto.ElectronicAppliancesDto;
import com.digital.productservice.dto.HouseHoldDto;
import com.digital.productservice.entity.BookData;
import com.digital.productservice.entity.HouseHoldItemData;
import com.digital.productservice.repository.HouseHoldItemRepository;
import com.digital.productservice.service.IHouseHoldService;

@Service
public class HouseHoldServiceImpl implements IHouseHoldService {
	
	@Autowired
	private HouseHoldItemRepository householdItemrepository;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public String saveHouseHoldData(HouseHoldDto houseHoldDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HouseHoldDto> getAllHouseHoldProducts() {
		List<HouseHoldItemData> housedata = householdItemrepository.findAll();
		List<HouseHoldDto> housedatadto = new ArrayList<HouseHoldDto>();
		for (HouseHoldItemData housedtoobj : housedata) {
		
			HouseHoldDto houseDataDto = modelMapper.map(housedtoobj, HouseHoldDto.class);
			housedatadto.add(houseDataDto);
		}
		return housedatadto;
	}
		
	
}
