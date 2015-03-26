package com.buendia.app;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.buendia.businessHandler.ISupermarketBusinessHandler;
import com.buendia.businessHandler.SupermarketBusinessHandler;
import com.buendia.dto.Product;
import com.buendia.offers.IOffer;

/**
 * The class Supermarket in the main class to calculate the total amount for products purchase,
 * it runs the offers and deducts the savings for them
 * 
 * @author buendim
 *
 */
public class Supermarket {

	// TODO: substitute for a real logger
	PrintStream out = System.out;
		
	private ISupermarketBusinessHandler businessHandler = new SupermarketBusinessHandler();
	private Map<String, Product> products = new HashMap<String, Product>();
	private List<IOffer> productOffers = new ArrayList<IOffer>();
	
	/**
	 * checking out...
	 * 
	 * Adds the costs of the purchased items and deducts the savings
	 * based on the offers that apply to these items
	 * 
	 * @param itemsPurchased A string representing the purchased items
	 * @return the total amount for the product items including offers
	 * @throws ProductNotFoundException 
	 */
	public BigDecimal checkOut(String itemsPurchased) throws ProductNotFoundException {
		
		// product items
		BigDecimal total = businessHandler.checkingItemsOut( itemsPurchased, products );
		out.println( "full price of purchases: " + total );
		
		// applying offers
		BigDecimal savings = businessHandler.getOfferSavings( itemsPurchased, products, productOffers );
		out.println( "savings!: " + savings  );
		
		total = total.subtract( savings );
		out.println( "grand total: " + total );
		
		return total;
	}
	
	public void addProduct(Product product) {
		products.put( product.getName(), product );
	}
	
	public void removeProduct(String name) {
		products.remove( name );
	}
	
	public void changeProductPrice(String name, BigDecimal price) {
		products.put( name, new Product(name, price) );
	}
	
	public Map<String, Product> getProducts() {
		return products;
	}

	public void setProducts(Map<String, Product> products) {
		this.products = products;
	}

	public List<IOffer> getProductOffers() {
		return productOffers;
	}

	public void setProductOffers(List<IOffer> productOffers) {
		this.productOffers = productOffers;
	}
	
}
