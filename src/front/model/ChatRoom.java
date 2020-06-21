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
    // vieux
//    private UUID idChatRoom;
//    private String titleRoom;
//    private List<User> userList;
//    private List<Message> messageList;

    // neuf
    private UUID   idChatRoom;
    private String titleRoom;

    /**
     * Initializes the basic features of the class
     *
     * @param titleRoom Title of the room
     * @param admin User wich create the chat room
     */
    public ChatRoom(UUID id, String titleRoom, User admin) {
//        this.userList    = new ArrayList<>();
//        this.messageList = new ArrayList<>();

//        this.idChatRoom = UUID.randomUUID();
        this.idChatRoom = id;
        this.titleRoom  = titleRoom;
//        this.userList.add(admin);
//        this.messageList = new ArrayList<>();
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
        System.out.println("____over____\n");
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


    public String getTitleRoom() {
        return titleRoom;
    }

}
