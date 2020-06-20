package back.server.full;

import back.server.simple.ClientHandler;
import front.model.Constants;
import front.model.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server extends AbstractServer {
    private ServerSocket serverSocket;

    private static List<ServerThread> clients = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(Constants.MAX_PEOPLE);

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
