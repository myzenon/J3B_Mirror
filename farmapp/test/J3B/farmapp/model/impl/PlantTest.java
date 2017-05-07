package J3B.farmapp.model.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlantTest {
	WaterInfo waterInfo1 = new WaterInfo(10, 20, 20, 80, 20);
	HealthInfo healthInfo1 = new HealthInfo(30, 50, 100);
	Fruit fruit1 = new Fruit("Test Fruit", 50);
    @Test
    public void grow() throws Exception {
        Plant plant = new Plant("testPlant", 3, waterInfo1, healthInfo1, fruit1);
        plant.grow();
        plant.grow();
        assertEquals(plant.getAge(), 2);
    }

    @Test
    public void getStatus() throws Exception {
        Plant plant = new Plant("testPlant", 3, waterInfo1, healthInfo1, fruit1);
        plant.grow();
        plant.grow();
        plant.grow();
        plant.grow();
        plant.grow();
        assertEquals(plant.getStatus(), "Seedling");
    }

    @Test
    public void getStatusFinal() throws Exception {
        Plant plant = new Plant("testPlant", 1, waterInfo1, healthInfo1, fruit1);
        plant.grow();
        plant.grow();
        plant.grow();
        plant.grow();
        plant.grow();
        plant.grow();
        plant.grow();
        plant.grow();
        plant.grow();
        plant.grow();
        plant.grow();
        assertEquals(plant.getStatus(), "HarvestReady");
        Fruit fruit = (Fruit)plant.harvest();
        assertEquals(fruit.getName(),"Test Fruit");
    }

    @Test
    public void getAge() throws Exception {
        Plant plant = new Plant("testPlant", 3, waterInfo1, healthInfo1, fruit1);
        plant.grow();
        plant.grow();
        assertEquals(plant.getAge(), 2);
    }

    @Test
    public void getName() throws Exception {
        Plant plant = new Plant("testPlant", 3, waterInfo1, healthInfo1, fruit1);
        assertEquals(plant.getName(), "testPlant");
    }

    @Test
    public void getDaysNextStatus() throws Exception {
        Plant plant = new Plant("testPlant", 3, waterInfo1, healthInfo1, fruit1);
        plant.grow();
        plant.grow();
        plant.grow();
        plant.grow();
        plant.grow();
        assertEquals(plant.getDaysNextStatus(), 1);
    }

    @Test
    public void getDaysNextStatusFinal() throws Exception {
        Plant plant = new Plant("testPlant", 1, waterInfo1, healthInfo1, fruit1);
        plant.grow();
        plant.grow();
        plant.grow();
        plant.grow();
        plant.grow();
        plant.grow();
        plant.grow();
        plant.grow();
        plant.grow();
        assertEquals(plant.getDaysNextStatus(), 0);

    }
    
    @Test
    public void WaterAndPhasePlant(){
    	Plant plant = new Plant("testPlant", 1, waterInfo1, healthInfo1, fruit1);
    	// decrease the water 
    	plant.getWaterInfo().nextPhase();
    	plant.getWaterInfo().nextPhase();
    	// should decrease to 12
    	 assertEquals(plant.getWaterInfo().getWater(), 12);
    	// should increase to 14
    	 plant.water();
    	 assertEquals(plant.getWaterInfo().getWater(), 14);
    	 
    }
    @Test
    public void clonePlant(){
    	Plant plant = new Plant("testPlant", 1, waterInfo1, healthInfo1, fruit1);
    	Plant plant2 = plant.clone();
    	
   	 assertEquals(plant.getName(),plant2.getName());
   	assertEquals(plant.getFruit().getName(),plant2.getFruit().getName());
	assertEquals(plant.getHealthInfo().getHealth(),plant2.getHealthInfo().getHealth());
    }
    @Test
    public void harvestFruit(){
    	
    }
}