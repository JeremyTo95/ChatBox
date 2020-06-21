package front.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import front.model.ChatRoom;
import front.model.Constants;
import front.model.Message;
import front.view.HomeView;

/**
 * <h1>Object HomeViewController</h1>
 * This class is the controller of the HomeView
 */
public class HomeViewController {
	private HomeView view;
	private List<ChatRoom> chatRoomList;

	/**
	 * This constructor initialises the basic informations of a HomeViewController
	 *
	 * @param view
	 */
	public HomeViewController(HomeView view) {
		this.view         = view;
		this.chatRoomList = initChatRoom();
	}

	/**
	 * This method initalize all chat room from the database
	 * @return a list of chat room
	 */
	public static List<ChatRoom> initChatRoom() {
		// TODO: Récupère les chatrooms correspondant à l'utilisateur depuis la bdd

		List<ChatRoom> list = new ArrayList<>();
		ChatRoom exemple = new ChatRoom(UUID.fromString("8d433b20-7a5c-4107-9777-ff15312b89fe"), "Les génies du logiciel", Constants.currentUser);
//		exemple.addMessage(new Message(Constants.currentUser.getId(), "Salut les potes"));
		list.add(exemple);
		list.add(new ChatRoom(UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b165"), "Discussion2",  Constants.allUsers.get(0)));
		list.add(new ChatRoom(UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b166"), "Discussion3",  Constants.allUsers.get(0)));
		list.add(new ChatRoom(UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b167"), "Discussion4",  Constants.allUsers.get(0)));
		list.add(new ChatRoom(UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b168"), "Discussion5",  Constants.allUsers.get(0)));
		list.add(new ChatRoom(UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b169"), "Discussion6",  Constants.allUsers.get(0)));
		list.add(new ChatRoom(UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b162"), "Discussion7",  Constants.allUsers.get(0)));
		list.add(new ChatRoom(UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b161"), "Discussion8",  Constants.allUsers.get(0)));
		list.add(new ChatRoom(UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b134"), "Discussion9",  Constants.allUsers.get(0)));
		list.add(new ChatRoom(UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b125"), "Discussion10", Constants.allUsers.get(0)));
		list.add(new ChatRoom(UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b115"), "Discussion11", Constants.allUsers.get(0)));
		list.add(new ChatRoom(UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b265"), "Discussion12", Constants.allUsers.get(0)));
		list.add(new ChatRoom(UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b365"), "Discussion13", Constants.allUsers.get(0)));
		list.add(new ChatRoom(UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b465"), "Discussion14", Constants.allUsers.get(0)));
		list.add(new ChatRoom(UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b565"), "Discussion15", Constants.allUsers.get(0)));
		list.add(new ChatRoom(UUID.fromString("9c4d7607-5bb5-42de-90ba-0757ecb7b565"), "Discussion16", Constants.allUsers.get(0)));
		list.add(new ChatRoom(UUID.fromString("9c4d7607-5bb5-42de-90ba-0737ecb7b565"), "Discussion17", Constants.allUsers.get(0)));
		list.add(new ChatRoom(UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b865"), "Discussion18", Constants.allUsers.get(0)));
		list.add(new ChatRoom(UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb7b965"), "Discussion19", Constants.allUsers.get(0)));
		list.add(new ChatRoom(UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb0b165"), "Discussion20", Constants.allUsers.get(0)));
		list.add(new ChatRoom(UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb6b165"), "Discussion21", Constants.allUsers.get(0)));
		list.add(new ChatRoom(UUID.fromString("9c4d7607-5bb5-42de-90ba-0797ecb5b165"), "Discussion22", Constants.allUsers.get(0)));

		return list;
	}

	/**
	 * This method print in the console the chat room informations
	 */
	private void printChatRoomList() {
		for (int i = 0; i < chatRoomList.size(); i++) {
			chatRoomList.get(i).printChatRoom();
		}
	}

	/**
	 * Getter of the chatRoomList
	 * @return a list of chat room
	 */
	public List<ChatRoom> getChatRoomList() {
		return chatRoomList;
	}
}
