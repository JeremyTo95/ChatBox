package back.server.full;

import front.model.Constants;
import front.model.Message;

public class ExecClient {
    public static void main(String[] args) {
        Client client = new Client();
        client.connect(Constants.IP_SERVER);
    }
}
