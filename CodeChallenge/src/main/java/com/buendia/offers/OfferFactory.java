package com.buendia.offers;

/**
 * Class OfferFactory creates and returns the requested supermarket offer
 * 
 * @author buendim
 *
 */
public class OfferFactory {

	public static IOffer getOffer(OfferTypeEnum offerType) {
		
		IOffer offer = null;
		
		switch(offerType) {
		
			case BULK:
				offer = new BulkOffer();
				break;
			case HALF_PRICE:
				offer = new HalfPriceOffer();
				break;
				
			default:
				break;
		}
		
		return offer;
	}
	
}
