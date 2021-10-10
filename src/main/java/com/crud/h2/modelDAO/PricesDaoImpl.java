package com.crud.h2.modelDAO;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	public List<Price> getPriceList(Date validationDate, Long productId, int brandId) throws ParseException {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = dateFormat.format(validationDate);

		StringBuilder sql = new StringBuilder("SELECT * FROM PRICE WHERE ");
		sql.append("startDate <= '" + date + "'");
		sql.append(" AND ");
		sql.append("endDate > '" + date + "'");
		
		return template.query(sql.toString(), new BeanPropertyRowMapper<Price>(Price.class));
	}

	@Override
	public List<Price> getAllPrices() {
		StringBuilder sql = new StringBuilder("SELECT * FROM PRICE");
		return template.query(sql.toString(), new BeanPropertyRowMapper<Price>(Price.class));
	}
}
