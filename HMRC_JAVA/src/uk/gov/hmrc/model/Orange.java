package uk.gov.hmrc.model;

import java.math.BigDecimal;

public class Orange implements Fruit{
	
	private static final String NAME = "Orange";
	private final static BigDecimal PRICE = new BigDecimal("0.25");

	public String getName() {
		return NAME;
	}

	public BigDecimal getPrice() {
		return PRICE;
	}

}
