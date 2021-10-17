package com.crud.h2;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.crud.h2.controller.PriceRESTController;
import com.crud.h2.model.PriceWithRestrictions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TestUtils {
	
	@Autowired
	PriceRESTController service;
	

	
	/**
	 * format "2014/10/29 18:10:45"
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	long stringToMilis(String dateString) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = sdf.parse(dateString);
		long millis = date.getTime();
		return millis;
	}
	
	/**
	 * 
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	Date stringToDate(String dateString) throws ParseException {	
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		Date startDateF = dateFormat.parse(dateString);
		return startDateF;
	}

}
