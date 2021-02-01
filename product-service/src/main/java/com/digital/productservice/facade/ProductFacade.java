package com.digital.productservice.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.productservice.dto.ApparelDataDto;
import com.digital.productservice.dto.BookDataDto;
import com.digital.productservice.dto.ElectronicAppliancesDto;
import com.digital.productservice.dto.HouseHoldItemDto;
import com.digital.productservice.dto.ProductDetailsData;
import com.digital.productservice.dto.model.ProductItemModel;
import com.digital.productservice.exception.LoyaltyRewardsGlobalAppException;
import com.digital.productservice.exception.ProductServiceFetchingException;
import com.digital.productservice.exception.ProductServicePersistingException;
import com.digital.productservice.exception.ProductUnavailabilityException;
import com.digital.productservice.service.IApparelDataService;
import com.digital.productservice.service.IBookDataService;
import com.digital.productservice.service.IElectronicApplianceService;
import com.digital.productservice.service.IHouseHoldService;
import com.digital.productservice.service.IProductService;

@Service
public class ProductFacade {


	@Autowired
	private IProductService productService;

	@Autowired
	private IElectronicApplianceService electronicApplianceservice;

	@Autowired
	private IHouseHoldService houseHoldService;

	@Autowired
	private IBookDataService bookDataService;

	@Autowired
	private IApparelDataService apparelDataService;

	public List<BookDataDto> getAllBookProducts() throws LoyaltyRewardsGlobalAppException {
		return bookDataService.getAllBookProducts();
	}

	public List<ApparelDataDto> getAllApparelProducts() throws LoyaltyRewardsGlobalAppException {
		return apparelDataService.getAllApparelProducts();
	}

	public List<ElectronicAppliancesDto> getAllElectronicProducts() {
		return electronicApplianceservice.getAllElectronicProducts();
	}

	public List<HouseHoldItemDto> getAllHouseHoldProducts() throws LoyaltyRewardsGlobalAppException {
		return houseHoldService.getAllHouseHoldProducts();
	}

	public String deleteProductByID(int id) {
		return productService.deleteProductByID(id);
	}

	public String saveBookData(BookDataDto bookdata) throws LoyaltyRewardsGlobalAppException {
		return bookDataService.saveBookData(bookdata);
	}

	public String saveApparelData(ApparelDataDto apparelDataDto) throws LoyaltyRewardsGlobalAppException {
		return apparelDataService.saveApparelData(apparelDataDto);
	}

	public String saveElectronicApplianceData(ElectronicAppliancesDto electronicAppliancesDto) throws LoyaltyRewardsGlobalAppException {
		return electronicApplianceservice.saveElectronicApplianceData(electronicAppliancesDto);
	}

	public String saveHouseHoldData(HouseHoldItemDto houseHoldItemDto) throws LoyaltyRewardsGlobalAppException {
		return houseHoldService.saveHouseHoldData(houseHoldItemDto);
	}

	public List<ProductDetailsData> getAllProducts() throws LoyaltyRewardsGlobalAppException {
		return productService.getAllProducts();
	}

	public ProductDetailsData fetchProductById(int productId) throws LoyaltyRewardsGlobalAppException {
		return productService.fetchProductById(productId);
	}

	public Boolean getAllProductAvailability(List<ProductItemModel> productItemModel) throws LoyaltyRewardsGlobalAppException {
		return productService.getAllProductAvailability(productItemModel);
	}


	

	
}
