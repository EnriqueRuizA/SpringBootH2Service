package com.crud.h2.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.h2.model.Price;
import com.crud.h2.modelDAO.PricesDao;

@Service
public class PriceServiceImpl {

	@Autowired
	private PricesDao dao;

	public List<Price> getPrice(Date validationDate, Long productId, int brandId) {
		return dao.getPriceList(validationDate, productId, brandId);
	}
}
