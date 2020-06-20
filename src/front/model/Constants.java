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
    public static User currentUser = null;
    public static Client client = new Client();
    public static Server server = new Server();


    public static final List<User> allUsers = initAllUser();

    /**
     * This methode initialize all the user
     * @return
     */
    public static List<User>initAllUser() {
        List userList = new ArrayList();

        userList.add(new User("Jérémy", "Tourari", "Sparta", "password"));
        userList.add(new User("Sofiane", "Serkesti", "JakenPon", "password"));
        userList.add(new User("Mostafa", "Omrane", "vegaPunk", "password"));
        userList.add(new User("Yoann", "Anago", "Gims", "password"));
        userList.add(new User("Raphaël", "KOSKAS", "RaphyStark", "password"));

        return userList;
    }
}
