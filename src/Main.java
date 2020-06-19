//import back.server.SimpleClient;
import front.controller.ChatRoomUI;
import front.controller.Login;
import front.model.ChatRoom;
import front.model.Message;
import front.model.User;
import front.view.LoginPage;

public class Main {
	public static void main(String[] args) {
		LoginPage letsGo = new LoginPage();
		letsGo.setView();

//		SimpleClient sc = new SimpleClient();
//		Login.initSocket(sc);
		ChatRoomUI chatRoomUI = new ChatRoomUI();
		User user = new User("Jérémy", "Tourari", "Sparta");
		User user2 = new User("Sofiane", "Serkesti", "JakenPon");
		ChatRoom chatRoom = new ChatRoom("ChatRoom first test", user);
		chatRoom.addUser(user2);
		chatRoom.addMessage(new Message(user.getId(), "Yo Sof"));
		chatRoomUI.initNewChatRoom(chatRoom);
		chatRoomUI.printChatRoomList();

		chatRoomUI.getChatRoomList().get(0).removeUser(user);
		chatRoomUI.getChatRoomList().get(0).removeUser(user2);
		chatRoomUI.printChatRoomList();
	}
}
