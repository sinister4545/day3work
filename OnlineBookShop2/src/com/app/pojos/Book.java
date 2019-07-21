package com.app.pojos;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="book")
public class Book {

	
	
	private Integer bookId,bookPrice,bookInStock;
	private String bookName,bookDescription,bookPublication,bookCondition,bookCategory;
	
	private List<CartItem> cartItemList;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="book_id")
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	@Min(value=0,message="The book price must not be less than zero")
	@Column(name="price")
	public Integer getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(Integer bookPrice) {
		this.bookPrice = bookPrice;
	}
	@Min(value=0,message="The book unit must not be less than zero")
	@Column(name="instock")
	public Integer getBookInStock() {
		return bookInStock;
	}
	public void setBookInStock(Integer bookInStock) {
		this.bookInStock = bookInStock;
	}
	@NotEmpty(message = "The  Book name must not be null")
	@Column(name="name")
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	@Column(name="description")
	public String getBookDescription() {
		return bookDescription;
	}
	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}
	@Column(name="publication")
	public String getBookPublication() {
		return bookPublication;
	}
	public void setBookPublication(String bookPublication) {
		this.bookPublication = bookPublication;
	}
	@Column(name="category")
	public String getBookCategory() {
		return bookCategory;
	}
	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
	
	@OneToMany(mappedBy = "book",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	public List<CartItem> getCartItemList() {
		return cartItemList;
	}
	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}
	@Column(name="book_condition")
	public String getBookCondition() {
		return bookCondition;
	}
	public void setBookCondition(String bookCondition) {
		this.bookCondition = bookCondition;
	}
	
	

	
}
