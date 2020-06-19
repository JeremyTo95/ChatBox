package back.server.simple;

import front.model.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(Constants.IP_SERVER, Constants.PORT_SERVER);

        ServerConnection serverConnection = new ServerConnection(socket);

//        BufferedReader input    = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter    output   = new PrintWriter(socket.getOutputStream(), true);

        new Thread(serverConnection).start();

        while (true) {
            System.out.print("> ");
            String command = keyboard.readLine();
            if (command.equals("quit")) break;
            output.println(command);
//            String serverResponse = input.readLine();
//            System.out.println("Server says : " + serverResponse);
        }

        socket.close();
        System.exit(0);
    }
}
