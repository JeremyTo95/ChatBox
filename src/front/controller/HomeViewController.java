package front.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import back.db.DataBaseManager;
import front.model.ChatRoom;
import front.model.Constants;
import front.model.Message;
import front.model.UserRoom;
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
		this.chatRoomList = UserRoom.getChatRoomByIdUser(view.getUser().getId()); //DataBaseManager.getAllChatRoom();
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
