package back.server.full;

import front.model.Constants;
import front.model.Message;
import front.model.User;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ExecClient {
    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.connect(Constants.IP_SERVER);

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        User user = new User("Jeremy", "Tourari", "Sparat", "aaaa");

        while (true) {
            System.out.print("> ");
            String command = keyboard.readLine();
            if (command.equals("quit")) break;
            if (command.startsWith("send ")) {
                client.sendMessage(Constants.IP_SERVER, new Message(user.getId()/*Constants.currentUser.getId()*/, command.replace("send ", "")));
            }
        }
    }
}
