package front.model;

import back.server.Client;
import back.server.Server;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Object Constants</h1>
 * This class have all the static value which are necessary in all project
 */
public class Constants {
    public static final String IP_SERVER = "localhost";
    public static final int PORT_SERVER  = 6666;
    public static final int MAX_PEOPLE   = 4;
    public static final String QUERY_GET_MESSAGES = "Send me messages";
    public static final String QUERY_DISCONNECT_SOCKET = "disconnect";
    public static User currentUser = null;
    public static Client client;


    public static final List<User> allUsers = initAllUser();

    /**
     * This methode initialize all the user
     * @return
     */
    public static List<User>initAllUser() {
        List userList = new ArrayList();

        userList.add(new User("6952bd59-63e0-47ab-b0f1-034465b8efe8", "Jérémy", "Tourari", "Sparta", "password"));
        userList.add(new User("21f1a963-c7eb-43d8-8321-d1da6aafa55f", "Sofiane", "Serkesti", "JakenPon", "password"));
        userList.add(new User("25a5c352-bccc-4315-83f9-0cf45559792e", "Mostafa", "Omrane", "vegaPunk", "password"));
        userList.add(new User("0321c465-c766-4c8e-a5cc-46da731458f6", "Yoann", "Anago", "Gims", "password"));
        userList.add(new User("ad67ca53-d96e-4cb8-84aa-d5d3287e758c", "Raphaël", "KOSKAS", "RaphyStark", "password"));

        return userList;
    }
}
