package J3B.farmapp.model.impl;

import static org.junit.Assert.*;

import J3B.farmapp.model.Growable;
import org.junit.Test;

public class SeedTest {

	@Test
	public void getName() {
		Seed seed = new Seed("papaya seed", new Plant("papaya" , 1));
		assertEquals(seed.getName(), "papaya seed" );
	}

    @Test
    public void plant() {
	    Plant plant = new Plant("papaya" , 1);
        Seed seed = new Seed("papaya seed", plant);
        assertEquals(seed.plant(), plant);
    }

}
