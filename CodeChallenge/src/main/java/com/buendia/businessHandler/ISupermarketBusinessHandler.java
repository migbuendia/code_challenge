package com.buendia.businessHandler;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.buendia.app.ProductNotFoundException;
import com.buendia.dto.Product;
import com.buendia.offers.IOffer;

/**
 * Interface for SupermarketBusinessHandler
 * 
 * @author buendim
 *
 */
public interface ISupermarketBusinessHandler {

	public BigDecimal checkingItemsOut(String items, 
			Map<String, Product> products) throws ProductNotFoundException;

	public BigDecimal getOfferSavings(String itemsPurchased, 
			Map<String, Product> products, 
			List<IOffer> productOffers);
		
}
