package back.server;

import front.model.ChatRoom;
import front.model.Constants;
import front.model.Message;
import front.view.HomeView;

import javax.swing.*;
import java.io.*;
import java.lang.constant.Constable;
import java.net.Socket;

/**
 * <h1>Object ServerConnection</h1>
 * This class enable to send a message from the server to every client socket connected to the server
 */
public class ServerConnection extends Thread {
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    private DefaultListModel listMessageModel;

    /**
     * This constructor initialize the ServerConnection features
     * @param socket socket
     * @param input Object input stream
     * @param output Object input stream
     * @param listMessageModel Space where we print message
     */
    public ServerConnection(Socket socket, ObjectInputStream input, ObjectOutputStream output, DefaultListModel listMessageModel) {
        this.socket = socket;
        this.input  = input;
        this.output = output;
        this.listMessageModel = listMessageModel;
    }

    //TODO: Get data drom database and show into the chat

    /**
     * This method send messages from the input object stream to the user socket
     */
    @Override
    public void run() {
        Message serverResponse = null;
        try {
           while (!isInterrupted()) {
               String inputStr = (String) input.readObject();
               if (inputStr == null) break;
               else if (inputStr.equals(Constants.QUERY_DISCONNECT_SOCKET)) {
                   interrupt();
                   break;
               }
               serverResponse = Message.fromString(inputStr);
               System.out.print("Server says : " + serverResponse + "\nAnd listMessageModel : " + listMessageModel + "\n> ");
               if (listMessageModel != null) HomeView.writeNewMessage(listMessageModel, Constants.chatRoom, serverResponse);
           }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
