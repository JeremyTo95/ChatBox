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
        User user     = new User("Jeremy", "Tourari", "Sparat", "aaaa");
        Client client = new Client();
        client.connect(Constants.IP_SERVER);

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        while (client.isRunning()) {
//        while (true) {
            System.out.print("> ");
            String command = keyboard.readLine();
            if (command.equals("quit")) break;
            else if (command.equals(Constants.QUERY_DISCONNECT_SOCKET)) {
                System.out.println("Disconnecting...");
                client.disconnect();
                break;
            }
            else if (command.startsWith("send ")) {
                client.sendMessage(new Message(user.getId(), command.replace("send ", "")));
            }
        }

        System.out.println("after");
        System.exit(0);
    }
}
