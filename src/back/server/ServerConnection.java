package back.server;

import back.db.DataBaseManager;
import front.controller.HomeViewController;
import front.model.*;
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

    private DefaultListModel listMessageModel;
    private DefaultListModel listDiscussionModel;

    /**
     * This constructor initialize the ServerConnection features
     * @param socket socket
     * @param input Object input stream
     * @param output Object input stream
     * @param listMessageModel Space where we print message
     * @param listDiscussionModel Space where we print discussion name
     */
    public ServerConnection(Socket socket, ObjectInputStream input, ObjectOutputStream output, DefaultListModel listMessageModel, DefaultListModel listDiscussionModel) {
        this.socket = socket;
        this.input  = input;
        this.listMessageModel = listMessageModel;
        this.listDiscussionModel = listDiscussionModel;
    }

    /**
     * This method send messages from the input object stream to the user socket
     */
    @Override
    public void run() {
        Message serverResponse = null;
        try {
           while (!isInterrupted()) {
               String inputStr = (String) input.readObject();
               System.out.println("inputStr : " + inputStr);
               if (inputStr == null) break;
               else if (inputStr.equals(Constants.QUERY_DISCONNECT_SOCKET)) {
                   interrupt();
                   break;
               } else if (inputStr.equals(Constants.QUERY_ADD_NEW_DISCUSSION)) {
                   listDiscussionModel.clear();
                   HomeViewController.setDefaultListModel(DataBaseManager.getAllChatRoom(), UserRoom.getUserRoomByIdUser(Constants.currentUser.getId()), listDiscussionModel);
               } else {
                   serverResponse = Message.fromString(inputStr);
                   System.out.print("Server says : " + serverResponse + "\nAnd listMessageModel : " + listMessageModel + "\n> ");
                   DataBaseManager.getAllMessage().add(serverResponse);
                   if (listMessageModel != null) HomeView.writeNewMessage(listMessageModel, Constants.chatRoom, serverResponse);
               }
           }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
