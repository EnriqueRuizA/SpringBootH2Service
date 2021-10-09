package com.crud.h2.modelDAO;

import java.util.Date;
import java.util.List;

import com.crud.h2.model.Price;

public interface IPrices {
	
	/**
	 * 
	 * Método central de la prueba
	 * 
	 * @param validationDate
	 * @param productId
	 * @param brandId
	 * @return
	 */
	public List<Price> getPriceList(Date validationDate, Long productId, int brandId);
	
	public int addPrice(Price p);
	
	public int updatePrice(Price p);
	
	public int deletePrice(int id);
}
