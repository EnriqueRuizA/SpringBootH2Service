package com.crud.h2.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.crud.h2.model.PriceModel;
import com.crud.h2.model.PriceWithRestrictions;

public interface PriceService {

	List<PriceModel> getAllPrices();
	
	List<PriceModel> getFilteredPriceList(Date validationDate, Long productId, int brandId) throws ParseException;
	
	List<PriceWithRestrictions> priceToPriceWithRestrictions(List<PriceModel> priceList);

}
