/**
 * 
 */
package com.digital.productservice.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Loyalty_digiTeam
 *
 */

@Entity
@Table(name = "book_details")
public class BookData extends Product {

	@Column(name = "book_genre")
	private String genre ;

	@Column(name = "book_author")
	private String author ;

	@Column(name = "book_publisher")
	private String publisher;

	@Column(name = "book_publisherdate")
	private LocalDate publishedDate;

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * @return the publishedDate
	 */
	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	/**
	 * @param publishedDate the publishedDate to set
	 */
	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}

	/**
	 * @param id
	 * @param name
	 * @param licenseNum
	 * @param price
	 * @param quantity
	 * @param description
	 * @param manufactureDate
	 * @param returnwithin
	 * @param genre
	 * @param author
	 * @param publisher
	 * @param publishedDate
	 */
	public BookData(int id, String name, String licenseNum, double price, int quantity, String description,
			String manufactureDate, String returnwithin, String genre, String author, String publisher,
			LocalDate publishedDate) {
		super(id, name, licenseNum, price, quantity, description, manufactureDate, returnwithin);
		this.genre = genre;
		this.author = author;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
	}

	/**
	 * 
	 */
	public BookData() {
		super();
		// TODO Auto-generated constructor stub
	}




}
