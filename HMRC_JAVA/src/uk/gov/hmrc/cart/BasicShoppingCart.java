package uk.gov.hmrc.cart;

import java.math.BigDecimal;
import java.util.List;

import uk.gov.hmrc.model.Fruit;

public class BasicShoppingCart implements AbstractShoppingCart{

	@Override
	public BigDecimal calculateTotal(List<Fruit> fruits) {
		BigDecimal totalAmount = new BigDecimal("0.0");
		if(fruits !=null)
		{
			for(Fruit fruit:fruits)
			{
				totalAmount = totalAmount.add(fruit.getPrice());
			}
		}
		return totalAmount;
	}

}
