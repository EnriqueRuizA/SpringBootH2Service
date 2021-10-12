package com.crud.h2;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.assertj.core.data.Index;
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
	public void contextLoads() throws Exception {
		String date = "2020-06-14 00:00:00";
		Long productId = 35455L;
		int brandId = 1;

		PriceWithRestrictions priceWithRestrictions = new PriceWithRestrictions();

		String startDate = "2020-06-14 00:00:00";
		String endDate = "2020-12-31 22:59:59";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startDateF = dateFormat.parse(startDate);
		Date endDateF = dateFormat.parse(endDate);

		priceWithRestrictions.setPrice(35.5F);
		priceWithRestrictions.setStartDate(startDateF);
		priceWithRestrictions.setEndDate(endDateF);
		priceWithRestrictions.setBrandId(brandId);
		priceWithRestrictions.setProductId(productId);
		priceWithRestrictions.setPriceList(1);

		assertThat(controller.filteredPrices(date, productId, brandId)).contains(priceWithRestrictions,
				Index.atIndex(0));

	}

}
