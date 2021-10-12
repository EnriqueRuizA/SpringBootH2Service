package com.crud.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.crud.h2.model.Price;
import com.crud.h2.service.PriceServiceImpl;

@Controller
public class PriceController {

	@Autowired
	private PriceServiceImpl service;

	String atributoListaPrecios = "listaPrecios";

	// http://localhost:8080/preciosFiltrados/2020-06-14%2000:00:00/35455/1
	@GetMapping("/listaPreciosJSP")
	public String allPricesJSP(Model model) {
		List<Price> list = service.getAllPrices();
		model.addAttribute(atributoListaPrecios, list);
		return "listaPrecios";

	}
}
