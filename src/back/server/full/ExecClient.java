package back.server.full;

import front.model.Constants;
import front.model.Message;
import front.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ExecClient {
    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.connect(Constants.IP_SERVER);

        User user = new User("Jérémy", "Tourari", "Sparta");
        User user2 = new User("Sofiane", "Serkesti", "JakenPon");
        Message message = new Message(user.getId(), "Hello (from Jérémy)");
        Message message2 = new Message(user2.getId(), "Hello (from Sofiane)");

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("> ");
            String command = keyboard.readLine();
            if (command.equals("quit")) break;
            if (command.startsWith("send ")) {
                client.sendMessage(Constants.IP_SERVER, new Message(user.getId(), command.replace("send ", "")));
            }
        }
    }
}
