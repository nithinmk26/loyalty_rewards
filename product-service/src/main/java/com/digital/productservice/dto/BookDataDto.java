package com.digital.productservice.dto;

import java.time.LocalDate;

import javax.persistence.Column;

public class BookDataDto {
	
	private String name;
	
	private String licenseNum;
	
	private double price;
	
	private int quantity;
	
	private String description;

	private String manufactureDate;
	
	private String returnwithin;
	
	private String genre ;
	
	private String author ;
	
	private String publisher;
	
	private LocalDate publishedDate;

	public BookDataDto(String name, String licenseNum, double price, int quantity, String description,
			String manufactureDate, String returnwithin, String genre, String author, String publisher,
			LocalDate publishedDate) {
		super();
		this.name = name;
		this.licenseNum = licenseNum;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
		this.manufactureDate = manufactureDate;
		this.returnwithin = returnwithin;
		this.genre = genre;
		this.author = author;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
	}

	public BookDataDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}