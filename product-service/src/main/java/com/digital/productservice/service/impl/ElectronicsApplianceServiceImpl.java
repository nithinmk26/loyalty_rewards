package com.digital.productservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.productservice.dto.ElectronicAppliancesDto;
import com.digital.productservice.entity.ElectronicAppliancesData;
import com.digital.productservice.exception.ProductServicePersistingException;
import com.digital.productservice.repository.ElectronicApplancesRepository;
import com.digital.productservice.service.IElectronicApplianceService;

@Service
public class ElectronicsApplianceServiceImpl implements IElectronicApplianceService {

	private ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private ElectronicApplancesRepository electronicApplancesRepository;

	@Override
	public String saveElectronicApplianceData(ElectronicAppliancesDto electronicappliancedto) throws ProductServicePersistingException {
		try{
			ElectronicAppliancesData electronicAppliancesData = modelMapper.map(electronicappliancedto, ElectronicAppliancesData.class);
			electronicAppliancesData = electronicApplancesRepository.save(electronicAppliancesData);
			return String.format("Apparel Data Successfully saved in DB with Product Id %d",electronicAppliancesData.getId());
		}catch (RuntimeException e) {
			throw new ProductServicePersistingException("Unable to save the Data...!!! Please try again");
		}
	}

	@Override
	public List<ElectronicAppliancesDto> getAllElectronicProducts() {
		List<ElectronicAppliancesData> electronicData = electronicApplancesRepository.findAll();
		List<ElectronicAppliancesDto> electronicDataDtoObj = new ArrayList<ElectronicAppliancesDto>();
		for (ElectronicAppliancesData electronicDataobj : electronicData) {

			ElectronicAppliancesDto electronicDataDto = modelMapper.map(electronicDataobj, ElectronicAppliancesDto.class);
			electronicDataDtoObj.add(electronicDataDto);
		}
		return electronicDataDtoObj;
	}

}
