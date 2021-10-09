package com.crud.h2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.crud.h2.service.PriceService;
import com.crud.h2.service.PriceServiceImpl;

@Controller
public class PriceController {
	
	@Autowired
	private PriceServiceImpl service;
	
	@GetMapping("/precio")
	public String precio(Model model) {
		
		model.addAttribute("precio", service.getPrice(null, null, 0));
		return "index";
		
	}
	

}
