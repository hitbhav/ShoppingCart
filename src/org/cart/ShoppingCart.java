package org.cart;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.cart.item.Item;
import org.cart.offer.IOffer;

public class ShoppingCart {

	List<Item> items;
	List<IOffer> offers;
	
	public ShoppingCart() {
		items = new ArrayList<Item>();
		offers= new ArrayList<IOffer>();
	}

	public void addItem(Item item) {
		items.add(item);
	}
	
	public void removeItem(Item item) {
		items.remove(item);
	}
	public void applyOffers() {
		
		for(IOffer offer: offers){
			offer.calculateOffer(this.items);
		}	
	}
	
	public BigDecimal getCartTotalAmount() {
		BigDecimal total = new BigDecimal(0);
		int i =1;
		for(Item item : items){
			BigDecimal subTotal = item.getPrice().multiply(new BigDecimal(item.getQty())).setScale(2,RoundingMode.HALF_EVEN);
			System.out.println(i++ +" : "+item.getName() + " - " + item.getQty() + " X  " + item.getPrice().setScale(2, RoundingMode.HALF_EVEN) +" = " + subTotal);
			total = total.add(subTotal);
		}
		System.out.println("---------------------------------------");
		System.out.println("Cart: Total ( No of Items : "+ items.size() +" ) £" + total.setScale(2,RoundingMode.HALF_EVEN)  );
		return total.setScale(2,RoundingMode.HALF_EVEN);
	}

	public void addOffer(IOffer offer) {
		offers.add(offer);
	}

	public int cartTotalItems() {
		return items.size();
	}
	
}
