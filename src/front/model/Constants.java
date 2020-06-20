package front.model;

import java.util.ArrayList;
import java.util.List;

public class Constants {
    public static final String IP_SERVER = "localhost";
    public static final int PORT_SERVER  = 6666;
    public static final int MAX_PEOPLE   = 4;
    public static final String QUERY_GET_MESSAGES = "Send me messages";
//    public static final String QUERY_SEND_MESSAGE = "Send message";
    public static User currentUser = null;


    public static final List<User> allUsers = initAllUser();
    public static List<User>initAllUser() {
        List userList = new ArrayList();

        userList.add(new User("Jérémy", "Tourari", "Sparta", "password"));
        userList.add(new User("Sofiane", "Serkesti", "JakenPon", "password"));
        userList.add(new User("Mostafa", "Omrane", "vegaPunk", "password"));
        userList.add(new User("Yoann", "Anago", "Gims", "password"));
        userList.add(new User("Raphaël", "KOSKA", "L'étranger de la 34 ou 33", "password"));

        return userList;
    }
}
