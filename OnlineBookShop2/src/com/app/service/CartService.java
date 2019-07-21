package com.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dao.CartDao;
import com.app.pojos.Cart;
@Service
public class CartService implements ICartService {

	@Autowired
	private CartDao cartDao;
	
	@Override
	public Cart getCartById(int cartId) {
		
		return cartDao.getCartById(cartId);
	}

	@Override
	public void update(Cart cart) {
		
		cartDao.update(cart);

	}

}
