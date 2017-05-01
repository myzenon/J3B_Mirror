package J3B.farmapp.view;

import java.util.List;
import J3B.farmapp.controller.GameController;
import J3B.farmapp.model.Growable;
import J3B.farmapp.model.impl.Seed;
import J3B.farmapp.util.Input;

public class ConsoleMenu {

	private GameController gameController;

	public ConsoleMenu(GameController gameController) {
		this.gameController = gameController;
	}

	public void showAll() {
		System.out.println("\n-- Select an action --");
		System.out.println("1> View Plants in Garden");
		System.out.println("2> Plant a seed");
		System.out.println("3> Sleep One day");
		System.out.print("Please select an action (1-3) >> ");
		switch (Input.readInt()) {
			case 1:
				viewPlants();
				break;
			case 2:
				seedPlant();
				break;
			case 3:
				sleep();
				break;
		}
	}

	public void viewPlants() {
		List<Growable> plants = this.gameController.getPlants();
		System.out.println("\n-- Your Garden Bed --");
		int index = 0;
		for(Growable plant : plants) {
			System.out.println(++index + "> " + plant.getName());
			System.out.println("\tAge> " + plant.getAge() + " days");
			System.out.println("\tStatus> " + plant.getStatus());
			System.out.println("\tDay until next status: " + plant.getDaysNextStatus());
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

		// plant selected seed
		gameController.plantSeed(seeds.get(Input.readInt() - 1));
	}

	public void sleep() {
		this.gameController.sleep();
		System.out.println("\nA long hardworking day have past !!");
		Input.pressEnterKey();
	}

}