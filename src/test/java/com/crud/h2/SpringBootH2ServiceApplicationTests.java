package com.crud.h2;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.crud.h2.controller.PriceRESTController;
import com.crud.h2.model.PriceModel;
import com.crud.h2.model.PriceWithRestrictions;

@SpringBootTest
class SpringBootH2ServiceApplicationTests extends TestUtils {



//	@Test
//	void validateKnownFilteredPrice() throws Exception {
//
//		// parámetros consultados
//		String date = "2020-06-14 00:00:00";
//		Long productId = 35455L;
//		int brandId = 1;
//
//		// respuesta esperada
//		float price = 35.5F;
//		int priceList = 1;
//		Timestamp startDate = new Timestamp(stringToMilis("2020/06/14 00:00:0"));
//		Timestamp endDate = new Timestamp(stringToMilis("2020/12/31 23:59:59"));
//
//		List<PriceWithRestrictions> response = service.filteredPrices(date, productId, brandId);
//		assertThat(response.get(0).getBrandId()).isEqualTo(response.get(0).getBrandId());
//		assertThat(response.get(0).getBrandId()).isEqualTo(brandId);
//		assertThat(response.get(0).getPrice()).isEqualTo(price);
//		assertThat(response.get(0).getStartDate()).isEqualTo(startDate);
//		assertThat(response.get(0).getEndDate()).isEqualTo(endDate);
//		assertThat(response.get(0).getPriceList()).isEqualTo(priceList);
//		assertThat(response.get(0).getProductId()).isEqualTo(productId);
//
//	}
	
	@Test
	void validateKnownFilteredPrice1() throws ParseException, Exception {
		validarRespuestaEsperada("2020-06-14 00:00:00", 35455L, 1, 35.5F, 1,new Timestamp(stringToMilis("2020/06/14 00:00:00")), new Timestamp(stringToMilis("2020/12/31 23:59:59")));
		validarFechasCoherentes("2020-06-14 10:00:00", 35455L, 1);
	}
	
	@Test
	void validateKnownFilteredPrice2() throws ParseException, Exception {
		validarRespuestaEsperada("2020-06-14 16:00:00", 35455L, 1, 35.5F, 1, new Timestamp(stringToMilis("2020/06/14 00:00:00")),new Timestamp(stringToMilis("2020/12/31 23:59:59")));
		validarFechasCoherentes("2020-06-14 16:00:00", 35455L, 1);
	}
	
	@Test
	void validateKnownFilteredPrice3() throws ParseException, Exception {
		validarRespuestaEsperada("2020-06-14 21:00:00", 35455L, 1, 35.5F, 1, new Timestamp(stringToMilis("2020/06/14 00:00:00")),new Timestamp(stringToMilis("2020/12/31 23:59:59")));
		validarFechasCoherentes("2020-06-14 21:00:00", 35455L, 1);
	}
	
	@Test
	void validateKnownFilteredPrice4() throws ParseException, Exception {
		validarRespuestaEsperada("2020-06-15 10:00:00", 35455L,1, 35.5F, 1, new Timestamp(stringToMilis("2020/06/14 00:00:00")),new Timestamp(stringToMilis("2020/12/31 23:59:59")));
		validarFechasCoherentes("2020-06-15 10:00:00", 35455L, 1);
	}
	
	@Test
	void validateKnownFilteredPrice5() throws ParseException, Exception {
		validarRespuestaEsperada("2020-06-16 21:00:00", 35455L, 1, 35.5F,1, new Timestamp(stringToMilis("2020/06/14 00:00:00")),new Timestamp(stringToMilis("2020/12/31 23:59:59")));
		validarFechasCoherentes("2020-06-16 21:00:00", 35455L, 1);
	}
	

	@Test
	void validateAllPrices() throws Exception {
		List<PriceModel> response = service.allPrices();
		assertThat(response).isNotNull();
		for (PriceModel price : response) {
			assertThat(price.getBrandId()).isEqualTo(response.get(0).getBrandId());
			assertThat(price.getBrandId()).isNotZero();
			assertThat(price.getPrice()).isNotNull();
			assertThat(price.getStartDate()).isNotNull();
			assertThat(price.getEndDate()).isNotNull();
			assertThat(price.getPriceList()).isNotZero();
			assertThat(price.getProductId()).isNotNull();
		}
	}
	
	/**
	 * 
	 * @param date
	 * @param productId
	 * @param brandId
	 * @throws Exception
	 */
	void validarFechasCoherentes(String date, Long productId, int brandId) throws Exception {
		List<PriceWithRestrictions> response = service.filteredPrices(date, productId, brandId);
		assertThat(response.get(0).getBrandId()).isEqualTo(brandId);
		assertThat(stringToDate(date)).isBetween(response.get(0).getStartDate(), response.get(0).getEndDate());
		assertThat(response.get(0).getProductId()).isEqualTo(productId);
	}
	
	/**
	 * 
	 * @param date
	 * @param productId
	 * @param brandId
	 * @param expectedPrice
	 * @param expectedPriceList
	 * @param expectedStartDate
	 * @param expectedEndDate
	 * @throws Exception
	 */
	void validarRespuestaEsperada(String date, Long productId, int brandId, float expectedPrice,int expectedPriceList, Timestamp expectedStartDate, Timestamp expectedEndDate) throws Exception {
		List<PriceWithRestrictions> response = service.filteredPrices(date, productId, brandId);
		assertThat(response.get(0).getBrandId()).isEqualTo(response.get(0).getBrandId());
		assertThat(response.get(0).getBrandId()).isEqualTo(brandId);
		assertThat(response.get(0).getPrice()).isEqualTo(expectedPrice);
		assertThat(response.get(0).getStartDate()).isEqualTo(expectedStartDate);
		assertThat(response.get(0).getEndDate()).isEqualTo(expectedEndDate);
		assertThat(response.get(0).getPriceList()).isEqualTo(expectedPriceList);
		assertThat(response.get(0).getProductId()).isEqualTo(productId);

	}
}
