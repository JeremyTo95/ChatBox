package back.server;

import front.model.ChatRoom;
import front.model.Constants;
import front.model.Message;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * <h1>Object Client</h1>
 * This class creates the client of socket which communicate to the server
 */

public class Client extends AbstractServer {
    private boolean isRunning;
    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private Thread serverConnectionThread;
    private DefaultListModel listMessageModel;
    private DefaultListModel listDiscussionModel;

    private static ServerConnection serverConnection;

    public Client() { isRunning = true; }

    public Client(DefaultListModel listMessageModel, DefaultListModel listDiscussionModel) {
        this.isRunning = true;
        this.listMessageModel = listMessageModel;
        this.listDiscussionModel = listDiscussionModel;
    }

    /**
     * This method enable to connect the client to an ip
     * @param ip of the server
     */
    @Override
    public void connect(String ip) {
        try {
            socket = new Socket(ip, Constants.PORT_SERVER);
            output = new ObjectOutputStream(socket.getOutputStream());
            input  = new ObjectInputStream(socket.getInputStream());

            serverConnection = new ServerConnection(socket, input, output, listMessageModel, listDiscussionModel);
            serverConnectionThread = new Thread(serverConnection);
            serverConnectionThread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method enable to send message to the server
     * @param message Message à envoyer au server
     */
    public void sendMessage(Message message) {
        try {
            output.writeObject(message.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method disconnect the client
     */
    public void disconnect() {
        try {
            output.writeObject(Constants.QUERY_DISCONNECT_SOCKET);
            serverConnectionThread.interrupt();
            isRunning = false;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addNewDiscussion() {
        try {
            output.writeObject(Constants.QUERY_ADD_NEW_DISCUSSION);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isRunning() {
        return isRunning;
    }
}
