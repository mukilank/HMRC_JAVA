package uk.gov.hmrc.cart;

import java.math.BigDecimal;
import java.util.List;

import uk.gov.hmrc.model.Fruit;

public interface AbstractShoppingCart {
	public BigDecimal calculateTotal(List<Fruit> fruits);
}
