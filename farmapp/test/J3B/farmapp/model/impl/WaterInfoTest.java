package J3B.farmapp.model.impl;

import static org.junit.Assert.*;

import org.junit.Test;

public class WaterInfoTest {
	WaterInfo waterInfo1 = new WaterInfo(10, 20, 20, 80, 20);
	HealthInfo healthInfo1 = new HealthInfo(30, 50, 100);
	Fruit fruit1 = new Fruit("Test Fruit", 50);

	//some method are already tested in Plant
    @Test
    public void getWaterMax() throws Exception {
    	//water max 20
    	 Plant plant = new Plant("testPlant", 1, waterInfo1, healthInfo1, fruit1);
    	 assertEquals(plant.getWaterInfo().getWaterMax(),20);
    }
    
    @Test
    public void waterMaxCapacity() throws Exception {
    	 Plant plant = new Plant("testPlant", 1, waterInfo1, healthInfo1, fruit1);
    	 plant.water();
    	 plant.water();
    	 plant.water();
    	 plant.water();
    	 plant.water();
    	 assertEquals(plant.getWaterInfo().getWaterMax(),20);
    }
}
