package uk.gov.hmrc.cart;

import java.math.BigDecimal;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import uk.gov.hmrc.model.Fruit;
import uk.gov.hmrc.model.FruitsValid;
import uk.gov.hmrc.offer.OfferFactory;

public class OfferShoppingCart implements AbstractShoppingCart {

	@Override
	public BigDecimal calculateTotal(List<Fruit> fruits) {
		BigDecimal totalAmount = new BigDecimal("0.0");
		HashMap<String, Integer> fruitMap = getFruitMap();
		if (fruits != null) {
			for (Fruit fruit : fruits) {
				totalAmount = executeOffers(fruit, totalAmount,
						incFruitCount(fruit, fruitMap),
						OfferFactory.getOfferIndex(fruit.getName()));
			}
		}
		return totalAmount;
	}

	private BigDecimal executeOffers(Fruit fruit, BigDecimal amount,
			int itemCount, int offerIndex) {
		if (itemCount % offerIndex != 0) {
			amount = amount.add(fruit.getPrice());
		}
		return amount;
	}

	private int incFruitCount(Fruit fruit, HashMap<String, Integer> fruitCount) {
		Integer incCount = fruitCount.get(fruit.getName()) + 1;
		fruitCount.replace(fruit.getName(), incCount);
		return incCount;
	}

	private HashMap<String, Integer> getFruitMap() {
		HashMap<String, Integer> fruitCount = new HashMap<String, Integer>();
		Set<FruitsValid> fruits = EnumSet.allOf(FruitsValid.class);
		Iterator<FruitsValid> it = fruits.iterator();
		while (it.hasNext()) {
			fruitCount.put(it.next().name(), 0);
		}
		return fruitCount;
	}
}
