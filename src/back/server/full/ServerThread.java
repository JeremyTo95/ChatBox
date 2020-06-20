package back.server.full;

import front.model.Constants;
import front.model.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.UUID;

public class ServerThread extends Thread {
    private Socket socket;
    private List<ServerThread> clients;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public ServerThread(Socket socket, List<ServerThread> clients) throws IOException {
        this.socket = socket;
        this.clients = clients;
        this.input  = new ObjectInputStream(socket.getInputStream());
        this.output = new ObjectOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            while(true) {
                String query = (String) input.readObject();
                System.out.println("[SERVER][QUERY] inputQuery : " + query + "\n");

                if (query.startsWith("Message{idMessage=")) {
                    Message message = Message.fromString(query);
                    System.out.println("[SERVER][DATABASE] newMessage to stock into db :\n" + message + "\n");
                    sendToAll(message);
                    // TODO: WRITE MESSAGE INTO DATABASE
                } else if (query.equals(Constants.QUERY_GET_MESSAGES)) {
                    // TODO: GET ALL MESSAGES FROM DB AND SEND TO THE USER
                    //              output.writeObject(message);
                    Message msg = new Message(UUID.randomUUID(), "Test get all messages");
                    sendToAll(msg);
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void sendToAll(Message message) throws IOException {
        for (int i = 0; i < clients.size(); i++) {
            clients.get(i).output.writeObject(message.toString());
        }
    }
}
