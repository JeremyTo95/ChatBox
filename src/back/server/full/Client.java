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
    private String ip;

    public void connect(String ip) {
        this.ip = ip;
        try {
            socket = new Socket(ip, Constants.PORT_SERVER);
            output = new ObjectOutputStream(socket.getOutputStream());
            input  = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendMessage(Message message) {
        try {
            if (ip != null) {
                socket = new Socket(ip, Constants.PORT_SERVER);
                output = new ObjectOutputStream(socket.getOutputStream());
                input  = new ObjectInputStream(socket.getInputStream());

                output.writeObject(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Message getMessage() {
        try {
            if (ip != null) {
                socket = new Socket(ip, Constants.PORT_SERVER);
                output = new ObjectOutputStream(socket.getOutputStream());
                input  = new ObjectInputStream(socket.getInputStream());

                Message message = (Message) input.readObject();
                return message;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
