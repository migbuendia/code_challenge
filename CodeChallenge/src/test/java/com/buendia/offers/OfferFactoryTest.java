package com.buendia.offers;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.buendia.dto.Product;

/** 
 * Test class to test the functionality for the OfferFactory
 * 
 * @author buendim
 *
 */
public class OfferFactoryTest {

	/**
	 * Uses OfferFactory to test BulkOffer test, it generates a BulkOffer offer and 
	 * runs the discount method for it
	 */
	@Test
	public void bulkOfferTest() throws Exception {
		
		IOffer bulkOffer = OfferFactory.getOffer( OfferTypeEnum.BULK );
		assertNotNull( bulkOffer );
		
		Product mockProduct = new Product( "B", new BigDecimal(10.75) );
		assertNotNull( mockProduct );
		
		Map<String, Product> products = new HashMap<String, Product>();
		products.put( "B", mockProduct );
		
		assertTrue( bulkOffer.discount("BBBBB", products).compareTo(new BigDecimal(21.50)) == 0 ) ;
		
		assertTrue( bulkOffer.discount("BBBBBBBBBBBBBBB", products).compareTo(new BigDecimal(64.50)) == 0 ) ;
	}
	
	/**
	 * OfferFactory returns a HalfPrice offer and the discount method is tested for it
	 */
	@Test
	public void halfPriceOfferTest() throws Exception {
		
		IOffer halfPriceOffer = OfferFactory.getOffer( OfferTypeEnum.HALF_PRICE );
		assertNotNull( halfPriceOffer );
		
		Product mockProduct = new Product( "Z", new BigDecimal(25) );
		assertNotNull( mockProduct );
		
		Map<String, Product> products = new HashMap<String, Product>();
		products.put( "Z", mockProduct );
		
		assertTrue( halfPriceOffer.discount("BBB", products).compareTo(new BigDecimal(0)) == 0 ) ;
		
		assertTrue( halfPriceOffer.discount("ZZZ", products).compareTo(new BigDecimal(37.5)) == 0 ) ;
	}
	
}
