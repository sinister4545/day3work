package com.app.pojos;
import javax.persistence.*;

@Entity
@Table(name="cartItem")
public class CartItem{

	private Integer cartItemId,quantity;
	private Cart cart;
	private Book book;
	private double totalPrice;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cart_item_id")
	public Integer getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(Integer cartItemId) {
		this.cartItemId = cartItemId;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	@ManyToOne
	@JoinColumn(name="cartId")
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	@ManyToOne
	@JoinColumn(name="bookId")
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Column(name="total_price")
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
}
