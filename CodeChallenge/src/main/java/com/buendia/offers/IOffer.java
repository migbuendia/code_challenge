package com.buendia.offers;

import java.math.BigDecimal;
import java.util.Map;

import com.buendia.dto.Product;

/**
 * Base interface for all the supermarket offers, on offer will provide the 
 * corresponding discount() implementation based on the offer type
 * 
 * @author buendim
 *
 */
public interface IOffer {

	public BigDecimal discount(String itemsPurchased, Map<String, Product> products);
	
}
