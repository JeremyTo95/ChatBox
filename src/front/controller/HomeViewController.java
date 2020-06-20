package front.controller;

import java.util.ArrayList;
import java.util.List;

import front.model.ChatRoom;
import front.model.Constants;
import front.model.Message;
import front.view.HomeView;

public class HomeViewController {
	private HomeView view;
	private List<ChatRoom> chatRoomList;

	public HomeViewController(HomeView view) {
		this.view         = view;
		this.chatRoomList = initChatRoom();
	}

	private List<ChatRoom> initChatRoom() {
		// TODO: Récupère les chatrooms correspondant à l'utilisateur depuis la bdd

		List<ChatRoom> list = new ArrayList<>();
		ChatRoom exemple = new ChatRoom("Les génies du logiciel", Constants.currentUser);
		exemple.addMessage(new Message(Constants.currentUser.getId(), "Salut les potes"));
		list.add(exemple);
		list.add(new ChatRoom("Discussion2",  view.getUser()));
		list.add(new ChatRoom("Discussion3",  view.getUser()));
		list.add(new ChatRoom("Discussion4",  view.getUser()));
		list.add(new ChatRoom("Discussion5",  view.getUser()));
		list.add(new ChatRoom("Discussion6",  view.getUser()));
		list.add(new ChatRoom("Discussion7",  view.getUser()));
		list.add(new ChatRoom("Discussion8",  view.getUser()));
		list.add(new ChatRoom("Discussion9",  view.getUser()));
		list.add(new ChatRoom("Discussion10", view.getUser()));
		list.add(new ChatRoom("Discussion11", view.getUser()));
		list.add(new ChatRoom("Discussion11", view.getUser()));
		list.add(new ChatRoom("Discussion11", view.getUser()));
		list.add(new ChatRoom("Discussion11", view.getUser()));
		list.add(new ChatRoom("Discussion11", view.getUser()));
		list.add(new ChatRoom("Discussion11", view.getUser()));
		list.add(new ChatRoom("Discussion11", view.getUser()));
		list.add(new ChatRoom("Discussion11", view.getUser()));
		list.add(new ChatRoom("Discussion11", view.getUser()));
		list.add(new ChatRoom("Discussion11", view.getUser()));
		list.add(new ChatRoom("Discussion11", view.getUser()));
		list.add(new ChatRoom("Discussion11", view.getUser()));

		return list;
	}

	private void printChatRoomList() {
		for (int i = 0; i < chatRoomList.size(); i++) {
			chatRoomList.get(i).printChatRoom();
		}
	}

	public List<ChatRoom> getChatRoomList() {
		return chatRoomList;
	}
}
