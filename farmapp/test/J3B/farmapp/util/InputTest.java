package J3B.farmapp.util;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class InputTest {
    @Test
    public void readString() throws Exception {
        Input.setSystemInput(new ByteArrayInputStream("Test String".getBytes()));
        assertEquals(Input.readString(), "Test String");
    }

    @Test
    public void readStringError() throws Exception {
        Input.setSystemInput(new InputStream() {
            @Override
            public int read() throws IOException {
                throw new IOException("error");
            }
        });
        assertEquals(Input.readString(), "error");
    }

    @Test
    public void readToken() throws Exception {
        Input.setSystemInput(new ByteArrayInputStream("Test String".getBytes()));
        assertEquals(Input.readToken(), "Test");
    }

    @Test
    public void readTokenError() throws Exception {
        Input.setSystemInput(new ByteArrayInputStream("Test String".getBytes()));
        assertEquals(Input.readToken(), "Test");
        assertEquals(Input.readToken(), "String");
        assertEquals(Input.readToken(), "error");
    }

    @Test
    public void readInt() throws Exception {
        Input.setSystemInput(new ByteArrayInputStream("23".getBytes()));
        assertEquals(Input.readInt(), 23);
    }

    @Test
    public void readIntError() throws Exception {
        Input.setSystemInput(new ByteArrayInputStream("23.5".getBytes()));
        assertEquals(Input.readInt(), -1);
    }

    @Test
    public void pressEnterKey() throws Exception {
        Input.pressEnterKey();
    }

}