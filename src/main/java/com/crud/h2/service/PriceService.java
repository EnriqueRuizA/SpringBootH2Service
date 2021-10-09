package com.crud.h2.service;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import com.crud.h2.model.Price;

public interface PriceService {

	public List<Price> getPrice(Date validationDate, Long productId, int brandId);

}
