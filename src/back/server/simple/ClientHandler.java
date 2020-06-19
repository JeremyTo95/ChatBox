package back.server.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

import static back.server.simple.Server.getRandomName;

public class ClientHandler implements Runnable {
    private Socket              client;
    private BufferedReader      input;
    private PrintWriter         output;
    private List<ClientHandler> clients;

    public ClientHandler(Socket clientSocket, List<ClientHandler> clients) throws IOException {
        this.client  = clientSocket;
        this.clients = clients;
        this.input   = new BufferedReader(new InputStreamReader(client.getInputStream()));
        this.output  = new PrintWriter(client.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String request = input.readLine();
                if (request.contains("name")) output.println("new Name : " + getRandomName());
                else if (request.startsWith("say")) {
                    int firstSpace = request.indexOf(" ");
                    if (firstSpace != -1) outToAll(request.substring(firstSpace+1));

                } else output.println("Type 'tell me a name' to get a random name");

            }
        } catch (IOException e) {
            System.err.println("IOException in client handler");
            System.err.println(e.getStackTrace());
        } finally {
            output.close();
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void outToAll(String msg) {
        for (ClientHandler clientHandler : clients) {
            clientHandler.output.println(msg);
        }
    }
}
