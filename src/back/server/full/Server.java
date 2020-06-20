package back.server.full;

import back.server.simple.ClientHandler;
import front.model.Constants;
import front.model.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends AbstractServer {
    private ServerSocket serverSocket;

    @Override
    public void connect(String ip) {
        try {
            serverSocket = new ServerSocket(Constants.PORT_SERVER);
            while (true) {
                System.out.println("[SERVER] Waiting for client connection...");
                Socket client = serverSocket.accept();
                System.out.println("[SERVER]Connected to client : " + ip);
                Thread t = new ServerThread(client);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
