package front.model;

import back.server.Client;

/**
 * <h1>Object Constants</h1>
 * This class have all the static value which are necessary in all project
 */
public class Constants {
    public static final String IP_SERVER = "localhost";
    public static final int PORT_SERVER  = 6666;
    public static final String QUERY_DISCONNECT_SOCKET = "disconnect";
    public static final int POPUP_WIDTH = 300;
    public static final int POPUP_HEIGHT = 400;
    public static final String QUERY_ADD_NEW_DISCUSSION = "Add new Discussion";
    public static User currentUser = null;
    public static Client client;
    public static ChatRoom chatRoom;
}
