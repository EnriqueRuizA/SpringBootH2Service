package com.crud.h2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.crud.h2.model.PriceModel;
import com.crud.h2.service.PriceService;

@Controller
public class PriceJSPController {

	private PriceService service;

	public PriceJSPController(PriceService service) {
		this.service = service;
	}

	@GetMapping("/listaPreciosJSP")
	public String allPricesJSP(Model model) {
		List<PriceModel> list = service.getAllPrices();
		model.addAttribute("listaPrecios", list);
		return "listaPrecios";
	}
}
