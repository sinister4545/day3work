package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.app.pojos.Customer;
import com.app.service.ICustomerService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
@Autowired
public ICustomerService service;

public RegisterController() {
		super();
		System.out.println("in constr of " + getClass().getName());
	}
@GetMapping("/register")
public String registerCustomer(Model model) {
		
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "/register";
	}

@PostMapping("/register")
public String registerCustomerPost(Customer customer, Model model)
{	
	List<Customer> customerList = service.getAllCustomers();
	for(int i=0;i<customerList.size();i++)
	{
		if(customer.getCustomerEmail().equals(customerList.get(i).getCustomerEmail()))
		{
			model.addAttribute("emailMsg", "Email already exists");
			
			return "registerCustomer";
		}
		
		if(customer.getUserName().equals(customerList.get(i).getUserName()))
		{
			model.addAttribute("usernameMsg", "Username already exists");
			
			return "registerCustomer";
		}
	}
	customer.setEnabled(true);
	service.addCustomer(customer);
	model.addAttribute("usernameMsg", "RegisterSucessfully");
	return "/user/login"; //should lead to back to log in
}
}
