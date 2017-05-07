package J3B.farmapp.controller;

import java.util.ArrayList;
import java.util.List;

import J3B.farmapp.model.Growable;
import J3B.farmapp.model.Item;
import J3B.farmapp.model.impl.*;
import J3B.farmapp.view.ConsoleMenu;

public class GameController {
	private ConsoleMenu prompt;
	private GardenBed gardenBed;
	private Player player;

	public GameController() {
		prompt = new ConsoleMenu(this);

		// Call MockData method to prepare some initial data
		this.mockData();
	}

	public void mockData() {

		player = new Player("My beloved Teacher [Alex Thunder]", new Bag(), 100);
		gardenBed = new GardenBed(10);

		WaterInfo waterInfo1 = new WaterInfo(10, 20, 20, 80, 20);
		WaterInfo waterInfo2 = new WaterInfo(30, 60, 10, 90, 5);

		HealthInfo healthInfo1 = new HealthInfo(30, 50, 100);
		HealthInfo healthInfo2 = new HealthInfo(10, 0, 20);

		Fruit fruit1 = new Fruit("Coconut", 50);
		Fruit fruit2 = new Fruit("Apple", 7);

		Plant plant1 = new Plant("Coconut Tree", 10, waterInfo1, healthInfo1, fruit1);
		Plant plant2 = new Plant("Apple Tree", 1, waterInfo2, healthInfo2, fruit2);

		Seed seed1 = new Seed("Coconut Seed", plant1);
		Seed seed2 = new Seed("Apple Seed", plant2);

		this.player.getInventory().addItem(seed1);
		this.player.getInventory().addItem(seed2);

	}

	public List<Growable> getPlants() {
		return this.gardenBed.getPlants();
	}

	public List<Seed> getSeeds() {
		List<Item> items = this.player.getInventory().getItems();
		List<Seed> seeds = new ArrayList<Seed>();
		for(Item item : items) {
			if(item instanceof Seed) {
				seeds.add((Seed) item);
			}
		}
		return seeds;
	}

	public void startGame() {
		boolean isExit = false;
		do {
			isExit = prompt.showAll();
		}
		while (isExit);
	}

	public boolean plantSeed(Seed seed) {
		return this.gardenBed.addPlant(seed);
	}

	public void waterPlant(Growable plant) {
		plant.water();
	}

	public void harvestPlant(Growable plant) {
		Item item = plant.harvest();
		if(item != null) {
			this.player.getInventory().addItem(item);
			this.gardenBed.removePlant(plant);
		}
	}

	public List<Fruit> getFruits() {
		List<Item> items = this.player.getInventory().getItems();
		List<Fruit> fruits = new ArrayList<Fruit>();
		for(Item item : items) {
			if(item instanceof Fruit) {
				fruits.add((Fruit) item);
			}
		}
		return fruits;
	}

	public void eatFruit(Fruit fruit) {
		this.player.eatFruit(fruit);
	}

	public boolean destoryFruit(Fruit fruit) {
		return this.player.getInventory().removeItem(fruit);
	}

	public void sleep() {
		for(Growable plants : this.gardenBed.getPlants()) {
			plants.grow();
		}
		this.player.sleep();
	}

	public Player getPlayer() {
		return player;
	}
}