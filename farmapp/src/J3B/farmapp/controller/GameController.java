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
	private Bag bag;

	public GameController() {
		prompt = new ConsoleMenu(this);
		gardenBed = new GardenBed(10);
		bag = new Bag();

		// test mock, no shop
		bag.addItem(new Seed("Mango", new Plant("Mango Tree", 1)));
		bag.addItem(new Seed("Apple", new Plant("Apple Tree", 1)));
		bag.addItem(new Seed("Extreme Berry", new Plant("Extreme Berry Tree", 10)));
	}

	public List<Growable> getPlants() {
		return this.gardenBed.getPlants();
	}

	public List<Seed> getSeeds() {
		List<Item> items = this.bag.getItems();
		List<Seed> seeds = new ArrayList<Seed>();
		for(Item item : items) {
			if(item instanceof Seed) {
				seeds.add((Seed) item);
			}
		}
		return seeds;
	}

	public void startGame() {
		do {
			prompt.showAll();
		}
		while (true);
	}

	public boolean plantSeed(Seed seed) {
		return this.gardenBed.addPlant(seed);
	}

	public void sleep() {
		for(Growable plants : this.gardenBed.getPlants()) {
			plants.grow();
		}
	}
}