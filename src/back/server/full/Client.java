package back.server.full;

import front.model.Constants;
import front.model.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client extends AbstractServer {
    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;

    private static ServerConnection serverConnection;

    public void connect(String ip) {
        try {
            socket = new Socket(ip, Constants.PORT_SERVER);
            output = new ObjectOutputStream(socket.getOutputStream());
            input  = new ObjectInputStream(socket.getInputStream());

            serverConnection = new ServerConnection(socket, input, output);
            new Thread(serverConnection).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String ip, Message message) {
        try {
            System.out.println("message to send : \n" + message.toString());
            output.writeObject(message.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public void getMessage(String ip) {
        try {
            System.out.println("query : get all messages");
            output.writeObject(Constants.QUERY_GET_MESSAGES);

            Message message = (Message) input.readObject();
            System.out.println("Message receive : " + message);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/
}
