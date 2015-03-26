package com.buendia.offers;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.buendia.dto.Product;

/**
 * BulkOffer offer gives a discount for when buying several items 
 * of the same product.
 * 
 * PRODUCT is the product in offer
 * BUY_NUMBER_ITEMS is the number of items to buy to get a discount
 * MULTIPLIER_COST is the offer cost for buying a number of items
 * 
 * Example: 
 *     buy 5 products and pay for 3
 * 
 * @author buendim
 *
 */
public class BulkOffer implements IOffer {
	
	// TODO: substitute for a real logger
	PrintStream out = System.out;
	
	static final String PRODUCT = "B";
	static final int BUY_NUMBER_ITEMS = 5;
	static final int MULTIPLIER_COST_TO_PAY = 3;

	@Override
	public BigDecimal discount(String itemsPurchased, Map<String, Product> products) {
		out.println("Running bulk discount");
		
		BigDecimal savingsAmount = new BigDecimal( 0 );
		
		Product product = products.get( PRODUCT );
		int itemsInOfferBought = StringUtils.countMatches(itemsPurchased, PRODUCT);
		
		if( itemsInOfferBought > 0 && product != null ) {
			
			// amount for products that qualify for offer
			BigDecimal bundlesWithOffer = new BigDecimal( itemsInOfferBought / BUY_NUMBER_ITEMS );
			BigDecimal bundlesOfferPrice = bundlesWithOffer.multiply( product.getPrice().multiply(new BigDecimal(MULTIPLIER_COST_TO_PAY)) );
			
			// full price
			BigDecimal bundlesFullPrice = bundlesWithOffer.multiply( product.getPrice().multiply(new BigDecimal(BUY_NUMBER_ITEMS)) );
			
			savingsAmount = savingsAmount.add( bundlesFullPrice.subtract(bundlesOfferPrice) );
		}
		
		out.println( "savings with bulk purchase offer: " + savingsAmount.toString() );
		
		return savingsAmount;
	}
	
}
