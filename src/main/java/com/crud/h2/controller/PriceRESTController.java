package com.crud.h2.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.crud.h2.model.Price;
import com.crud.h2.model.PriceWithRestrictions;
import com.crud.h2.service.PriceService;

@RestController
public class PriceRESTController {

	private PriceService service;

	public PriceRESTController(PriceService service) {
		this.service = service;
	}

	String atributoListaPrecios = "listaPrecios";

	// http://localhost:8080/preciosFiltrados/2020-06-14%2000:00:00/35455/1
	
	@GetMapping(value = "/preciosFiltrados/{date}/{productId}/{brandId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PriceWithRestrictions> filteredPrices(@PathVariable String date, @PathVariable long productId,
			@PathVariable int brandId) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dateF = dateFormat.parse(date);
		List<Price> list = service.getFilteredPriceList(dateF, productId, brandId);

		return service.priceToPriceWithRestrictions(list);
	}

	@GetMapping("/listaPrecios")
	public List<Price> allPrices() {
		return service.getAllPrices();
	}
}
