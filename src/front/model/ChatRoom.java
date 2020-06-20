package front.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * <h1>Object ChatRoom</h1>
 * This class refers to the chat room object, of all chat room in our service
 */
public class ChatRoom implements Serializable {
    private String ip;
    private UUID idChatRoom;
    private String titleRoom;
    private List<User> userList;
    private List<Message> messageList;

    /**
     * Initializes the basic features of the class
     *
     * @param ip IP of the server
     * @param titleRoom Title of the room
     * @param admin User wich create the chat room
     */
    public ChatRoom(String ip, String titleRoom, User admin) {
        this.ip          = ip;
        this.userList    = new ArrayList<>();
        this.messageList = new ArrayList<>();

        this.idChatRoom = UUID.randomUUID();
        this.titleRoom  = titleRoom;
        this.userList.add(admin);
        this.messageList = new ArrayList<>();
    }

    /**
     * This method enable to add a new user in the chat room
     * @param user new user
     */
    public void addUser(User user) {
        userList.add(user);
        System.out.println("new user added");
    }

    /**
     * This method enable to remove a user in the chat room
     * @param user old user
     */
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

    /**
     * This method enable to add a new message
     * @param message the message
     */
    public void addMessage(Message message) {
        messageList.add(message);
        System.out.println("new message added");
    }

    /**
     * This method enable to remove a message
     * @param message
     */
    public void removeMessage(Message message) {
        for (int i = 0; i < messageList.size(); i++) {
            if (messageList.get(i).getIdMessage().toString().equals(message.getIdMessage().toString())) {
                messageList.remove(i);
                System.out.println(message.getContent() + " has been deleted");
            } else {
                System.out.println(message.getContent() + " has not been deleted");
            }
        }
    }

    /**
     * This method enable to get all message under a list
     * @return list of message
     */
    public List<Message> getMessageList() {
        return this.messageList;
    }

    /**
     * This method show the chat room under a string
     * @return title of the room
     */
    public String toString() {
        return this.titleRoom;
    }

    /**
     * This method enable to print the chat room into the console
     */
    public void printChatRoom() {
        System.out.println("Title        : " + titleRoom);
        System.out.println("User list    : " + Arrays.toString(userList.toArray()));
        System.out.println("Message list : " + Arrays.toString(messageList.toArray()));
        System.out.println("____over____\n");
    }

    /**
     * Setter of the IP feature
     * @param ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * Getter of the id feature
     * @return
     */
    public UUID getIdChatRoom() {
        return idChatRoom;
    }

    /**
     * Setter of the id feature
     * @param idChatRoom
     */
    public void setIdChatRoom(UUID idChatRoom) {
        this.idChatRoom = idChatRoom;
    }

    /**
     * Getter of the IP feature
     * @return
     */
    public String getIp() {
        return ip;
    }
}
