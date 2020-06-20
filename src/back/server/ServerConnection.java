package back.server;

import front.model.Message;

import java.io.*;
import java.net.Socket;

/**
 * <h1>Object ServerConnection</h1>
 * This class enable to send a message from the server to every client socket connected to the server
 */
public class ServerConnection implements Runnable {
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    /**
     * This constructor initialize the ServerConnection features
     * @param socket socket
     * @param input Object input stream
     * @param output Object input stream
     */
    public ServerConnection(Socket socket, ObjectInputStream input, ObjectOutputStream output) {
        this.socket = socket;
        this.input  = input;
        this.output = output;
    }

    //TODO: Get data drom database and show into the chat

    /**
     * This method send messages from the input object stream to the user socket
     */
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
