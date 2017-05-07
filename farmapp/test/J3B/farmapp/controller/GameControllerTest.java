package J3B.farmapp.controller;

import J3B.farmapp.model.Growable;
import J3B.farmapp.model.impl.Bag;
import J3B.farmapp.model.impl.Fruit;
import J3B.farmapp.model.impl.HealthInfo;
import J3B.farmapp.model.impl.Plant;
import J3B.farmapp.model.impl.Player;
import J3B.farmapp.model.impl.Seed;
import J3B.farmapp.model.impl.WaterInfo;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;

public class GameControllerTest {
	WaterInfo waterInfo1 = new WaterInfo(10, 20, 20, 80, 20);
	HealthInfo healthInfo1 = new HealthInfo(30, 50, 100);
	Fruit fruit1 = new Fruit("Test Fruit", 50);
    @Test
     public void getPlants() throws Exception {
        GameController gameController = new GameController();
        Plant plant = new Plant("testPlant", 5, waterInfo1, healthInfo1, fruit1);
        gameController.plantSeed(new Seed("testSeed", plant));
        assertEquals(gameController.getPlants().contains(plant), false);
    }

    @Test
    public void getSeeds() throws Exception {
        GameController gameController = new GameController();
        List<Seed> seeds = gameController.getSeeds();
        
        // check whether List<Seeds> is not null
        assertNotEquals(gameController.getSeeds(), null);

        // gameController constructor have mock 3 seeds in the list
        assertEquals(seeds.size(),2);
        
    }

    @Test
    public void plantSeed() throws Exception {
        GameController gameController = new GameController();
        Plant plant = new Plant("testPlant1", 1, waterInfo1, healthInfo1, fruit1);
        gameController.plantSeed(new Seed("testSeed1", plant));
        //must be 1 in gardenbed
        assertEquals(gameController.getPlants().size(),1);
    }


    @Test
    public void sleep() throws Exception {
        GameController gameController = new GameController();
        gameController.plantSeed(new Seed("testSeed1", new Plant("testPlant1", 1, waterInfo1, healthInfo1, fruit1)));
        gameController.plantSeed(new Seed("testSeed2", new Plant("testPlant2", 2, waterInfo1, healthInfo1, fruit1)));
        gameController.plantSeed(new Seed("testSeed3", new Plant("testPlant3", 3, waterInfo1, healthInfo1, fruit1)));
        gameController.sleep();
        gameController.sleep();
        for(Growable plant : gameController.getPlants()) {
            assertEquals(plant.getAge(), 2);
        }
    }
    @Test
    public void waterPlant(){
    	Plant plant =  new Plant("testPlant1", 1, waterInfo1, healthInfo1, fruit1);
         GameController gameController = new GameController();
         plant.grow();
         plant.grow();
         plant.grow();
         gameController.waterPlant(plant);//+2
         gameController.waterPlant(plant);//+2 = 12
         assertEquals(plant.getWaterInfo().getWater(),12);
    }
    @Test
    public void getFruits(){
    	Bag iventory = new Bag();
    	Player player = new Player("Alex",iventory,100);
    	Fruit fruity = new Fruit("Test Fruit", 50);
    	player.getInventory().addItem(fruity);
    	//Test fruit must be in fruit list
    	  assertEquals(player.getInventory().getItems().get(0).getName(),"Test Fruit");
    	
    }

}