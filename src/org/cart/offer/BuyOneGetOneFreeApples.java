package org.cart.offer;

import java.math.BigDecimal;
import java.util.List;

import org.cart.item.Item;

public class BuyOneGetOneFreeApples implements IOffer {
 
	@Override
	public void calculateOffer(List<Item> items) {
		System.out.println("calculateOffer "+ "items = " + items.size());
		int t=0;
		for(Item item: items){
			if(item.getName().equalsIgnoreCase("Apple")){
				t++;
				if(t==2){
					item.setName("Apple(Buy1 Get1 Free)");
					item.setPrice(new BigDecimal(0));
					t=0;
				}
			}
		}

	}

}
