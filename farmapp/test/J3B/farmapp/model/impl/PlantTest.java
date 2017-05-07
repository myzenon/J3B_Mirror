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
        assertEquals(plant.getStatus(), "HarvestReady");
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
        assertEquals(plant.getDaysNextStatus(), 0);
    }

}