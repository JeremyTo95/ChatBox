package back.server;

import front.model.Constants;
import front.model.server.FirstServer;

public class ServerConnection
{

	public static void main (String[] args) {
		AbstractServer as = new FirstServer();
		String ip = Constants.IP_SOCKET;
		as.connect(ip);
	}
}