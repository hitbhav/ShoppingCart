package org.cart.offer;

import java.math.BigDecimal;
import java.util.List;

import org.cart.item.Item;

public class ThreeForThePriceOfTwoOranges implements IOffer {

	@Override
	public void calculateOffer(List<Item> items) {
		int i = 0;
		int t = 0;
		for (Item item : items) {

			if (item.getName().equalsIgnoreCase("Orange")) {
				System.out.println("t = " + t);
				t++;
				if (t == 3) {
					item.setName("Orange(3for2 price)");
					item.setPrice(new BigDecimal(0));
					t = 0;
				}
			}
		}
	}

}
