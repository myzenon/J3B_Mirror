package J3B.farmapp.model.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import J3B.farmapp.model.Item;
import org.junit.Test;

public class BagTest {
	WaterInfo waterInfo1 = new WaterInfo(10, 20, 20, 80, 20);
	HealthInfo healthInfo1 = new HealthInfo(30, 50, 100);
	Fruit fruit1 = new Fruit("Apple", 50);
	WaterInfo waterInfo2 = new WaterInfo(10, 20, 20, 80, 20);
	HealthInfo healthInfo2 = new HealthInfo(30, 50, 100);
	Fruit fruit2 = new Fruit("Apple", 50);
	@Test
	public void addItem() {
		Seed seed = new Seed("apple seed" ,new Plant("apple",1, waterInfo1, healthInfo1, fruit1));
		Bag bag = new Bag();
		bag.addItem(seed);
		assertEquals(bag.getItems().contains(seed),true);
	}

	@Test
	public void getSeeds(){
		Seed seed = new Seed("orange seed" , new Plant ("orange",1, waterInfo2, healthInfo2, fruit2));
		Bag bag = new Bag();
		bag.addItem(seed);
		List<Item> mockListItems = new ArrayList<Item>();
        mockListItems.add(seed);
        assertEquals(bag.getItems(), mockListItems);
	}

}
