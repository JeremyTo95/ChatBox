package back.server.full;

import front.model.Message;

import java.io.*;
import java.net.Socket;

public class ServerConnection implements Runnable {
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public ServerConnection(Socket socket, ObjectInputStream input, ObjectOutputStream output) {
        this.socket = socket;
        this.input  = input;
        this.output = output;
    }

    //TODO: Get data drom database and show into the chat
    @Override
    public void run() {
        Message serverResponse = null;
        try {
           while (true) {
                serverResponse = Message.fromString((String) input.readObject());
                if (serverResponse == null) break;
                System.out.println("Server says : " + serverResponse);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
