package back.server;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ClientTest {
    private Client client = new Client();

    @Test
    public void isRunning() { assertEquals(true, client.isRunning()); }
}