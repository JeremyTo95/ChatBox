package back.server;

import front.model.Constants;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <h1>Object Server</h1>
 * This class create the server of socket
 */
public class Server extends AbstractServer {
    private ServerSocket serverSocket;

    private static List<ServerThread> clients = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(Constants.MAX_PEOPLE);

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
                System.out.println("[SERVER] Add new client to list");
                clients.add(clientThread);
                System.out.println("[SERVER] Execute the thread");
//                pool.execute(clientThread);

                new Thread(clientThread).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
