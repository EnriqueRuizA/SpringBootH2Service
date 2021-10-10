package com.crud.h2.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.crud.h2.model.Price;
import com.crud.h2.service.PriceServiceImpl;

@Controller
public class PriceController {

	@Autowired
	private PriceServiceImpl service;

	String atributoListaPrecios = "listaPrecios";
	String nombreJspDestino = "listaPrecios";

	@GetMapping("/preciosFiltrados/{fecha}/{producto}/{cadena}")
	public String filteredPrices(Model model, @PathVariable String fecha, @PathVariable long producto,
			@PathVariable int cadena) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = dateFormat.parse(fecha);
		List<Price> list = service.getPrice(date, producto, cadena);
		model.addAttribute(atributoListaPrecios, list);
		return nombreJspDestino;
	}

	@GetMapping("/listaPrecios")
	public String allPrices(Model model) {
		List<Price> list = (List<Price>) service.getAllPrices();
		model.addAttribute(atributoListaPrecios, list);
		return nombreJspDestino;

	}

}
