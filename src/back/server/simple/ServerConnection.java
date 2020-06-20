package back.server.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerConnection implements Runnable {
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    public ServerConnection(Socket socket) throws IOException {
        this.socket = socket;
        this.input  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.output = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public void run() {
        String serverResponse = null;
        try {
            while (true) {
                serverResponse = input.readLine();
                if (serverResponse == null) break;
                System.out.println("Server says : " + serverResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
