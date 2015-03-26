package com.buendia.offers;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.buendia.dto.Product;

/**
 * 
 * HalfPriceOffer offer cuts the price for a particular product
 * in half.
 * 
 * PRODUCT is the product in offer
 * MULTIPLIER_COST is the offer cost multiplier for the product
 * 
 * Example: 
 *     buy product X and pay 1/2 price for it
 *     
 * @author buendim
 *
 */
public class HalfPriceOffer implements IOffer {
	
	// TODO: substitute for a real logger
	PrintStream out = System.out;
	
	static final String PRODUCT = "Z";
	
	static final double MULTIPLIER_COST = 0.5;

	@Override
	public BigDecimal discount(String itemsPurchased, Map<String, Product> products) {
		out.println("Running half-price offer");
		
		BigDecimal savingsAmount = new BigDecimal( 0 );
		
		Product product = products.get( PRODUCT );
		int itemsInOfferBought = StringUtils.countMatches(itemsPurchased, PRODUCT);
		
		if( itemsInOfferBought > 0 && product != null ) {
			
			savingsAmount = savingsAmount.add( 
					product.getPrice().multiply(new BigDecimal(itemsInOfferBought).multiply(new BigDecimal(MULTIPLIER_COST))) );
			
		}
		
		out.println("savings with half-price offer: " + savingsAmount.toString());
		
		return savingsAmount;
	}
}
