package back.server;

import front.model.Constants;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    static String[] names = {"Jérémy", "Sofiane", "Mostafa", "Yoann", "Raphaël"};

    private static List<ClientHandler> clients = new ArrayList<>();
    private static ExecutorService     pool    = Executors.newFixedThreadPool(Constants.MAX_PEOPLE);

    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(Constants.PORT_SERVER);

        while (true) {
            System.out.println("[SERVER] Waiting for client connection...");
            Socket client = listener.accept();
            System.out.println("[SERVER]Connected to client !");
            ClientHandler clientThread = new ClientHandler(client, clients);
            clients.add(clientThread);

            pool.execute(clientThread);
        }

    }

    public static String getRandomName() {
        return names[(int) (Math.random() * names.length)];
    }
}
