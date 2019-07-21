package com.app.service;
import com.app.pojos.*;
public interface ICustomerOrderService {
	
	public void addCustomerOrder(CustomerOrder customerOrder);
	
	public int getCustomerOrderGrandTotal(int cartId);
}
