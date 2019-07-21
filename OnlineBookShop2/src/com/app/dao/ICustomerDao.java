package com.app.dao;

import java.util.List;

import com.app.pojos.Customer;

public interface ICustomerDao {

public void addCustomer(Customer customer);
	
	Customer getCustomerById(int customerId);
	
	List<Customer> getAllCustomers();

	public Customer getCustomerByUsername(String username);
}
