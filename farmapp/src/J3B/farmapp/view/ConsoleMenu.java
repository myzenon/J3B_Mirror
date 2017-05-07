package J3B.farmapp.view;

import java.util.List;

import J3B.farmapp.controller.GameController;
import J3B.farmapp.model.Growable;
import J3B.farmapp.model.Item;
import J3B.farmapp.model.impl.Fruit;
import J3B.farmapp.model.impl.Seed;
import J3B.farmapp.util.Input;

public class ConsoleMenu {

	private GameController gameController;

	public ConsoleMenu(GameController gameController) {
		this.gameController = gameController;
	}

	public boolean showAll() {
		System.out.println("\n-- Select an action --");
		System.out.println("1> View Plants in Garden");
		System.out.println("2> Plant a seed");
		System.out.println("3> Water Plants");
		System.out.println("4> Harvest Fruit");
		System.out.println("5> View Inventory");
		System.out.println("6> View Player Info");
		System.out.println("7> Sleep One day");
		System.out.println("8> Exit Game");
		System.out.print("Please select an action (1-8) >> ");
		switch (Input.readInt()) {
			case 1:
				viewPlants();
				break;
			case 2:
				seedPlant();
				break;
			case 3:
				waterPlant();
				break;
			case 4:
				harvestFruit();
				break;
			case 5:
				viewInventory();
				break;
			case 6:
				viewPlayerInfo();
				break;
			case 7:
				sleep();
				break;
			case 8:
				return true;
		}
		return false;
	}

	public void viewPlants() {
		List<Growable> plants = this.gameController.getPlants();
		System.out.println("\n-- Your Garden Bed --");
		int index = 0;
		for(Growable plant : plants) {
			System.out.println(++index + "> " + plant.getName());
			System.out.println("\tAge> " + plant.getAge() + " days");
			System.out.println("\tStatus> " + plant.getStatus());
			System.out.println("\tDay until next status> " + (plant.getDaysNextStatus() == 0 ? "Unknown" : plant.getDaysNextStatus()) );
			System.out.print("\tWater : ");
			for (int i = 0; i < plant.getWaterInfo().getWater(); i++) {
				System.out.print("*");
			}
			for (int i = 0; i < plant.getWaterInfo().getWaterMax() - plant.getWaterInfo().getWater(); i++) {
				System.out.print(".");
			}
			System.out.print("  (" + plant.getWaterInfo().getWater() + "/" + plant.getWaterInfo().getWaterMax() + ")");
			System.out.println();
			System.out.print("\tHealth : ");
			for (int i = 0; i < plant.getHealthInfo().getHealth(); i++) {
				System.out.print("*");
			}
			for (int i = 0; i < plant.getHealthInfo().getHealthMax() - plant.getHealthInfo().getHealth(); i++) {
				System.out.print(".");
			}
			System.out.print("  (" + plant.getHealthInfo().getHealth() + "/" + plant.getHealthInfo().getHealthMax() + ")");
			System.out.println("\n");
		}
		Input.pressEnterKey();
	}

	public void seedPlant() {
		List<Seed> seeds = this.gameController.getSeeds();
		System.out.println("\n-- Pick a seed --");
		int index = 0;
		for(Seed seed : seeds) {
			System.out.println(++index + "> " + seed.getName());
		}
		System.out.print("Please select a seed (1-" + seeds.size() + ") >> ");


		int input = Input.readInt() - 1;
		if(seeds.size() > input && input >= 0) {
			// plant selected seed
			gameController.plantSeed(seeds.get(input));
		}

	}

	public void waterPlant() {
		List<Growable> plants = this.gameController.getPlants();
		System.out.println("\n-- Your Garden Bed --");
		int index = 0;
		for(Growable plant : plants) {
			System.out.println(++index + "> " + plant.getName() + "  (" + plant.getWaterInfo().getWater() + "/" + plant.getWaterInfo().getWaterMax() + ")");
		}
		System.out.print("Please select a plant to water (1-" + plants.size() + ") >> ");

		int input = Input.readInt() - 1;
		if(plants.size() > input && input >= 0) {
			gameController.waterPlant(plants.get(input));
		}

	}

	public void harvestFruit() {
		List<Growable> plants = this.gameController.getPlants();
		if(plants.size() > 0) {
			System.out.println("\n-- Your Plants List with Fruit --");
			int index = 0;
			for(Growable plant : plants) {
				++index;
				if(plant.getStatus().equals("HarvestReady")) {
					System.out.println(index + "> " + plant.getName() + "  (" + plant.getFruit().getName() + ")");
				}
			}
			System.out.print("Please select a plant to harvest >> ");
			int input = Input.readInt() - 1;
			if(plants.size() > input && input >= 0) {
				gameController.harvestPlant(plants.get(input));
			}
		}
		else {
			System.out.println("\n -- No Plant in Garden Bed --");
		}
	}

	public void viewInventory() {
		List<Item> items = this.gameController.getPlayer().getInventory().getItems();
		System.out.println("\n-- Your Items --");
		int index = 0;
		for(Item item : items) {
			System.out.println(++index + "> [" + item.getClass().getSimpleName() + "] " + item.getName());
		}
		System.out.println("Select an item number to do an action");
		System.out.println("Other number will exit this menu");
		System.out.print("> ");
		int input = Input.readInt() - 1;
		if(items.size() > input && input >= 0) {
			if(items.get(input) instanceof Fruit) {
				this.actionFruit((Fruit) items.get(input));
			}
		}
	}

	public void actionFruit(Fruit fruit) {
		System.out.println("\n1> View Fruit");
		System.out.println("2> Eat Fruit");
		System.out.println("3> Destroy Fruit");
		System.out.println("Please select an action (1-3) > ");
		int input = Input.readInt();
		switch (input) {
			case 1 :
				System.out.println("\n-- Fruit --");
				System.out.println("Name> " + fruit.getName());
				System.out.println("Hunger Stat > " + fruit.getHungerStat());
				Input.pressEnterKey();
				break;
			case 2 :
				this.gameController.eatFruit(fruit);
				break;
			case 3 :
				this.gameController.destoryFruit(fruit);
				break;
		}
	}

	public void viewPlayerInfo() {
		System.out.println("\n-- Player Info --");
		System.out.println("Name> " + this.gameController.getPlayer().getName());
		System.out.print("Hunger> ");
		for (int i = 0; i < this.gameController.getPlayer().getHunger(); i++) {
			System.out.print("*");
		}
		for (int i = 0; i < this.gameController.getPlayer().getMaxHunger() - this.gameController.getPlayer().getHunger(); i++) {
			System.out.print(".");
		}
		System.out.print("  (" + this.gameController.getPlayer().getHunger() + "/" + this.gameController.getPlayer().getMaxHunger() + ")");
		Input.pressEnterKey();
	}

	public void sleep() {
		this.gameController.sleep();
		System.out.println("\nA long hardworking day have past !!");
		Input.pressEnterKey();
	}

}