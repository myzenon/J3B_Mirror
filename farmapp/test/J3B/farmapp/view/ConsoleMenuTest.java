package J3B.farmapp.view;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import J3B.farmapp.model.impl.Fruit;
import org.junit.Test;

import J3B.farmapp.controller.GameController;
import J3B.farmapp.model.impl.Plant;
import J3B.farmapp.util.Input;

public class ConsoleMenuTest {
    @Test
    public void seedPlant() throws Exception {
        GameController gc = new GameController();
        consoleMenu = new ConsoleMenu(gc);
        Input.setSystemInput(new ByteArrayInputStream("2".getBytes()));
        consoleMenu.seedPlant();
    }

    @Test
    public void sleep() throws Exception {
        GameController gc = new GameController();
        consoleMenu = new ConsoleMenu(gc);
        Input.setSystemInput(new ByteArrayInputStream("1".getBytes()));
        consoleMenu.sleep();
    }

    @Test
    public void viewPlants() throws Exception {
        GameController gc = new GameController();
        consoleMenu = new ConsoleMenu(gc);
        gc.plantSeed(gc.getSeeds().get(0));
        for (int i = 0; i < 5 ; i++) {
            gc.sleep();
        }
        Input.setSystemInput(new ByteArrayInputStream("1".getBytes()));
        consoleMenu.viewPlants();


    }
    @Test
    public void waterPlant() throws Exception {
        GameController gc = new GameController();
        consoleMenu = new ConsoleMenu(gc);
        gc.plantSeed(gc.getSeeds().get(0));
        Input.setSystemInput(new ByteArrayInputStream("1".getBytes()));
        consoleMenu.waterPlant();
    }

    @Test
    public void harvestFruit() throws Exception {
        GameController gc = new GameController();
        consoleMenu = new ConsoleMenu(gc);
        Input.setSystemInput(new ByteArrayInputStream("1".getBytes()));
        consoleMenu.harvestFruit();
        gc.plantSeed(gc.getSeeds().get(1));
        for (int i = 0; i < 100 ; i++) {
            gc.sleep();
        }
        Input.setSystemInput(new ByteArrayInputStream("1".getBytes()));
        consoleMenu.harvestFruit();
    }

    @Test
    public void viewInventory() throws Exception {
        GameController gc = new GameController();
        consoleMenu = new ConsoleMenu(gc);
        gc.getPlayer().getInventory().addItem(new Fruit("Apple",10));
        gc.getPlayer().getInventory().addItem(new Fruit("Orange",10));
        gc.getPlayer().getInventory().addItem(new Fruit("Mango",10));
        Input.setSystemInput(new ByteArrayInputStream("3 1".getBytes()));
        consoleMenu.viewInventory();
        Input.setSystemInput(new ByteArrayInputStream("3 2".getBytes()));
        consoleMenu.viewInventory();
        Input.setSystemInput(new ByteArrayInputStream("3 3".getBytes()));
        consoleMenu.viewInventory();
    }






    ConsoleMenu consoleMenu;

    @Test
    public void showAll() throws Exception {
    	GameController gc = new GameController();
    	consoleMenu = new ConsoleMenu(gc);
        gc.getPlayer().getInventory().addItem(new Fruit("Apple",10));
        gc.getPlayer().getInventory().addItem(new Fruit("Orange",10));
        gc.getPlayer().getInventory().addItem(new Fruit("Mango",10));


       Input.setSystemInput(new ByteArrayInputStream("5 3 1".getBytes()));
        consoleMenu.showAll();

        Input.setSystemInput(new ByteArrayInputStream("5 3 2".getBytes()));
        consoleMenu.showAll();

        Input.setSystemInput(new ByteArrayInputStream("5 3 3".getBytes()));
        consoleMenu.showAll();


        consoleMenu.showAll();
        for (int i = 0; i < 2 ; i++) {
            gc.sleep();
        }
        Input.setSystemInput(new ByteArrayInputStream("1 1".getBytes()));
        consoleMenu.showAll();

        Input.setSystemInput(new ByteArrayInputStream("2 1".getBytes()));
        consoleMenu.showAll();

        Input.setSystemInput(new ByteArrayInputStream("6 1".getBytes()));
        consoleMenu.showAll();

        Input.setSystemInput(new ByteArrayInputStream("7 1".getBytes()));
        consoleMenu.showAll();

        Input.setSystemInput(new ByteArrayInputStream("3 1".getBytes()));
        consoleMenu.showAll();

        Input.setSystemInput(new ByteArrayInputStream("4 1".getBytes()));
        consoleMenu.showAll();

        Input.setSystemInput(new ByteArrayInputStream("8 1".getBytes()));
        consoleMenu.showAll();


    }
    
}
