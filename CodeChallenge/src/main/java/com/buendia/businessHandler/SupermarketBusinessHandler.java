package com.buendia.businessHandler;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.buendia.app.ProductNotFoundException;
import com.buendia.dto.Product;
import com.buendia.offers.IOffer;

/**
 * Class SupermarketBusinessHandler provides the implementations for the
 * supermarket methods
 * 
 * @author buendim
 *
 */
public class SupermarketBusinessHandler implements ISupermarketBusinessHandler {

	/**
	 * Calculates the total amount for the purchased items
	 * 
	 * @param items
	 * @param products
	 * @return
	 * @throws ProductNotFoundException
	 */
	public BigDecimal checkingItemsOut(String items, 
			Map<String, Product> products) throws ProductNotFoundException {
		
		BigDecimal amount = new BigDecimal( 0 );
		
		for( char productKey : items.toCharArray() ) {
			
			Product product = products.get( String.valueOf(productKey) );
			
			if( product != null ) {
				amount = amount.add( product.getPrice() );
				
			} else {
				throw new ProductNotFoundException( "Product " + productKey + " not found!" ); 
				
			}
		}
		
		return amount;
	}

	/**
	 * Calculates the savings for the purchased items by running the offers
	 * 
	 * @param itemsPurchased
	 * @param products
	 * @param productOffers
	 * @return
	 */
	public BigDecimal getOfferSavings(String itemsPurchased, 
			Map<String, Product> products, 
			List<IOffer> productOffers) {
		
		BigDecimal savingsAmount = new BigDecimal( 0 );
		
		for( IOffer offer : productOffers ) {
			
			savingsAmount = savingsAmount.add( offer.discount(itemsPurchased, products) );
			
		}
		
		return savingsAmount;
	}
	
	
}
