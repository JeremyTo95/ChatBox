package back.server.full;

import front.model.Constants;

public class ExecServer {
    public static void main(String[] args) {
        Server server = new Server();
        server.connect(Constants.IP_SERVER);
    }
}
