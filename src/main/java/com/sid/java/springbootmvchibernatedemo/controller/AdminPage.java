package com.sid.java.springbootmvchibernatedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sid.java.springbootmvchibernatedemo.entity.Farmer;
import com.sid.java.springbootmvchibernatedemo.service.FarmerService;

@Controller
public class AdminPage {
	
	
	@GetMapping("/user")
	public String getUser() {
		return"UserPage";
	}
	
	@GetMapping("/admin")
	public String getAdmin() {
		return"AdminHomepage";
	}
		
	@GetMapping("/")
	public String getHome() {
		return "Home";
	}
}
