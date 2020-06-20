package back.server.full;

import front.model.Message;
import front.model.User;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerThread extends Thread {
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            input  = new ObjectInputStream(socket.getInputStream());
            output = new ObjectOutputStream(socket.getOutputStream());

            Message message = (Message) input.readObject();
            System.out.println(message);
            output.writeObject(message);
            sendToAll(message);

        } catch(IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void sendToAll(Message message) {

    }
}
