package com.digital.productservice.service;

import com.digital.productservice.dto.ElectronicAppliancesDto;
import com.digital.productservice.exception.ProductServicePersistingException;

public interface IElectronicApplianceService {
	
	public String saveElectronicApplianceData(ElectronicAppliancesDto electronicappliancedata) throws ProductServicePersistingException;

}
