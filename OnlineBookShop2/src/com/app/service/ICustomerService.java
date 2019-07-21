package com.app.service;

import java.util.List;

import com.app.pojos.Customer;

public interface ICustomerService {


 void addCustomer(Customer customer);
	
Customer getCustomerById(int customerId);
	
List<Customer> getAllCustomers();

 Customer getCustomerByUsername(String username);
}
