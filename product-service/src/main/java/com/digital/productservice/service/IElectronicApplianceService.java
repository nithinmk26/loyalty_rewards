package com.digital.productservice.service;

import java.util.List;

import com.digital.productservice.dto.ElectronicAppliancesDto;
import com.digital.productservice.exception.ProductServicePersistingException;

public interface IElectronicApplianceService {
	
	public String saveElectronicApplianceData(ElectronicAppliancesDto electronicappliancedata) throws ProductServicePersistingException;

	public List<ElectronicAppliancesDto> getAllElectronicProducts();
}
