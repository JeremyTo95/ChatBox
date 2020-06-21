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
        /*
         * // SimpleClient sc = new SimpleClient(); // Login.initSocket(sc);
         * ChatRoomController chatRoomUI = new ChatRoomController(); User user = new
         * User("Jérémy", "Tourari", "Sparta"); User user2 = new User("Sofiane",
         * "Serkesti", "JakenPon"); ChatRoom chatRoom = new
         * ChatRoom("ChatRoom first test", user); chatRoom.addUser(user2);
         * chatRoom.addMessage(new Message(user.getId(), "Yo Sof"));
         * chatRoomUI.initNewChatRoom(chatRoom); chatRoomUI.printChatRoomList();
         *
         * chatRoomUI.getChatRoomList().get(0).removeUser(user);
         * chatRoomUI.getChatRoomList().get(0).removeUser(user2);
         * chatRoomUI.printChatRoomList();
         */
    }
}