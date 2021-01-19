package com.digital.cart.utility;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.digital.cart.dto.CartDto;

import com.digital.cart.entity.CartDetail;
import com.digital.cart.dto.CartResponseDto;
import com.digital.cart.dto.ItemDto;
import com.digital.cart.entity.CartDetail;
import com.digital.cart.entity.Item;


public class UtilityMethods {
	
	private static ModelMapper modelMapper = new ModelMapper();

	public static CartResponseDto convertCartToDto(CartDetail cartDetail) {
		return modelMapper.map(cartDetail, CartResponseDto.class);
	}
	
	public static CartDetail convertCartDtotoEntity(CartDto cartDto) {
		CartDetail cart =  new CartDetail();
		List<Item> itemList = new ArrayList();
		for (ItemDto item : cartDto.getItemList()) {
			itemList.add(modelMapper.map(item, Item.class));
		}
		cart.setItemList(itemList);
		cart.setUserName(cartDto.getUserName());
		cart.setUserId(cartDto.getUserId());
		return cart;

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
