package com.crud.h2.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.h2.model.Price;
import com.crud.h2.modelDAO.PricesDao;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	private PricesDao dao;

	public List<Price> getPrice(Date validationDate, Long productId, int brandId) throws ParseException {
		return dao.getFilteredPriceList(validationDate, productId, brandId);
	}

	public List<Price> getAllPrices() {
		return dao.getAllPrices();
	}

	public List<Price> getFilteredPriceList(Date validationDate, Long productId, int brandId) throws ParseException {
		return dao.getFilteredPriceList(validationDate, productId, brandId);
	}
}
