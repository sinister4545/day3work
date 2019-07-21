package com.app.service;

import com.app.pojos.Cart;

public interface ICartService {

	public Cart getCartById(int cartId);
	
	public void update(Cart cart);
}
