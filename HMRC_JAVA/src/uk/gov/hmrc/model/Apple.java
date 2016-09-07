package uk.gov.hmrc.model;

import java.math.BigDecimal;

public class Apple implements Fruit{
	
	private static final String NAME = "Apple";
	private final static BigDecimal PRICE = new BigDecimal("0.60");

	public String getName() {
		return NAME;
	}

	public BigDecimal getPrice() {
		return PRICE;
	}

}
