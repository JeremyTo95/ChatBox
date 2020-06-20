package back.server;

import front.model.Constants;

/**
 * <h1>Object ExecServer</h1>
 * This class is a test to execute the server side
 */
public class ExecServer {
    public static void main(String[] args) {
        Server server = new Server();
        server.connect(Constants.IP_SERVER);

        // TODO: Demarrer tous les servers des chatrooms
    }
}