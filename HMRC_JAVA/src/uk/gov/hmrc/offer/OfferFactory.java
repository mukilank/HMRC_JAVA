package uk.gov.hmrc.offer;

public class OfferFactory {

	public static int getOfferIndex(String fruit)
	{
		if(fruit.equals("Apple"))
		{
			return 2;
		}
		else if(fruit.equals("Orange"))
		{
			return 3;
		}
		return 0;
	}
}
