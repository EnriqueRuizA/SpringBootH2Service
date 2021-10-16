package com.crud.h2;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.crud.h2.controller.PriceRESTController;
import com.crud.h2.model.PriceWithRestrictions;

@SpringBootTest
class SpringBootH2ServiceApplicationTests {

	@Autowired
	PriceRESTController controller;

	@Test
	void validarRespuestaConocida() throws Exception {

		// parámetros consultados
		String date = "2020-06-14 00:00:00";
		Long productId = 35455L;
		int brandId = 1;

		// respuesta esperada
		float price = 35.5F;
		int priceList = 1;
		Timestamp startDate = new Timestamp(stringToMilis("2020/06/14 00:00:0"));
		Timestamp endDate = new Timestamp(stringToMilis("2020/12/31 23:59:59"));
		
		List<PriceWithRestrictions> response = controller.filteredPrices(date, productId, brandId);
		assertThat(response.get(0).getBrandId()).isEqualTo(response.get(0).getBrandId());
		assertThat(response.get(0).getBrandId()).isEqualTo(brandId);
		assertThat(response.get(0).getPrice()).isEqualTo(price);
		assertThat(response.get(0).getStartDate()).isEqualTo(startDate);
		assertThat(response.get(0).getEndDate()).isEqualTo(endDate);
		assertThat(response.get(0).getPriceList()).isEqualTo(priceList);
		assertThat(response.get(0).getProductId()).isEqualTo(productId);

	}
	
	@Test
	void validarRangoDeFechas1() throws Exception {
		validarFechasPrecioCoherente("2020-06-14 10:00:00",  35455L,  1);
	}
	
	
	@Test
	void validarRangoDeFechas2() throws Exception {
		validarFechasPrecioCoherente("2020-06-14 16:00:00",  35455L,  1);
	}
	
	@Test
	void validarRangoDeFechas3() throws Exception {
		validarFechasPrecioCoherente("2020-06-14 21:00:00",  35455L,  1);
	}
	
	@Test
	void validarRangoDeFechas4() throws Exception {
		validarFechasPrecioCoherente("2020-06-15 10:00:00",  35455L,  1);
	}
	
	@Test
	void validarRangoDeFechas5() throws Exception {
		validarFechasPrecioCoherente("2020-06-16 21:00:00",  35455L,  1);
	}

	
	
	
	void validarFechasPrecioCoherente(String date, Long productId, int brandId) throws Exception {
		List<PriceWithRestrictions> response = controller.filteredPrices(date, productId, brandId);
		assertThat(response.get(0).getBrandId()).isEqualTo(response.get(0).getBrandId());
		assertThat(response.get(0).getBrandId()).isEqualTo(brandId);
		assertThat(stringToDate(date)).isBetween(response.get(0).getStartDate(), response.get(0).getEndDate());
		assertThat(response.get(0).getProductId()).isEqualTo(productId);

	}
	
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
