package back.server;

import front.model.Constants;
import front.model.Message;
import front.model.UserRoom;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.UUID;

/**
 * <h1>Object ServerThread</h1>
 * This class manage the server actions
 */
public class ServerThread extends Thread {
    private UUID id;
    private Socket socket;
    private List<ServerThread> clients;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    /**
     * This constructor initialize the class features
     *
     * @param socket Socket
     * @param clients List of clients server thread
     * @throws IOException
     */
    public ServerThread(Socket socket, List<ServerThread> clients) throws IOException {
        this.id      = UUID.randomUUID();
        this.socket  = socket;
        this.clients = clients;
        this.input   = new ObjectInputStream(socket.getInputStream());
        this.output  = new ObjectOutputStream(socket.getOutputStream());
    }

    /**
     * This methode manage the server
     */
    @Override
    public void run() {
        try {
            while(!isInterrupted()) {
                String query = (String) input.readObject();
                System.out.println("[SERVER][QUERY] inputQuery : " + query + "\n");

                if (query.startsWith("Message{idMessage=")) {
                    Message message = Message.fromString(query);
                    System.out.println("[SERVER][DATABASE] newMessage to stock into db :\n" + message + "\n");
                    sendToAll(message);
                    // saveMessageToDB(message); // TODO: WRITE MESSAGE INTO DATABASE
                } else if (query.equals(Constants.QUERY_DISCONNECT_SOCKET)) {
                    System.out.println("[SERVER][QUERY] A client has been disconnected...");
                    for (int i = 0; i < clients.size(); i++) {
                        if (clients.get(i).getUUID().equals(this.getUUID())) clients.remove(i);
                    }
                    break;
                } else if (query.equals(Constants.QUERY_ADD_NEW_DISCUSSION)) {
                    System.out.println("[SERVER][QUERY] A new discussion has been created...");
                    notifNewDiscussionGroup();
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method send a message to all clients
     *
     * @param message
     * @throws IOException
     */
    private void sendToAll(Message message) throws IOException {
        for (int i = 0; i < clients.size(); i++) {
            System.out.println("[SERVER][MESSAGE] sending message to client...");
            clients.get(i).output.writeObject(message.toString());
        }
    }

    private void notifNewDiscussionGroup() throws IOException {
        for (int i = 0; i < clients.size(); i++) {
            System.out.println("[SERVER][DISCUSSION] advertising new discussion group...");
            clients.get(i).output.writeObject(Constants.QUERY_ADD_NEW_DISCUSSION);
        }
    }

    public UUID getUUID() {
        return id;
    }
}
