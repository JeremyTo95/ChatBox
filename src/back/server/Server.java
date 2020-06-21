package back.server;

import front.model.Constants;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Object Server</h1>
 * This class create the server of socket
 */
public class Server extends AbstractServer {
    private ServerSocket serverSocket;

    private static List<ServerThread> clients = new ArrayList<>();

    /**
     * This method enable to connect the client to an ip
     * @param ip of the server
     */
    @Override
    public void connect(String ip) {
        try {
            serverSocket = new ServerSocket(Constants.PORT_SERVER);
            while (true) {
                System.out.println("\n[SERVER] Waiting for client connection...");
                Socket client = serverSocket.accept();
                System.out.println("[SERVER] Connected to client : " + ip);

                ServerThread clientThread = new ServerThread(client, clients);
                clients.add(clientThread);

                new Thread(clientThread).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
