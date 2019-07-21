package com.app.pojos;
import javax.persistence.*;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="customer")
public class Customer{

	private Integer customerId;
	private String customeName,customerEmail,customerPhone,userName,password,address;
	private boolean enabled;
	private Cart cart;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	@NotEmpty(message = "The Customer name must not be empty")
	@Column(name="name")
	public String getCustomeName() {
		return customeName;
	}
	public void setCustomeName(String customeName) {
		this.customeName = customeName;
	}
	@NotEmpty(message = "The Customer email must not be empty")
	@Column(name="email")
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	@Column(name="phone")
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	@NotEmpty(message = "The Customer username must not be empty")
	@Column(name="username")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@NotEmpty(message = "The Customer password must not be empty")
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@OneToOne
	@JoinColumn(name="cartId")
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
