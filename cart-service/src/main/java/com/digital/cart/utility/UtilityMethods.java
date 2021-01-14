package com.digital.cart.utility;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.digital.cart.dto.CartDto;
import com.digital.cart.entity.CartDetail;

public class UtilityMethods {
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static CartDto convertCartToDto(CartDetail cartDetail) {
		return modelMapper.map(cartDetail, CartDto.class);
	}
	
	public static CartDetail convertCartDtotoEntity(CartDto cartDto) {
		return modelMapper.map(cartDto, CartDetail.class);
	}
	
	public static List<CartDto> convertListofCartToDto(List<CartDetail> listOfCartDetail){
		return listOfCartDetail.stream().map(cartDetail -> modelMapper.map(cartDetail, CartDto.class)).collect(Collectors.toList());
	}
	
	public static List<CartDetail> convertListofCartDtoToCartEntity(List<CartDto> listOfCartDto){
		return listOfCartDto.stream().map(cartDto -> modelMapper.map(cartDto, CartDetail.class)).collect(Collectors.toList());
	}
	
	
	private UtilityMethods() {
		
	}
	

}
