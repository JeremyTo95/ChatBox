import java.sql.*;


public class Connect
{

    /**
     *
     * @param args
     */

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/ChatBox";
            String user = "postgres";
            String passwd = "He9Z4EmJu2640&";

            Connection conn = DriverManager.getConnection(url, user, passwd);

            //Création d'un objet Statement
            Statement state = conn.createStatement();

            //L'objet ResultSet contient le résultat de la requête SQL
            ResultSet result = state.executeQuery("SELECT * FROM Users");

            //On récupère les MetaData
            ResultSetMetaData resultMeta = result.getMetaData();

            System.out.println("\n**********************************");
            //On affiche le nom des colonnes
            for(int i = 1; i <= resultMeta.getColumnCount(); i++)
                System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");

            System.out.println("\n**********************************");

            while(result.next())
            {
                for(int i = 1; i <= resultMeta.getColumnCount(); i++)
                System.out.print("\t" + result.getObject(i).toString() + "\t |");
                System.out.println("\n---------------------------------");
            }

           //String strSQL =
           //state.executeUpdate( strSQL );
            result.close();
            state.close();
            /**/
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}