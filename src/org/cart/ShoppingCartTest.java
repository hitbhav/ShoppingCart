package org.cart;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.cart.item.Item;
import org.cart.offer.BuyOneGetOneFreeApples;
import org.cart.offer.IOffer;
import org.cart.offer.ThreeForThePriceOfTwoOranges;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class ShoppingCartTest {

	ShoppingCart shoppingCart;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		shoppingCart = new ShoppingCart();
	}

	@After
	public void tearDown() throws Exception {
	}

	public void addOneAppleTest() {
		Item appItem1 = new Item("Apple", 1, new BigDecimal(0.60));

		shoppingCart.addItem(appItem1);
		assertEquals(shoppingCart.cartTotalItems(), 1);

		String cartTotal = shoppingCart.getCartTotalAmount().setScale(2, RoundingMode.HALF_EVEN).toString();
		assertEquals(cartTotal, "0.60");
	}

	@Ignore
	public void addOneOrangeTest() {
		Item oraItem1 = new Item("Orange", 1, new BigDecimal(0.25));

		shoppingCart.addItem(oraItem1);
		assertEquals(shoppingCart.cartTotalItems(), 1);

		String cartTotal = shoppingCart.getCartTotalAmount().setScale(2, RoundingMode.HALF_EVEN).toString();
		assertEquals(cartTotal, "0.25");
	}

	@Test
	public void simpleShoppingCartTest() {
		System.out.println("===================  ThreeForThePriceOfTwoOrangesTest start =======================");

		Item appItem1 = new Item("Apple", 1, new BigDecimal(0.60));
		Item appItem2 = new Item("Apple", 1, new BigDecimal(0.60));
		Item appItem3 = new Item("Apple", 1, new BigDecimal(0.60));

		Item oraItem1 = new Item("Orange", 1, new BigDecimal(0.25));

		shoppingCart.addItem(appItem1);
		shoppingCart.addItem(appItem2);
		shoppingCart.addItem(oraItem1);
		shoppingCart.addItem(appItem3);

		assertEquals(shoppingCart.cartTotalItems(), 4);

		String cartTotal = shoppingCart.getCartTotalAmount().setScale(2, RoundingMode.HALF_EVEN).toString();
		assertEquals(cartTotal, "2.05");
	}

	@Test
	public void threeForThePriceOfTwoOrangesTest() {
		System.out.println("===================  ThreeForThePriceOfTwoOrangesTest start =======================");

		Item oraItem1 = new Item("Orange", 1, new BigDecimal(0.25));
		Item oraItem2 = new Item("Orange", 1, new BigDecimal(0.25));
		Item oraItem3 = new Item("Orange", 1, new BigDecimal(0.25));

		shoppingCart.addItem(oraItem1);
		shoppingCart.addItem(oraItem2);
		shoppingCart.addItem(oraItem3);

		IOffer offer1 = new ThreeForThePriceOfTwoOranges();

		shoppingCart.addOffer(offer1);

		shoppingCart.applyOffers();

		assertEquals(shoppingCart.cartTotalItems(), 3);

		String cartTotal = shoppingCart.getCartTotalAmount().setScale(2, RoundingMode.HALF_EVEN).toString();
		assertEquals(cartTotal, "0.50");
	}

	@Test
	public void buyOneGetOneFreeApplesTest() {
		System.out.println("===================  BuyOneGetOneFreeApplesTest start =======================");
		Item appItem1 = new Item("Apple", 1, new BigDecimal(0.60));
		Item appItem2 = new Item("Apple", 1, new BigDecimal(0.60));

		shoppingCart.addItem(appItem1);
		shoppingCart.addItem(appItem2);

		IOffer offer1 = new BuyOneGetOneFreeApples();

		shoppingCart.addOffer(offer1);

		shoppingCart.applyOffers();

		assertEquals(shoppingCart.cartTotalItems(), 2);

		String cartTotal = shoppingCart.getCartTotalAmount().setScale(2, RoundingMode.HALF_EVEN).toString();
		assertEquals(cartTotal, "0.60");
	}

}
