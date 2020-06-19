package back.server.full;

import front.model.Constants;
import front.model.Message;
import front.model.User;

public class ExecClient {
    public static void main(String[] args) {
        Client client = new Client();
        client.connect(Constants.IP_SERVER);

        User user = new User("Jérémy", "Tourari", "Sparta");
        User user2 = new User("Sofiane", "Serkesti", "JakenPon");
        Message message = new Message(user.getId(), "Hello (from Jérémy)");
        Message message2 = new Message(user2.getId(), "Hello (from Sofiane)");

//        client.sendMessage(message);
//        client.sendMessage(message2);
    }
}
