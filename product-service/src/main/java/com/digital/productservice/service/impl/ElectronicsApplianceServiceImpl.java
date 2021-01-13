package com.digital.productservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.productservice.dto.ElectronicAppliancesDto;
import com.digital.productservice.entity.ApparelData;
import com.digital.productservice.entity.ElectronicAppliancesData;
import com.digital.productservice.exception.ProductServicePersistingException;
import com.digital.productservice.repository.ElectronicApplancesRepository;
import com.digital.productservice.service.IElectronicApplianceService;

@Service
public class ElectronicsApplianceServiceImpl implements IElectronicApplianceService {

	@Autowired
	private ElectronicApplancesRepository electronicApplancesRepository;
	
	private ModelMapper modelMapper  = new ModelMapper(); 
	
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

}
