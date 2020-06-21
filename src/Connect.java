import front.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


public class Connect
{
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/ChatBox";
            String user = "postgres";
            String passwd = "He9Z4EmJu2640&";

            Connection conn = DriverManager.getConnection(url, user, passwd);
            Statement state = conn.createStatement();
            UUID idUser;
            idUser = UUID.randomUUID();
            ResultSet result = state.executeQuery("SELECT * FROM Users");
            ResultSetMetaData resultMeta = result.getMetaData();

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


            System.out.println(Arrays.toString(userList.toArray()));

            //TODO: récupérer / extraire userList (= list de tous les user)
            //TODO: écrire les fonctions en JAVA pour avoir les info en fonction de paramètre

            result.close();
            state.close();
            /**/
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}