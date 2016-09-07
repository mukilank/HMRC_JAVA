package uk.gov.hmrc.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.gov.hmrc.cart.OfferShoppingCart;
import uk.gov.hmrc.model.Fruit;

public class OfferShoppingCartTester extends BaseTester{

	private OfferShoppingCart cart;

	@Before
	public void setUp() throws Exception {
		cart = new OfferShoppingCart();
	}

	@After
	public void tearDown() throws Exception {
		cart = null;
	}

	@Test
	public void test2Apples1Orange() {
		List<Fruit> basket = getBasket(2,1);
		BigDecimal calculatedTotal = cart.calculateTotal(basket);
		assertEquals(new BigDecimal(0.85).doubleValue(), calculatedTotal.doubleValue());
	}
	
	@Test
	public void test0Apples1Orange() {
		List<Fruit> basket = getBasket(0,1);
		BigDecimal calculatedTotal = cart.calculateTotal(basket);
		assertEquals(new BigDecimal(0.25).doubleValue(), calculatedTotal.doubleValue());
	}
	
	@Test
	public void test2Apples0Orange() {
		List<Fruit> basket = getBasket(2,0);
		BigDecimal calculatedTotal = cart.calculateTotal(basket);
		assertEquals(new BigDecimal(0.60).doubleValue(), calculatedTotal.doubleValue());
	}
	
	@Test
	public void test2Apples2Orange() {
		List<Fruit> basket = getBasket(2,2);
		BigDecimal calculatedTotal = cart.calculateTotal(basket);
		assertEquals(new BigDecimal(1.10).doubleValue(), calculatedTotal.doubleValue());
	}
	
	@Test
	public void test3Apples3Orange() {
		List<Fruit> basket = getBasket(3,3);
		BigDecimal calculatedTotal = cart.calculateTotal(basket);
		assertEquals(new BigDecimal(1.70).doubleValue(), calculatedTotal.doubleValue());
	}
	
	@Test
	public void test3Apples2Orange() {
		List<Fruit> basket = getBasket(3,2);
		BigDecimal calculatedTotal = cart.calculateTotal(basket);
		assertEquals(new BigDecimal(1.70).doubleValue(), calculatedTotal.doubleValue());
	}
	
	@Test
	public void test1Apples5Orange() {
		List<Fruit> basket = getBasket(1,5);
		BigDecimal calculatedTotal = cart.calculateTotal(basket);
		assertEquals(new BigDecimal(1.60).doubleValue(), calculatedTotal.doubleValue());
	}
	
}

