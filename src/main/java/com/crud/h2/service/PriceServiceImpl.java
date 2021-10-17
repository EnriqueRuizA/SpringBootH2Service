package com.crud.h2.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.h2.dao.PricesDao;
import com.crud.h2.model.PriceModel;
import com.crud.h2.model.PriceWithRestrictions;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	private PricesDao dao;

	public List<PriceModel> getAllPrices() {
		return dao.getAllPrices();
	}

	public List<PriceModel> getFilteredPriceList(Date validationDate, Long productId, int brandId) throws ParseException {
		return dao.getFilteredPriceList(validationDate, productId, brandId);
	}
	
	public List<PriceWithRestrictions> priceToPriceWithRestrictions(List<PriceModel> priceList) {

		List<PriceWithRestrictions> priceWithRestrictionsList = new ArrayList<>() ;

		for (PriceModel price : priceList) {
			PriceWithRestrictions priceWithRestrictions = new PriceWithRestrictions();
			priceWithRestrictions.setBrandId(price.getBrandId());
			priceWithRestrictions.setEndDate(price.getEndDate());
			priceWithRestrictions.setPrice(price.getPrice());
			priceWithRestrictions.setPriceList(price.getPriceList());
			priceWithRestrictions.setProductId(price.getProductId());
			priceWithRestrictions.setStartDate(price.getStartDate());
			priceWithRestrictionsList.add(priceWithRestrictions);
		}
		return priceWithRestrictionsList;
	}
}
