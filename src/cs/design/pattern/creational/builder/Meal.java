package cs.design.pattern.creational.builder;

import java.util.ArrayList;
import java.util.List;

public class Meal {

	private List<Item> items = new ArrayList<>();
	
	public void addItems(Item item) {
		
		items.add(item);
	}
	
	public float getCost() {
		
		float cost=0.0f;
		for(Item item: items) {
			
			cost+=item.price();
		}
		 return cost;
	}
	
	public void showItems() {
		
		for(Item item: items) {
		
		System.out.println("Name:" + item.name());
		System.out.println("Packaging:" + item.packing().pack());
		System.out.println("Cost:" + item.price());
		
		}
	}
}
