<<<<<<< HEAD
import back.server.SimpleClient;
import front.controller.ChatRoomController;
import front.controller.LoginController;
=======
//import back.server.SimpleClient;
import front.controller.ChatRoomUI;
import front.controller.Login;
>>>>>>> 46b1c4e89f1b075d91a6b845273f51626af17475
import front.model.ChatRoom;
import front.model.Message;
import front.model.User;
import front.view.ChatRoomView;
import front.view.LoginView;

public class Main {
	public static void main(String[] args) {
		LoginView letsGo = new LoginView();
		letsGo.setView();
<<<<<<< HEAD
		
		/*
		SimpleClient sc = new SimpleClient();
		LoginController.initSocket(sc);
		ChatRoomController chatRoomUI = new ChatRoomController();
=======

//		SimpleClient sc = new SimpleClient();
//		Login.initSocket(sc);
		ChatRoomUI chatRoomUI = new ChatRoomUI();
>>>>>>> 46b1c4e89f1b075d91a6b845273f51626af17475
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
		*/
		ChatRoomView letsGo2 = new ChatRoomView();
		letsGo2.run();
	}
}
