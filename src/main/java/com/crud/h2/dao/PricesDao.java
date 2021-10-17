package com.crud.h2.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.crud.h2.model.PriceModel;

public interface PricesDao {

	/**
	 * 
	 * Método central de la prueba
	 * 
	 * @param validationDate
	 * @param productId
	 * @param brandId
	 * @return List [PriceWithRestrictions]
	 * @throws ParseException
	 */
	List<PriceModel> getFilteredPriceList(Date validationDate, Long productId, int brandId) throws ParseException;

	List<PriceModel> getAllPrices();

}
