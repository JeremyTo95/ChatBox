import back.db.DataBaseManager;
import front.view.LoginView;

import javax.xml.crypto.Data;

/**
 * <h1>Main</h1>
 * This class is the executor of the project
 */
public class Main {
    public static void main(String[] args) {
//        DataBaseManager.dropUsers();
//        DataBaseManager.dropChatRooms();
//        DataBaseManager.dropMessages();
//        DataBaseManager.dropUserRoom();

        DataBaseManager.prepopulateTable();

        LoginView letsGo = new LoginView();
        letsGo.setView();
    }
}