package front.controller;

import front.model.ChatRoom;

import java.util.ArrayList;
import java.util.List;

public class ChatRoomUI {
    private List<ChatRoom> chatRoomList;

    public ChatRoomUI() {
        chatRoomList = new ArrayList<>();
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
