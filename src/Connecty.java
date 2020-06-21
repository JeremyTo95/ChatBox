

import front.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static front.model.Constants.chatRoom;
import static front.model.Constants.initAllUser;

//CTRL + SHIFT + O pour générer les imports
public class Connecty {
    /**
     *
     * @param utilisateur
     */
    public static void entrer_user(User utilisateur) {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver O.K.");

            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user_dbb = "postgres";
            String passwd_dbb = "root";

            Connection conn = DriverManager.getConnection(url, user_dbb, passwd_dbb);

            PreparedStatement prepare = conn.prepareStatement("INSERT INTO users(id, firstName, lastName, pseudo, password) VALUES(?,?,?,?,?)");
            prepare.setString(1, utilisateur.getId().toString());
            prepare.setString(2, utilisateur.getLastName());
            prepare.setString(3, utilisateur.getFirstName());
            prepare.setString(4, utilisateur.getPseudo());
            prepare.setString(5, utilisateur.getPassword());
            prepare.executeUpdate();

            /*
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT * FROM users");
            ResultSetMetaData resultMeta = result.getMetaData();

            System.out.println("\n**********************************");
            //On affiche le nom des colonnes
            for(int i = 1; i <= resultMeta.getColumnCount(); i++)
                System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");

            System.out.println("\n**********************************");

            while(result.next()){
                for(int i = 1; i <= resultMeta.getColumnCount(); i++)
                    System.out.print("\t" + result.getObject(i).toString() + "\t |");

                System.out.println("\n---------------------------------");
            }
            result.close();
            state.close();*/
            prepare.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param message
     */
    public static void entrer_message(Message message) {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver O.K.");

            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user_dbb = "postgres";
            String passwd_dbb = "root";

            Connection conn = DriverManager.getConnection(url, user_dbb, passwd_dbb);

            PreparedStatement prepare = conn.prepareStatement("INSERT INTO Messages(idMessage, idAuthor, idChatRoom, content, message_date) VALUES(?,?,?,?,?)");
            prepare.setString(1, message.getIdMessage().toString());
            prepare.setString(2, message.getIdAuthor().toString());
            prepare.setString(3, message.getIdChatRoom().toString());
            prepare.setString(4, message.getContent());
            prepare.setString(5, message.getDate().toString());
            prepare.executeUpdate();

            /*
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT * FROM messages");
            ResultSetMetaData resultMeta = result.getMetaData();

            System.out.println("\n**********************************");
            //On affiche le nom des colonnes
            for(int i = 1; i <= resultMeta.getColumnCount(); i++)
                System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");

            System.out.println("\n**********************************");

            while(result.next()){
                for(int i = 1; i <= resultMeta.getColumnCount(); i++)
                    System.out.print("\t" + result.getObject(i).toString() + "\t |");

                System.out.println("\n---------------------------------");
            }
            result.close();
            state.close();*/
            prepare.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param chatroom
     */
    public static void entrer_chatroom(ChatRoom chatroom) {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver O.K.");

            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user_dbb = "postgres";
            String passwd_dbb = "root";

            Connection conn = DriverManager.getConnection(url, user_dbb, passwd_dbb);

            PreparedStatement prepare = conn.prepareStatement("INSERT INTO Chatrooms(idChatroom, titleRoom) VALUES(?,?)");
            prepare.setString(1, chatroom.getIdChatRoom().toString());
            prepare.setString(2, chatroom.getTitleRoom());
            prepare.executeUpdate();

            /*
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT * FROM Chatrooms");
            ResultSetMetaData resultMeta = result.getMetaData();

            System.out.println("\n**********************************");
            //On affiche le nom des colonnes
            for(int i = 1; i <= resultMeta.getColumnCount(); i++)
                System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");

            System.out.println("\n**********************************");

            while(result.next()){
                for(int i = 1; i <= resultMeta.getColumnCount(); i++)
                    System.out.print("\t" + result.getObject(i).toString() + "\t |");

                System.out.println("\n---------------------------------");
            }
            result.close();
            state.close();*/
            prepare.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param useroom
     */
    public static void entrer_UserRoom(UserRoom useroom) {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver O.K.");

            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user_dbb = "postgres";
            String passwd_dbb = "root";

            Connection conn = DriverManager.getConnection(url, user_dbb, passwd_dbb);

            PreparedStatement prepare = conn.prepareStatement("INSERT INTO User_Room(id_Author, id_Chatroom) VALUES(?,?)");
            prepare.setString(1, useroom.getIdAuthor().toString());
            prepare.setString(2, useroom.getIdChatRoom().toString());
            prepare.executeUpdate();

            /*
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT * FROM Chatrooms");
            ResultSetMetaData resultMeta = result.getMetaData();

            System.out.println("\n**********************************");
            //On affiche le nom des colonnes
            for(int i = 1; i <= resultMeta.getColumnCount(); i++)
                System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");

            System.out.println("\n**********************************");

            while(result.next()){
                for(int i = 1; i <= resultMeta.getColumnCount(); i++)
                    System.out.print("\t" + result.getObject(i).toString() + "\t |");

                System.out.println("\n---------------------------------");
            }
            result.close();
            state.close();*/
            prepare.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param args
     */
    /*public static void main(String[] args) {
        //User user = new User("6952bd59-63e0-47ab-b0f1-034465b8efe8", "Jérémy", "Tourari", "Sparta", "password");
        //entrer_user(user);

        //Message message = new Message(UUID.fromString("7b162ccd-3b51-4dfb-9b5f-6c0a79a54e97"), UUID.fromString("6952bd59-63e0-47ab-b0f1-034465b8efe8"), UUID.fromString("8d433b20-7a5c-4107-9777-ff15312b89fe"), "Message1", "2020-06-21T10:20:20.382116400");
        //entrer_message(message);

        //ChatRoom chatroom = new ChatRoom(UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b165"), "Discussion2");
        //entrer_chatroom(chatroom);

        //UserRoom useroom = (new UserRoom(UUID.fromString("6952bd59-63e0-47ab-b0f1-034465b8efe8"), UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b165")));
        //entrer_UserRoom(useroom);

    }*/
}