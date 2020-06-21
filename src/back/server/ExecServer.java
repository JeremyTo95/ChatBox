package back.server;

import front.model.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>Object ExecServer</h1>
 * This class is a test to execute the server side
 */
public class ExecServer {
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.connect(Constants.IP_SERVER);

        // TODO: Demarrer tous les servers des chatrooms
    }
}