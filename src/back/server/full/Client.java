package back.server.full;

import front.model.Constants;
import front.model.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client extends AbstractServer {
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private Socket socket;

    public void connect(String ip) {
        try {
            socket = new Socket(ip, Constants.PORT_SERVER);
            output = new ObjectOutputStream(socket.getOutputStream());
            input  = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String ip, Message message) {
        try {
            socket = new Socket(ip, Constants.PORT_SERVER);
            output = new ObjectOutputStream(socket.getOutputStream());
            input  = new ObjectInputStream(socket.getInputStream());

            System.out.println("message to send : \n" + message);
            output.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getMessage(String ip) {
        try {
            socket = new Socket(ip, Constants.PORT_SERVER);
            output = new ObjectOutputStream(socket.getOutputStream());
            input  = new ObjectInputStream(socket.getInputStream());

            Message message = (Message) input.readObject();
            System.out.println("Received message : " + message);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
