package com.buendia.mocks;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.buendia.dto.Product;
import com.buendia.offers.IOffer;
import com.buendia.offers.OfferFactory;
import com.buendia.offers.OfferTypeEnum;

/**
 * Utility class 'MockUtils' provides the mock objects and collections
 * for the tests
 * 
 * @author buendim
 *
 */
public class MockUtils {
	
	static public Map<String, Product> getMockProductsABC() {
		Map<String, Product> products = new HashMap<String, Product>();
		
		products.put("A", getMockProduct("A", new BigDecimal(20)));
		products.put("B", getMockProduct("B", new BigDecimal(50)));
		products.put("C", getMockProduct("C", new BigDecimal(30)));
		
		return products;
	}
	
	static public Map<String, Product> getMockProductsABCZ() {
		Map<String, Product> products = new HashMap<String, Product>();
		
		products.put("A", getMockProduct("A", new BigDecimal(20)));
		products.put("B", getMockProduct("B", new BigDecimal(50)));
		products.put("C", getMockProduct("C", new BigDecimal(30)));
		products.put("Z", getMockProduct("Z", new BigDecimal(75)));
		
		return products;
	}
	
	static public Product getMockProduct(String name, BigDecimal price) {
		return new Product(name, price);
	}
	
	static public List<IOffer> getMockProductOffers() {
		List<IOffer> productOffers = new ArrayList<IOffer>();
		
		productOffers.add( OfferFactory.getOffer(OfferTypeEnum.BULK) );
		productOffers.add( OfferFactory.getOffer(OfferTypeEnum.HALF_PRICE) );
		
		return productOffers;
	}
	
}
