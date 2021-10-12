package com.crud.h2.modelDAO;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.crud.h2.model.Price;

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
	List<Price> getFilteredPriceList(Date validationDate, Long productId, int brandId) throws ParseException;

	List<Price> getAllPrices();

}
