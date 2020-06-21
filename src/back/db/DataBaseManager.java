package back.db;

import front.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * <h1>Object DataBaseManager</h1>
 * This class is for the database management
 */
public class DataBaseManager {
    public static String url = "jdbc:postgresql://localhost:5432/postgres";
    public static String user = "postgres";
    public static String passwd = "root";
    public static Connection conn;

    /**
     * Constructor of the class
     */
    public DataBaseManager() {
        try {
            conn = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * This method enable to get the singleton
     * @return
     */
    public static Connection getInstance() {
        if (conn == null) new DataBaseManager();
        return conn;
    }


    /**
     * Enable to send a user in the DB
     * @param utilisateur
     */
    public static void sendUserToDB(User utilisateur) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = getInstance();

            Statement state = conn.createStatement();

            PreparedStatement prepare = conn.prepareStatement("INSERT INTO users(id, firstName, lastName, pseudo, password) VALUES(?,?,?,?,?)");
            prepare.setString(1, utilisateur.getId().toString());
            prepare.setString(2, utilisateur.getFirstName());
            prepare.setString(3, utilisateur.getLastName());
            prepare.setString(4, utilisateur.getPseudo());
            prepare.setString(5, utilisateur.getPassword());
            prepare.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Enable to send a message in the DB
     * @param message
     */
    public static void sendMessageToDB(Message message) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = getInstance();

            Statement state = conn.createStatement();

            PreparedStatement prepare = conn.prepareStatement("INSERT INTO messages(idmessage, idauthor, idchatroom, content, message_date) VALUES(?,?,?,?,?)");
            prepare.setString(1, message.getIdMessage().toString());
            prepare.setString(2, message.getIdAuthor().toString());
            prepare.setString(3, message.getIdChatRoom().toString());
            prepare.setString(4, message.getContent());
            prepare.setString(5, message.getDate().toString());
            prepare.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Enable to send a chatroom in the DB
     * @param chatRoom
     */
    public static void sendChatRoomToDB(ChatRoom chatRoom) {
        try {
            Class.forName("org.postgresql.Driver");

            Connection conn = getInstance();

            Statement state = conn.createStatement();

            PreparedStatement prepare = conn.prepareStatement("INSERT INTO chatroom(idchatroom, titleroom) VALUES(?,?)");
            prepare.setString(1, chatRoom.getIdChatRoom().toString());
            prepare.setString(2, chatRoom.getTitleRoom());
            prepare.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Enable to send a user_room in the DB
     * @param userRoom
     */
    public static void sendUserRoomToDB(UserRoom userRoom) {
        try {
            Class.forName("org.postgresql.Driver");

            Connection conn = getInstance();

            Statement state = conn.createStatement();

            PreparedStatement prepare = conn.prepareStatement("INSERT INTO user_room(id_author, id_chatroom) VALUES(?,?)");
            prepare.setString(1, userRoom.getIdAuthor().toString());
            prepare.setString(2, userRoom.getIdChatRoom().toString());
            prepare.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Enable to get a user in the DB
     * @return
     */
    public static List<User> getAllUsers() {
        try {
            Class.forName("org.postgresql.Driver");

            Connection conn = getInstance();

            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT * FROM Users");

            List<User> userList = new ArrayList();
            String lastname, firstname, pseudo, id, password;

            while(result.next()){
                id = result.getObject(1).toString();
                lastname = result.getObject(2).toString();
                firstname = result.getObject(3).toString();
                pseudo = result.getObject(4).toString();
                password = result.getObject(5).toString();
                userList.add(new User(id, firstname, lastname, pseudo, password));
            }

            result.close();
            state.close();

            return userList;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Enable to get a message in the DB
     * @return
     */
    public static List<Message> getAllMessage() {
        try {
            Class.forName("org.postgresql.Driver");

            Connection conn = getInstance();
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT * FROM messages");

            List<Message> messageList = new ArrayList();
            String idMessage, idAuthor, idChatRoom, content, date;

            while(result.next()){
                idMessage = result.getObject(1).toString();
                idAuthor = result.getObject(2).toString();
                idChatRoom = result.getObject(3).toString();
                content = result.getObject(4).toString();
                date = result.getObject(5).toString();
                messageList.add(new Message(UUID.fromString(idMessage), UUID.fromString(idAuthor), UUID.fromString(idChatRoom), content, date));
            }

            result.close();
            state.close();

            return messageList;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Enable to get a chatroom in the DB
     * @return
     */
    public static List<ChatRoom> getAllChatRoom() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = getInstance();
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT * FROM chatroom");

            List<ChatRoom> chatRoomList = new ArrayList();
            String idChatRoom, title;

            while(result.next()){
                idChatRoom = result.getObject(1).toString();
                title = result.getObject(2).toString();
                chatRoomList.add(new ChatRoom(UUID.fromString(idChatRoom), title));
            }

            result.close();
            state.close();

            return chatRoomList;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Enable to get a user room in the DB
     * @return
     */
    public static List<UserRoom> getAllUserRoom() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = getInstance();
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT * FROM user_room");

            List<UserRoom> chatRoomList = new ArrayList();
            String idAuthor, idChatRoom;

            while(result.next()){
                idAuthor = result.getObject(1).toString();
                idChatRoom = result.getObject(2).toString();
                chatRoomList.add(new UserRoom(UUID.fromString(idAuthor), UUID.fromString(idChatRoom)));
            }

            result.close();
            state.close();

            return chatRoomList;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Enable to delete a user in the DB
     */
    public static void dropUsers() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = getInstance();
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("DELETE FROM Users");

            result.close();
            state.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Enable to delete a chatroom in the DB
     */
    public static void dropChatRooms() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = getInstance();
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("DELETE FROM chatroom");

            result.close();
            state.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Enable to delete a message in the DB
     */
    public static void dropMessages() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = getInstance();
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("DELETE FROM messages");

            result.close();
            state.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Enable to delete a user room in the DB
     */
    public static void dropUserRoom() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = getInstance();
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("DELETE FROM user_room");

            result.close();
            state.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method enable to prepulate the table with the basic data for example
     */
    public static void prepopulateTable() {
        List<User> allUser = getAllUsers();
        List<ChatRoom> allChatRoom = getAllChatRoom();
        List<UserRoom> allUserRoom = getAllUserRoom();
        List<Message> allMessage   = getAllMessage();

        if (allUser.size() < 5) {
            dropUsers();
            sendUserToDB(new User("6952bd59-63e0-47ab-b0f1-034465b8efe8", "Jérémy", "Tourari", "Sparta", "password"));
            sendUserToDB(new User("21f1a963-c7eb-43d8-8321-d1da6aafa55f", "Sofiane", "Serkesti", "JakenPon", "password"));
            sendUserToDB(new User("25a5c352-bccc-4315-83f9-0cf45559792e", "Mostafa", "Omrane", "vegaPunk", "password"));
            sendUserToDB(new User("0321c465-c766-4c8e-a5cc-46da731458f6", "Yoann", "Anago", "Gims", "password"));
            sendUserToDB(new User("ad67ca53-d96e-4cb8-84aa-d5d3287e758c", "Raphaël", "KOSKAS", "RaphyStark", "password"));
        }

        if (allChatRoom.size() < 10) {
            dropChatRooms();
            sendChatRoomToDB(new ChatRoom(UUID.fromString("8d433b20-7a5c-4107-9777-ff15312b89fe"), "Les génies du logiciel"));
            sendChatRoomToDB(new ChatRoom(UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b165"), "Discussion2"));
            sendChatRoomToDB(new ChatRoom(UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b166"), "Discussion3"));
            sendChatRoomToDB(new ChatRoom(UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b167"), "Discussion4"));
            sendChatRoomToDB(new ChatRoom(UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b168"), "Discussion5"));
            sendChatRoomToDB(new ChatRoom(UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b169"), "Discussion6"));
            sendChatRoomToDB(new ChatRoom(UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b162"), "Discussion7"));
            sendChatRoomToDB(new ChatRoom(UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b161"), "Discussion8"));
            sendChatRoomToDB(new ChatRoom(UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b134"), "Discussion9"));
            sendChatRoomToDB(new ChatRoom(UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b125"), "Discussion10"));
        }

        if (allUserRoom.size() < 5) {
            dropUserRoom();
            sendUserRoomToDB(new UserRoom(UUID.fromString("6952bd59-63e0-47ab-b0f1-034465b8efe8"), UUID.fromString("8d433b20-7a5c-4107-9777-ff15312b89fe")));
            sendUserRoomToDB(new UserRoom(UUID.fromString("6952bd59-63e0-47ab-b0f1-034465b8efe8"), UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b165")));
            sendUserRoomToDB(new UserRoom(UUID.fromString("6952bd59-63e0-47ab-b0f1-034465b8efe8"), UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b168")));
            sendUserRoomToDB(new UserRoom(UUID.fromString("6952bd59-63e0-47ab-b0f1-034465b8efe8"), UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b169")));

            sendUserRoomToDB(new UserRoom(UUID.fromString("21f1a963-c7eb-43d8-8321-d1da6aafa55f"), UUID.fromString("8d433b20-7a5c-4107-9777-ff15312b89fe")));
            sendUserRoomToDB(new UserRoom(UUID.fromString("21f1a963-c7eb-43d8-8321-d1da6aafa55f"), UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b165")));
            sendUserRoomToDB(new UserRoom(UUID.fromString("21f1a963-c7eb-43d8-8321-d1da6aafa55f"), UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b168")));
            sendUserRoomToDB(new UserRoom(UUID.fromString("21f1a963-c7eb-43d8-8321-d1da6aafa55f"), UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b169")));

            sendUserRoomToDB(new UserRoom(UUID.fromString("25a5c352-bccc-4315-83f9-0cf45559792e"), UUID.fromString("8d433b20-7a5c-4107-9777-ff15312b89fe")));
            sendUserRoomToDB(new UserRoom(UUID.fromString("25a5c352-bccc-4315-83f9-0cf45559792e"), UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b165")));

            sendUserRoomToDB(new UserRoom(UUID.fromString("0321c465-c766-4c8e-a5cc-46da731458f6"), UUID.fromString("8d433b20-7a5c-4107-9777-ff15312b89fe")));
            sendUserRoomToDB(new UserRoom(UUID.fromString("0321c465-c766-4c8e-a5cc-46da731458f6"), UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b165")));

            sendUserRoomToDB(new UserRoom(UUID.fromString("ad67ca53-d96e-4cb8-84aa-d5d3287e758c"), UUID.fromString("8d433b20-7a5c-4107-9777-ff15312b89fe")));
            sendUserRoomToDB(new UserRoom(UUID.fromString("ad67ca53-d96e-4cb8-84aa-d5d3287e758c"), UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b165")));
        }

        if (allMessage.size() < 5) {
            dropMessages();
            sendMessageToDB(new Message(UUID.fromString("7b162ccd-3b51-4dfb-9b5f-6c0a79a54e97"), UUID.fromString("6952bd59-63e0-47ab-b0f1-034465b8efe8"), UUID.fromString("8d433b20-7a5c-4107-9777-ff15312b89fe"), "Message1", "2020-06-21T10:20:20.382116400"));
            sendMessageToDB(new Message(UUID.fromString("c8962346-a195-487b-b36a-5e4377bd1629"), UUID.fromString("6952bd59-63e0-47ab-b0f1-034465b8efe8"), UUID.fromString("8d433b20-7a5c-4107-9777-ff15312b89fe"), "Message2", "2020-06-21T10:20:20.382116400"));
            sendMessageToDB(new Message(UUID.fromString("e60473e0-f81f-4c2d-803d-1bb9f79c5f78"), UUID.fromString("6952bd59-63e0-47ab-b0f1-034465b8efe8"), UUID.fromString("8d433b20-7a5c-4107-9777-ff15312b89fe"), "Message3", "2020-06-21T10:20:20.382116400"));
            sendMessageToDB(new Message(UUID.fromString("26cc714d-a507-42cb-bfdf-a9f7c69c3b26"), UUID.fromString("21f1a963-c7eb-43d8-8321-d1da6aafa55f"), UUID.fromString("8d433b20-7a5c-4107-9777-ff15312b89fe"), "Message1", "2020-06-21T10:20:20.382116400"));

        }
    }
}
