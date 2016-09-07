package uk.gov.hmrc.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import uk.gov.hmrc.model.Apple;
import uk.gov.hmrc.model.Fruit;
import uk.gov.hmrc.model.Orange;

public class BaseTester extends TestCase{

	protected List<Fruit> getBasket(int apples, int oranges)
	{
		List<Fruit> basket = new ArrayList<Fruit>();
		for (int i=0; i<apples; i++)
		{
			basket.add(new Apple());
		}
		for (int i=0; i<oranges; i++)
		{
			basket.add(new Orange());
		}
		return basket;
	}

}
