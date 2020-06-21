package back.db;

import front.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


public class Connect {
    public static void sendUserToDB(User utilisateur) {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver O.K.");

            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String passwd = "root";

            Connection conn = DriverManager.getConnection(url, user, passwd);

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

    public static void sendMessageToDB(Message message) {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver O.K.");

            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String passwd = "root";

            Connection conn = DriverManager.getConnection(url, user, passwd);

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

    public static void sendChatRoomToDB(ChatRoom chatRoom) {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver O.K.");

            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String passwd = "root";

            Connection conn = DriverManager.getConnection(url, user, passwd);

            Statement state = conn.createStatement();

            PreparedStatement prepare = conn.prepareStatement("INSERT INTO chatroom(idchatroom, titleroom) VALUES(?,?)");
            prepare.setString(1, chatRoom.getIdChatRoom().toString());
            prepare.setString(2, chatRoom.getTitleRoom());
            prepare.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendUserRoomToDB(UserRoom userRoom) {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver O.K.");

            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String passwd = "root";

            Connection conn = DriverManager.getConnection(url, user, passwd);

            Statement state = conn.createStatement();

            PreparedStatement prepare = conn.prepareStatement("INSERT INTO user_room(id_author, id_chatroom) VALUES(?,?)");
            prepare.setString(1, userRoom.getIdAuthor().toString());
            prepare.setString(2, userRoom.getIdChatRoom().toString());
            prepare.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<User> getAllUsers() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String passwd = "root";

            Connection conn = DriverManager.getConnection(url, user, passwd);
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

    public static void main(String[] args) {
        sendUserRoomToDB(Constants.allUserRoom.get(0));
    }
}
