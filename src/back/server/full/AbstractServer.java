package back.server.full;

import front.model.Message;

public abstract class AbstractServer {
    public abstract void connect(String ip);
    public abstract void sendMessage(Message message);
    public abstract Message getMessage();
}
