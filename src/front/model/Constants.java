package front.model;

import back.server.Client;
import back.server.Server;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    public static ChatRoom chatRoom;


    public static final List<User>     allUsers    = initAllUser();
    public static final List<UserRoom> allUserRoom = initAllUserRoom();

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


    public static List<UserRoom> initAllUserRoom() {
        List list = new ArrayList();

        list.add(new UserRoom(UUID.fromString("6952bd59-63e0-47ab-b0f1-034465b8efe8"), UUID.fromString("8d433b20-7a5c-4107-9777-ff15312b89fe")));
        list.add(new UserRoom(UUID.fromString("6952bd59-63e0-47ab-b0f1-034465b8efe8"), UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b165")));
        list.add(new UserRoom(UUID.fromString("6952bd59-63e0-47ab-b0f1-034465b8efe8"), UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b168")));
        list.add(new UserRoom(UUID.fromString("6952bd59-63e0-47ab-b0f1-034465b8efe8"), UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b169")));

        list.add(new UserRoom(UUID.fromString("21f1a963-c7eb-43d8-8321-d1da6aafa55f"), UUID.fromString("8d433b20-7a5c-4107-9777-ff15312b89fe")));
        list.add(new UserRoom(UUID.fromString("21f1a963-c7eb-43d8-8321-d1da6aafa55f"), UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b165")));
        list.add(new UserRoom(UUID.fromString("6952bd59-63e0-47ab-b0f1-034465b8efe8"), UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b168")));
        list.add(new UserRoom(UUID.fromString("6952bd59-63e0-47ab-b0f1-034465b8efe8"), UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b169")));

        list.add(new UserRoom(UUID.fromString("25a5c352-bccc-4315-83f9-0cf45559792e"), UUID.fromString("8d433b20-7a5c-4107-9777-ff15312b89fe")));
        list.add(new UserRoom(UUID.fromString("25a5c352-bccc-4315-83f9-0cf45559792e"), UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b165")));

        list.add(new UserRoom(UUID.fromString("0321c465-c766-4c8e-a5cc-46da731458f6"), UUID.fromString("8d433b20-7a5c-4107-9777-ff15312b89fe")));
        list.add(new UserRoom(UUID.fromString("0321c465-c766-4c8e-a5cc-46da731458f6"), UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b165")));

        list.add(new UserRoom(UUID.fromString("ad67ca53-d96e-4cb8-84aa-d5d3287e758c"), UUID.fromString("8d433b20-7a5c-4107-9777-ff15312b89fe")));
        list.add(new UserRoom(UUID.fromString("ad67ca53-d96e-4cb8-84aa-d5d3287e758c"), UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b165")));

        return list;
    }
}
