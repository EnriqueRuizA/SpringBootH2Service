package com.crud.h2.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PriceModel {
	private int id;
	private int brandId;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startDate;
	private Date endDate;
	private int priceList;
	private Long productId;
	private int priority;
	private Float price;
	private String currency;
	private Date lastUpdate;
	private String lastUpdateBy;

}
