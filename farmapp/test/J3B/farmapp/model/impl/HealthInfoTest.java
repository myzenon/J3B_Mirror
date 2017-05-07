package J3B.farmapp.model.impl;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by HP OMEN on 7/5/2560.
 */
public class HealthInfoTest {
    WaterInfo waterInfo1 = new WaterInfo(10, 20, 20, 80, 20);
    WaterInfo waterInfo2 = new WaterInfo(30, 60, 10, 90, 5);
    HealthInfo healthInfo1 = new HealthInfo(30, 50, 100);
    HealthInfo healthInfo2 = new HealthInfo(10, 0, 20);
    Fruit fruit1 = new Fruit("Coconut", 50);
    Fruit fruit2 = new Fruit("Apple", 7);


    @Test
    public void getHealthPercent() throws Exception {
        Plant plant2 = new Plant("Apple Tree", 1, waterInfo2, healthInfo2, fruit2);
       assertEquals(plant2.getHealthInfo().getHealthPercent(),100);
    }

    @Test
    public void getHealth50Percent() throws Exception {
        Plant plant1 = new Plant("Coconut Tree", 10, waterInfo1, healthInfo1, fruit1);
        plant1.grow();
        plant1.grow();
        plant1.grow();
        plant1.grow();
        plant1.grow();
        assertEquals(plant1.getHealthInfo().getHealthPercent(),50);
    }

    @Test
    public void nextPhase() throws Exception {
        HealthInfo healthInfo = new HealthInfo(30, 50, 100);
        WaterInfo waterInfo = new WaterInfo(10, 20, 20, 80, 20);
        waterInfo.nextPhase();
        healthInfo.nextPhase(waterInfo);
        assertEquals(healthInfo.getHealthPercent(),100);
        waterInfo.nextPhase();
        waterInfo.nextPhase();
        waterInfo.nextPhase();
        waterInfo.nextPhase();
        healthInfo.nextPhase(waterInfo);
        assertEquals(healthInfo.getHealthPercent(),50);
    }

    @Test
    public void getHealth() throws Exception {
        Plant plant2 = new Plant("Apple Tree", 1, waterInfo2, healthInfo2, fruit2);
        assertEquals(plant2.getHealthInfo().getHealth(),20);
    }

    @Test
    public void getHealthMax() throws Exception {
        Plant plant1 = new Plant("Coconut Tree", 10, waterInfo1, healthInfo1, fruit1);
        assertEquals(plant1.getHealthInfo().getHealthMax(),100);
    }

}