package J3B.farmapp.controller;

import J3B.farmapp.model.Growable;
import J3B.farmapp.model.impl.Plant;
import J3B.farmapp.model.impl.Seed;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameControllerTest {

    @Test
    public void getPlants() throws Exception {
        GameController gameController = new GameController();
        Plant plant = new Plant("testPlant", 5);
        gameController.plantSeed(new Seed("testSeed", plant));
        assertEquals(gameController.getPlants().contains(plant), true);
    }

    @Test
    public void getSeeds() throws Exception {
        GameController gameController = new GameController();

        // check whether List<Seeds> is not null
        assertNotEquals(gameController.getSeeds(), null);

        // gameController constructor have mock 3 seeds in the list
        assertEquals(gameController.getSeeds().size(),3);
    }

    @Test
    public void plantSeed() throws Exception {
        GameController gameController = new GameController();
        Plant plant = new Plant("testPlant1", 1);
        gameController.plantSeed(new Seed("testSeed1", plant));
        assertEquals(gameController.getPlants().contains(plant), true);
    }

    @Test
    public void sleep() throws Exception {
        GameController gameController = new GameController();
        gameController.plantSeed(new Seed("testSeed1", new Plant("testPlant1", 1)));
        gameController.plantSeed(new Seed("testSeed2", new Plant("testPlant2", 2)));
        gameController.plantSeed(new Seed("testSeed3", new Plant("testPlant3", 3)));
        gameController.sleep();
        gameController.sleep();
        for(Growable plant : gameController.getPlants()) {
            assertEquals(plant.getAge(), 2);
        }
    }

}