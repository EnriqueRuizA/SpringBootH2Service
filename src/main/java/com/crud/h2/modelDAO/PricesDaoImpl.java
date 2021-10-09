package com.crud.h2.modelDAO;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crud.h2.model.Price;

@Repository
public class PricesDaoImpl implements PricesDao {

	@Autowired
	private JdbcTemplate template;
	
	@Override
	public List<Price> getPriceList(Date validationDate, Long productId, int brandId) {
		//TODO implementar método con variables
		StringBuilder sql = new StringBuilder("SELECT * FROM PRICE");
		
		List<Price> priceList = template.query(sql.toString(), new BeanPropertyRowMapper<Price>(Price.class));
		
		
		return priceList;
	}

	@Override
	public int addPrice(Price p) {
		return 0;
	}

	@Override
	public int updatePrice(Price p) {
		return 0;
	}

	@Override
	public int deletePrice(int id) {
		return 0;
	}

	

}
