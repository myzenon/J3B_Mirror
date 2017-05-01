package J3B.farmapp.model.impl;

import J3B.farmapp.model.Growable;
import org.junit.Test;

import java.util.List;
import java.util.*;

import static org.junit.Assert.*;

public class GardenBedTest {

    @Test
    public void getCapacity() throws Exception {
        GardenBed gardenBed = new GardenBed( 20 );
        assertEquals(gardenBed.getCapacity(),20);
    }

    @Test
    public void setCapacity() throws Exception {
        GardenBed gardenBed = new GardenBed(0);
        gardenBed.setCapacity(20);
        assertEquals(gardenBed.getCapacity(),20);
    }

    @Test
    public void getPlants() throws Exception {
        List<Growable> listPlants = new ArrayList<Growable>();
        Seed coconutSeed = new Seed("coconutSeed", new Plant("coconut",10));
        Seed riceSeed = new Seed("riceSeed", new Plant("rice",10));
        listPlants.add(coconutSeed.plant());
        listPlants.add(riceSeed.plant());
        GardenBed gardenBed = new GardenBed(2);
        gardenBed.addPlant(coconutSeed);
        gardenBed.addPlant(riceSeed);
        assertEquals(gardenBed.getPlants(), listPlants);
    }

    @Test
    public void addPlant() throws Exception {
        Seed coconutSeed = new Seed("coconutSeed", new Plant("coconut",10));
        GardenBed gardenBed = new GardenBed(2);
        gardenBed.addPlant(coconutSeed);
        assertEquals(gardenBed.getPlants().contains(coconutSeed.plant()),true);
    }

    @Test
    public void addPlantFull() throws Exception {
        Seed coconutSeed = new Seed("coconutSeed", new Plant("coconut",10));
        GardenBed gardenBed = new GardenBed(2);
        gardenBed.addPlant(coconutSeed);
        gardenBed.addPlant(coconutSeed);
        assertEquals(gardenBed.addPlant(coconutSeed),false);
    }


    @Test
    public void removePlant() throws Exception {
        Seed coconutSeed = new Seed("coconutSeed", new Plant("coconut",10));
        Seed riceSeed = new Seed("riceSeed", new Plant("rice",10));
        GardenBed gardenBed = new GardenBed(2);
        gardenBed.addPlant(coconutSeed);
        gardenBed.addPlant(riceSeed);
        gardenBed.removePlant(coconutSeed.plant());
        assertEquals(gardenBed.getPlants().contains(coconutSeed.plant()),false);
    }

}