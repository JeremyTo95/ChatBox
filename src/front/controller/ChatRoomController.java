package front.controller;

import java.util.ArrayList;
import java.util.List;

import front.model.ChatRoom;
import front.model.Message;
import front.model.User;

public class ChatRoomController {
	public List<ChatRoom> chatRoomList;

	public ChatRoomController() {
		chatRoomList = new ArrayList<>();
		User moi = new User("Mostafa", "Omrane", "Vegapunk");
		ChatRoom exemple = new ChatRoom("Les génies du logiciel", moi);
		exemple.addMessage(new Message(moi.getId(), "Salut les potes"));
		chatRoomList.add(exemple);
		chatRoomList.add(new ChatRoom("Discussion2", new User("Mostafa", "Omrane", "Vegapunk")));
		chatRoomList.add(new ChatRoom("Discussion3", new User("Mostafa", "Omrane", "Vegapunk")));
		chatRoomList.add(new ChatRoom("Discussion4", new User("Mostafa", "Omrane", "Vegapunk")));
		chatRoomList.add(new ChatRoom("Discussion5", new User("Mostafa", "Omrane", "Vegapunk")));
		chatRoomList.add(new ChatRoom("Discussion6", new User("Mostafa", "Omrane", "Vegapunk")));
		chatRoomList.add(new ChatRoom("Discussion7", new User("Mostafa", "Omrane", "Vegapunk")));
		chatRoomList.add(new ChatRoom("Discussion8", new User("Mostafa", "Omrane", "Vegapunk")));
		chatRoomList.add(new ChatRoom("Discussion9", new User("Mostafa", "Omrane", "Vegapunk")));
		chatRoomList.add(new ChatRoom("Discussion10", new User("Mostafa", "Omrane", "Vegapunk")));
		chatRoomList.add(new ChatRoom("Discussion11", new User("Mostafa", "Omrane", "Vegapunk")));
		chatRoomList.add(new ChatRoom("Discussion11", new User("Mostafa", "Omrane", "Vegapunk")));
		chatRoomList.add(new ChatRoom("Discussion11", new User("Mostafa", "Omrane", "Vegapunk")));
		chatRoomList.add(new ChatRoom("Discussion11", new User("Mostafa", "Omrane", "Vegapunk")));
		chatRoomList.add(new ChatRoom("Discussion11", new User("Mostafa", "Omrane", "Vegapunk")));
		chatRoomList.add(new ChatRoom("Discussion11", new User("Mostafa", "Omrane", "Vegapunk")));
		chatRoomList.add(new ChatRoom("Discussion11", new User("Mostafa", "Omrane", "Vegapunk")));
		chatRoomList.add(new ChatRoom("Discussion11", new User("Mostafa", "Omrane", "Vegapunk")));
		chatRoomList.add(new ChatRoom("Discussion11", new User("Mostafa", "Omrane", "Vegapunk")));
		chatRoomList.add(new ChatRoom("Discussion11", new User("Mostafa", "Omrane", "Vegapunk")));
		chatRoomList.add(new ChatRoom("Discussion11", new User("Mostafa", "Omrane", "Vegapunk")));
		chatRoomList.add(new ChatRoom("Discussion11", new User("Mostafa", "Omrane", "Vegapunk")));
	}

	public void initNewChatRoom(ChatRoom chatRoom) {
		this.chatRoomList.add(chatRoom);
	}

	public void printChatRoomList() {
		for (int i = 0; i < chatRoomList.size(); i++) {
			chatRoomList.get(i).printChatRoom();
		}
	}

	public List<ChatRoom> getChatRoomList() {
		return chatRoomList;
	}
}
