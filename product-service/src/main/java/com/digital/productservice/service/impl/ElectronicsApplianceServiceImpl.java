package com.digital.productservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.productservice.dto.BookDataDto;
import com.digital.productservice.dto.ElectronicAppliancesDto;
import com.digital.productservice.entity.BookData;
import com.digital.productservice.entity.ElectronicAppliancesData;
import com.digital.productservice.repository.ElectronicApplancesRepository;
import com.digital.productservice.service.IElectronicApplianceService;

@Service
public class ElectronicsApplianceServiceImpl implements IElectronicApplianceService {
	
	@Autowired
	private ElectronicApplancesRepository electroniceApplianceRepository;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public String saveElectronicApplianceData(ElectronicAppliancesDto electronicappliancedata) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ElectronicAppliancesDto> getAllElectronicProducts() {
		List<ElectronicAppliancesData> electronicData = electroniceApplianceRepository.findAll();
		List<ElectronicAppliancesDto> electronicDataDtoObj = new ArrayList<ElectronicAppliancesDto>();
		for (ElectronicAppliancesData electronicDataobj : electronicData) {
		
			ElectronicAppliancesDto electronicDataDto = modelMapper.map(electronicDataobj, ElectronicAppliancesDto.class);
			electronicDataDtoObj.add(electronicDataDto);
		}
		return electronicDataDtoObj;
	}
		
}
