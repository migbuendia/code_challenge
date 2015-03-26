package com.buendia.app;

/**
 * An exception raised when a Product is not found in the Supermarket
 * 
 * @author buendim
 * 
 */
public class ProductNotFoundException extends Exception {
	
	private static final long serialVersionUID = -5499029852415787349L;
	protected String message = null;
	
	public ProductNotFoundException() {
	}

	public ProductNotFoundException(String msg) {
		super();
		this.message = new String(msg);
	}
	
	public String getMessage() {
		return this.message;
	}

}
