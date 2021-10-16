package com.crud.h2.model;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PriceWithRestrictions {

	private Long productId;
	private int brandId;
	private int priceList;
	private Date startDate;
	private Date endDate;
	private Float price;
}
