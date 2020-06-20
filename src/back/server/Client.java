package back.server;

import front.model.Constants;
import front.model.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * <h1>Object Client</h1>
 * This class creates the client of socket which communicate to the server
 */

public class Client extends AbstractServer {
    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;

    private static ServerConnection serverConnection;

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

            serverConnection = new ServerConnection(socket, input, output);
            new Thread(serverConnection).start();

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
            System.out.println("message to send : \n" + message.toString());
            output.writeObject(message.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
