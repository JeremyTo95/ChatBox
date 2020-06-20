package front.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class ChatRoom implements Serializable {
    UUID idChatRoom;
    String titleRoom;
    User userConnected;
    List<User> userList;
    List<Message> messageList;

    public ChatRoom(String titleRoom, User admin) {
        this.userList = new ArrayList<>();
        this.messageList = new ArrayList<>();

        this.idChatRoom = UUID.randomUUID();
        this.titleRoom = titleRoom;
        this.userList.add(admin);
        this.messageList = new ArrayList<>();
    }

    public void addUser(User user) {
        userList.add(user);
        System.out.println("new user added");
    }

    public void removeUser(User user) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId().toString().equals(user.getId().toString()) && i != 0) {
                userList.remove(i);
                System.out.println(user.getPseudo() + " has been deleted");
            } else {
                System.out.println(user.getPseudo() + " has not been deleted");
            }
        }
    }

    public void addMessage(Message message) {
        messageList.add(message);
        System.out.println("new message added");
    }

    public void removeMessage(User user) {
        for (int i = 0; i < messageList.size(); i++) {
            if (messageList.get(i).getIdMessage().toString().equals(user.getId().toString())) {
                messageList.remove(i);
                System.out.println(user.getPseudo() + " has been deleted");
            } else {
                System.out.println(user.getPseudo() + " has not been deleted");
            }
        }
    }

    public void printChatRoom() {
        System.out.println("Title        : " + titleRoom);
        System.out.println("User list    : " + Arrays.toString(userList.toArray()));
        System.out.println("Message list : " + Arrays.toString(messageList.toArray()));
        System.out.println("____over____\n");
    }
    
    public List<Message> getMessageList() {
    	return this.messageList;
    }
    
    public String toString() {
    	return this.titleRoom;
    }
}
