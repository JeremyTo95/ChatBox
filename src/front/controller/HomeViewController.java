package front.controller;

import java.util.ArrayList;
import java.util.List;

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
	private List<ChatRoom> initChatRoom() {
		// TODO: Récupère les chatrooms correspondant à l'utilisateur depuis la bdd

		List<ChatRoom> list = new ArrayList<>();
		ChatRoom exemple = new ChatRoom("localhost", "Les génies du logiciel", Constants.currentUser);
		exemple.addMessage(new Message(Constants.currentUser.getId(), "Salut les potes"));
		list.add(exemple);
		list.add(new ChatRoom("127.0.0.1",  "Discussion2",  view.getUser()));
		list.add(new ChatRoom("127.0.0.2",  "Discussion3",  view.getUser()));
		list.add(new ChatRoom("127.0.0.3",  "Discussion4",  view.getUser()));
		list.add(new ChatRoom("127.0.0.4",  "Discussion5",  view.getUser()));
		list.add(new ChatRoom("127.0.0.5",  "Discussion6",  view.getUser()));
		list.add(new ChatRoom("127.0.0.6",  "Discussion7",  view.getUser()));
		list.add(new ChatRoom("127.0.0.7",  "Discussion8",  view.getUser()));
		list.add(new ChatRoom("127.0.0.8",  "Discussion9",  view.getUser()));
		list.add(new ChatRoom("127.0.0.9",  "Discussion10", view.getUser()));
		list.add(new ChatRoom("127.0.0.10", "Discussion11", view.getUser()));
		list.add(new ChatRoom("127.0.0.11", "Discussion12", view.getUser()));
		list.add(new ChatRoom("127.0.0.12", "Discussion13", view.getUser()));
		list.add(new ChatRoom("127.0.0.13", "Discussion14", view.getUser()));
		list.add(new ChatRoom("127.0.0.14", "Discussion15", view.getUser()));
		list.add(new ChatRoom("127.0.0.15", "Discussion16", view.getUser()));
		list.add(new ChatRoom("127.0.0.16", "Discussion17", view.getUser()));
		list.add(new ChatRoom("127.0.0.17", "Discussion18", view.getUser()));
		list.add(new ChatRoom("127.0.0.18", "Discussion19", view.getUser()));
		list.add(new ChatRoom("127.0.0.19", "Discussion20", view.getUser()));
		list.add(new ChatRoom("127.0.0.20", "Discussion21", view.getUser()));
		list.add(new ChatRoom("127.0.0.21", "Discussion22", view.getUser()));

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
