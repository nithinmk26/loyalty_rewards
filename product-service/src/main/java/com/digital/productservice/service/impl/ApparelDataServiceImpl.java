package com.digital.productservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.productservice.dto.ApparelDataDto;
import com.digital.productservice.entity.ApparelData;
import com.digital.productservice.exception.ProductServicePersistingException;
import com.digital.productservice.repository.ApparelDataRepository;
import com.digital.productservice.service.IApparelDataService;

@Service
public class ApparelDataServiceImpl implements IApparelDataService{

	@Autowired
	private ApparelDataRepository apparelDataRepository;

	private ModelMapper modelMapper = new ModelMapper();


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

	@Override
	public String saveApparelData(ApparelDataDto appareldto) throws ProductServicePersistingException {
		try {
			ApparelData apparelData = modelMapper.map(appareldto, ApparelData.class);
			apparelData = apparelDataRepository.save(apparelData);
			return String.format("Apparel Data Successfully saved in DB with Product Id %d",apparelData.getId());
		}
		catch(RuntimeException e) {
			throw new ProductServicePersistingException("Unable to save the Data...!!! Please try again");
		}

	}
}
