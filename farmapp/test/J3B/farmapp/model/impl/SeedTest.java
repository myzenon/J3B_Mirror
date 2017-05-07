package J3B.farmapp.model.impl;

import static org.junit.Assert.*;

import J3B.farmapp.model.Growable;
import org.junit.Test;

public class SeedTest {
	WaterInfo waterInfo1 = new WaterInfo(10, 20, 20, 80, 20);
	HealthInfo healthInfo1 = new HealthInfo(30, 50, 100);
	Fruit fruit1 = new Fruit("Coconut", 50);
	@Test
	public void getName() {
		Seed seed = new Seed("coconut seed", new Plant("coconut tree" , 1, waterInfo1, healthInfo1, fruit1));
		assertEquals(seed.getName(), "coconut seed" );
	}

    @Test
    public void plant() {
	    Plant plant = new Plant("coconut tree" , 1, waterInfo1, healthInfo1, fruit1);
        Seed seed = new Seed("coconut seed", plant);
       assertEquals(seed.plant().getName(), plant.getName());
    }	

}
