package com.crud.h2.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.crud.h2.model.Price;
import com.crud.h2.model.PriceWithRestrictions;

public interface PriceService {

	List<Price> getAllPrices();
	
	List<Price> getPrice(Date validationDate, Long productId, int brandId) throws ParseException;

	List<Price> getFilteredPriceList(Date validationDate, Long productId, int brandId) throws ParseException;
	
	List<PriceWithRestrictions> priceToPriceWithRestrictions(List<Price> priceList);

}
