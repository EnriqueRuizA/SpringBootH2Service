package com.crud.h2.model;

import java.util.Date;

import lombok.Data;

@Data
public class Price {
	private int id;
	private int brandId;
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
