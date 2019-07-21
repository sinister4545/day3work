package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Users;
import com.app.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	// dependency
	@Autowired
	private IUserService service;

	public UserController() {
		System.out.println("in def constr of " + getClass().getName());
	}

	// req handling method to show login form
	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/user/login";
	}

	// req handling method to process login form
	@PostMapping("/login") // =@RequestMapping + method=post
	public String processLoginForm(Model map, 
			@RequestParam String username,
			@RequestParam String password,
			HttpSession hs) {
		System.out.println("in process login form");
		try {
			// invoke service layer method
			Users u = service.validateUser(username, password);
			// login success
			map.addAttribute("status", "Login Successful....");
			// store user details under session scope
			hs.setAttribute("user_dtls", u);
			// chk role
			/*
			 * if (v.getRole().equals("admin")) // admin login { return
			 * "redirect:/admin/list";//replace by redirect }
			 */
			// vendor login
			return "/user/successfull";
		} catch (RuntimeException e) {
			System.out.println("err in user controller " + e);
			// invalid login
			// add err mesg as model attribute ---req scope
			map.addAttribute("status", "Invalid Login , Pls retry!!!!");
			return "/user/login";
		}
		

	}
}
