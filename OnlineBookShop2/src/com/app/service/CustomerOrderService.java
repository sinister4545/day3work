package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dao.*;
import com.app.pojos.*;

@Service
public class CustomerOrderService implements ICustomerOrderService {

	@Autowired
	private CustomerOrderDao customerOrderDao;
	
	@Autowired
	private CartService cartService;
	
	@Override
	public void addCustomerOrder(CustomerOrder customerOrder) {
		
		customerOrderDao.addCustomerOrder(customerOrder);

	}

	@Override
	public int getCustomerOrderGrandTotal(int cartId) {
		
		int grandTotal = 0;
		Cart cart = cartService.getCartById(cartId);
		List<CartItem> cartItems = cart.getCartItems();
		
		for(CartItem item: cartItems) {
			grandTotal += item.getTotalPrice();
			
		}
		return grandTotal;
	}

}
