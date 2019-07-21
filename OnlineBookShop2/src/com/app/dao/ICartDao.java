package com.app.dao;

import java.io.IOException;

import com.app.pojos.*;

public interface ICartDao {

	Cart getCartById(int cartId);
	
	Cart validate(int cartId) throws IOException;

	public void update(Cart cart);
	
}
