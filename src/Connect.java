

import front.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static front.model.Constants.initAllUser;

//CTRL + SHIFT + O pour générer les imports
public class Connect {
    public static void entrer_user(User utilisateur) {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver O.K.");

            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String passwd = "root";

            Connection conn = DriverManager.getConnection(url, user, passwd);

            Statement state = conn.createStatement();
            //Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

            PreparedStatement prepare = conn.prepareStatement("INSERT INTO users(id, firstName, lastName, pseudo, password) VALUES(?,?,?,?,?)");
            prepare.setString(1, utilisateur.getId().toString());
            prepare.setString(2, utilisateur.getFirstName());
            prepare.setString(3, utilisateur.getLastName());
            prepare.setString(4, utilisateur.getPseudo());
            prepare.setString(5, utilisateur.getPassword());
            prepare.executeUpdate();

            /*ResultSet result = state.executeQuery("SELECT * FROM users");
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
            prepare.close();
            //result.close();
            state.close();*/

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        User user = new User("Jérémy", "Tourari", "Sparta", "password");

        entrer_user(user);
    }
}