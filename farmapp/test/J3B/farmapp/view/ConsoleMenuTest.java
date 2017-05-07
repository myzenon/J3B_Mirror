package J3B.farmapp.view;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import J3B.farmapp.controller.GameController;
import J3B.farmapp.model.impl.Plant;
import J3B.farmapp.util.Input;

public class ConsoleMenuTest {
	ConsoleMenu consoleMenu;

    @Test
    public void showAll() throws Exception {
    	GameController gc = new GameController();
    	consoleMenu = new ConsoleMenu(gc);
    	 Input.setSystemInput(new ByteArrayInputStream("7 1".getBytes()));
        consoleMenu.showAll();
    }
    
}
