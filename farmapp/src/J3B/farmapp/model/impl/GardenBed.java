package J3B.farmapp.model.impl;

import J3B.farmapp.model.Growable;
import J3B.farmapp.model.Plantable;

import java.util.ArrayList;
import java.util.List;

public class GardenBed {

    private List<Growable> plants = new ArrayList<Growable>();
    private int capacity;

    public GardenBed(int capacity){
    	this.capacity = capacity;
    }

    public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

	public List<Growable> getPlants() {
        return this.plants;
    }

    public boolean addPlant(Plantable plant) {
        if(this.plants.size() < capacity) {
            this.plants.add(plant.plant());
            return true;
        }
        return false;
    }

    public boolean removePlant(Growable plant) {
    	return this.plants.remove(plant);
    }

}
