package J3B.farmapp.model.impl;

import J3B.farmapp.model.Growable;
import J3B.farmapp.model.Item;
import J3B.farmapp.model.Plantable;

public class Seed implements Plantable, Item {

	private String name;
	private Plant plant;

	public Seed(String name, Plant plant){
		this.name = name;
		this.plant = plant;
	}	

	public String getName() {
		return this.name;
	}

	public Growable plant(){
		return this.plant.clone();
	}

}
