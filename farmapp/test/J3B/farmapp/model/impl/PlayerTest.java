package J3B.farmapp.model.impl;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {
String name = "The mighty Alex";
int maxHunger = 100;
	@Test
	public void getName() {
		Bag inventory = new Bag();
		Player player = new Player(name, inventory, maxHunger);
        assertEquals(player.getName(),"The mighty Alex");
	}
	
	@Test
	public void getMaxHunger() {
		Bag inventory = new Bag();
		Player player = new Player(name, inventory, maxHunger);
        assertEquals(player.getMaxHunger(),100);
	}
	@Test
	public void getHunger() {
		Bag inventory = new Bag();
		Player player = new Player(name, inventory, maxHunger);
		player.sleep();
		//100-1 = 99
        assertEquals(player.getHunger(),99);
	}
	@Test
	public void eatFruit() {
		Bag inventory = new Bag();
		Player player = new Player(name, inventory, maxHunger);
		for(int i = 0 ; i < 40;i++){
			player.sleep();	
		}
		//100-40 = 60
		Fruit fruit = new Fruit("Stardew Fruit",17);
        player.eatFruit(fruit);
        //60+17=77
		assertEquals(player.getHunger(),77);
	}
}
