package J3B.farmapp.model.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import J3B.farmapp.model.Item;
import org.junit.Test;

public class BagTest {

	@Test
	public void addItem() {
		Seed seed = new Seed("apple seed" ,new Plant("apple",1));
		Bag bag = new Bag();
		bag.addItem(seed);
		assertEquals(bag.getItems().contains(seed),true);
	}

	@Test
	public void getSeeds(){
		Seed seed = new Seed("orange seed" , new Plant ("orange",1));
		Bag bag = new Bag();
		bag.addItem(seed);
		List<Item> mockListItems = new ArrayList<Item>();
        mockListItems.add(seed);
        assertEquals(bag.getItems(), mockListItems);
	}

}
