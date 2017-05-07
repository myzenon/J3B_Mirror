package J3B.farmapp.mainPackage;

import J3B.farmapp.util.Input;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class GardenGameTest {
    @Test
    public void main() {
        Input.setSystemInput(new ByteArrayInputStream("8".getBytes()));
        GardenGame.main(null);
    }
}