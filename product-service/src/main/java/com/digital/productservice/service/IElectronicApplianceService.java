package com.digital.productservice.service;

import java.util.List;

import com.digital.productservice.dto.ElectronicAppliancesDto;

public interface IElectronicApplianceService {
	
	public String saveElectronicApplianceData(ElectronicAppliancesDto electronicappliancedata);

	public List<ElectronicAppliancesDto> getAllElectronicProducts();
}
