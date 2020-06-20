package back.server;

import front.model.Constants;
import front.model.Message;
import front.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>Object ExecClient</h1>
 * This class is a test to execute the client side
 */
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
                client.sendMessage(new Message(user.getId(), command.replace("send ", "")));
            }
        }
    }
}
