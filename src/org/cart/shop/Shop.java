package org.cart.shop;

import java.math.BigDecimal;

import org.cart.ShoppingCart;
import org.cart.item.Item;
import org.cart.offer.BuyOneGetOneFreeApples;
import org.cart.offer.IOffer;
import org.cart.offer.ThreeForThePriceOfTwoOranges;

public class Shop {

	public static void main(String[] args) {

		ShoppingCart shoppingCart = new ShoppingCart();

		Item appItem1 = new Item("Apple", 1, new BigDecimal(0.60));
		Item appItem2 = new Item("Apple", 1, new BigDecimal(0.60));
		Item OrItem1 = new Item("Orange", 1, new BigDecimal(0.25));
		Item appItem3 = new Item("Apple", 1, new BigDecimal(0.60));

		shoppingCart.addItem(appItem1);
		shoppingCart.addItem(appItem2);
		shoppingCart.addItem(OrItem1);
		shoppingCart.addItem(appItem3);

		IOffer offer1 = new ThreeForThePriceOfTwoOranges();
		IOffer offer2 = new BuyOneGetOneFreeApples();

		shoppingCart.addOffer(offer1);
		shoppingCart.addOffer(offer2);

		shoppingCart.applyOffers();

		BigDecimal total = shoppingCart.getCartTotalAmount();

	}

}
