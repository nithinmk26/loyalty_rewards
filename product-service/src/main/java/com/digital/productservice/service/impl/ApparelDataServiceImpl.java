package com.digital.productservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.productservice.dto.ApparelDataDto;
import com.digital.productservice.dto.BookDataDto;
import com.digital.productservice.entity.ApparelData;
import com.digital.productservice.entity.BookData;
import com.digital.productservice.repository.ApparelDataRepository;
import com.digital.productservice.service.IApparelDataService;

@Service
public class ApparelDataServiceImpl implements IApparelDataService{
	
	@Autowired
	private ApparelDataRepository apparelDataRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public String saveApparelData(ApparelDataDto appareldata) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public List<ApparelDataDto> getAllApparelProducts() {
		List<ApparelData> apparelData = apparelDataRepository.findAll();
		List<ApparelDataDto> apparelDataDtos = new ArrayList<ApparelDataDto>();
		for (ApparelData appData : apparelData) {
		
			ApparelDataDto apparelDataDtoobj = modelMapper.map(appData, ApparelDataDto.class);
			apparelDataDtos.add(apparelDataDtoobj);
		}
		return apparelDataDtos;
		
	}
}
