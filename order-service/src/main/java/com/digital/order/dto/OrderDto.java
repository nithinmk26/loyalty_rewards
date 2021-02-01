package com.digital.order.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.digital.order.entity.Items;

public class OrderDto {

private int orderId;
	
	
	private String userId;
	
	private String userName;
	
	private List<Items> itemList;
	
	private LocalDateTime orderedDate;
	
	private int numOfItems;
	
	private double totalPrice;

}
