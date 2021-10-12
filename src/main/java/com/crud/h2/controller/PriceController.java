package com.crud.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.crud.h2.model.Price;
import com.crud.h2.service.PriceService;
import com.crud.h2.service.PriceServiceImpl;

@Controller
public class PriceController {

	private PriceService service;

	public PriceController(PriceService service) {
		this.service = service;
	}

	@GetMapping("/listaPreciosJSP")
	public String allPricesJSP(Model model) {
		List<Price> list = service.getAllPrices();
		model.addAttribute("listaPrecios", list);
		return "listaPrecios";
	}
}
