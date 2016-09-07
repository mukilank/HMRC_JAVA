package uk.gov.hmrc.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.gov.hmrc.cart.BasicShoppingCart;
import uk.gov.hmrc.model.Fruit;

public class BasicShoppingCartTester extends BaseTester{

	private BasicShoppingCart cart;

	@Before
	public void setUp() throws Exception {
		cart = new BasicShoppingCart();
	}

	@After
	public void tearDown() throws Exception {
		cart = null;
	}

	@Test
	public void test2Apples1Orange() {
		List<Fruit> basket = getBasket(2,1);
		BigDecimal calculatedTotal = cart.calculateTotal(basket);
		assertEquals(new BigDecimal(1.45).doubleValue(), calculatedTotal.doubleValue());
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
		assertEquals(new BigDecimal(1.20).doubleValue(), calculatedTotal.doubleValue());
	}
	
	@Test
	public void test2Apples2Orange() {
		List<Fruit> basket = getBasket(2,2);
		BigDecimal calculatedTotal = cart.calculateTotal(basket);
		assertEquals(new BigDecimal(1.70).doubleValue(), calculatedTotal.doubleValue());
	}
	
	@Test
	public void test3Apples3Orange() {
		List<Fruit> basket = getBasket(3,3);
		BigDecimal calculatedTotal = cart.calculateTotal(basket);
		assertEquals(new BigDecimal(2.55).doubleValue(), calculatedTotal.doubleValue());
	}
	


}
