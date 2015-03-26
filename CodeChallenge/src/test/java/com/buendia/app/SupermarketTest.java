package com.buendia.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import com.buendia.app.Supermarket;
import com.buendia.dto.Product;
import com.buendia.mocks.MockUtils;

/**
 */
public class SupermarketTest {

	/**
	 * This test runs the challenge checkout items:  ABBACBBAB
	 */
	@Test
	public void checkOutChallengeTest() throws Exception {
		
		Supermarket supermarket = new Supermarket();
		
		// load supermarket products
		supermarket.setProducts( MockUtils.getMockProductsABC() );
		assertEquals( 3, supermarket.getProducts().size() );
 		
		// load offers
		supermarket.setProductOffers( MockUtils.getMockProductOffers() );
		
		// checkingOut...
		assertTrue( supermarket.checkOut("ABBACBBAB").compareTo(new BigDecimal(240)) == 0 );
		
	}
	
	/**
	 * This test adds an extra item that doesn't qualify for the 'BulkOffer' so it will be 
	 * charged at full price: ABBACBBABB
	 */
	@Test
	public void checkBulkOfferWithExtraItemsTest() throws Exception {
		
		Supermarket supermarket = new Supermarket();
		
		// load supermarket products
		supermarket.setProducts( MockUtils.getMockProductsABC() );
		assertEquals( 3, supermarket.getProducts().size() );
 		
		// load offers
		supermarket.setProductOffers( MockUtils.getMockProductOffers() );
		
		// checkingOut...
		assertTrue( supermarket.checkOut("ABBACBBABB").compareTo(new BigDecimal(290)) == 0 );
		
	}
	
	/**
	 * Test that runs product when Supermarket has two offers (BulkPrice, HalfPrice), half-price
	 * offer applies to product 'Z' only: ABBZACBZBAB
	 */
	@Test
	public void checkOutTwoOffersTest() throws Exception {
		
		Supermarket supermarket = new Supermarket();
		
		// load supermarket products, what about via DB?
		supermarket.setProducts( MockUtils.getMockProductsABCZ() );
		assertEquals( 4, supermarket.getProducts().size() );
 		
		// load offers
		supermarket.setProductOffers( MockUtils.getMockProductOffers() );
		
		// checking out...
		assertTrue( supermarket.checkOut("ABBZACBZBAB").compareTo(new BigDecimal(315)) == 0 );
		
	}
	
	/**
	 * Test that fails when a product in the checkout line doesn't exist
	 */
	@Test
	public void checkOutProductNotFoundTest() throws Exception {
		
		Supermarket supermarket = new Supermarket();
		
		// load supermarket products, what about via DB?
		supermarket.setProducts( MockUtils.getMockProductsABC() );
		assertEquals( 3, supermarket.getProducts().size() );
 		
		// checking out...
		try {
			assertTrue( supermarket.checkOut("CBBX").compareTo(new BigDecimal(0)) == 0 );
			assertFalse( "Error detecting product not found", true );
			
		} catch(Exception e) {
		}
		
	}	
	
	/**
	 * Test that does two checkout, but for the second checkout the price of a 
	 * product has changed. Product B goes from $50 to $40.
	 *  ABBACBBAB
	 */
	@Test
	public void checkOutWithProductChangePrice() throws Exception {
		
		Supermarket supermarket = new Supermarket();
		
		// load supermarket products, what about via DB?
		supermarket.setProducts( MockUtils.getMockProductsABC() );
		assertEquals( 3, supermarket.getProducts().size() );
 		
		// load offers
		supermarket.setProductOffers( MockUtils.getMockProductOffers() );
		
		// checking out...
		assertTrue( supermarket.checkOut("ABBACBBAB").compareTo(new BigDecimal(240)) == 0 );
		
		// change product price
		Product productBNewPrice = new Product( "B", new BigDecimal(40) );
		supermarket.getProducts().put( "B", productBNewPrice );
		
		// checking out with new price same offers...
		assertTrue( supermarket.checkOut("ABBACBBAB").compareTo(new BigDecimal(210)) == 0 );
		
	}
	
	/**
	 * Test products, add, remove
	 */
	@Test
	public void productsTest() throws Exception {
		
		Supermarket supermarket = new Supermarket();
		supermarket.setProducts( MockUtils.getMockProductsABC() );
		
		assertEquals( 3, supermarket.getProducts().size() );
		
		Product productB = supermarket.getProducts().get( "B" );
		assertTrue( productB.getPrice().compareTo(new BigDecimal(50)) == 0 );
		
		supermarket.addProduct( new Product("Z", new BigDecimal(70)) );
		assertEquals( 4, supermarket.getProducts().size() );
		Product productZ = supermarket.getProducts().get( "Z" );
		assertTrue( productZ.getPrice().compareTo(new BigDecimal(70)) == 0 );
		
		supermarket.removeProduct( "B" );
		supermarket.removeProduct( "A" );
		assertEquals( 2, supermarket.getProducts().size() );
		
	}
	
}
