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
    private UUID   idChatRoom;
    private String titleRoom;

    /**
     * Initializes the basic features of the class
     *
     * @param titleRoom Title of the room
     */
    public ChatRoom(UUID id, String titleRoom) {
        this.idChatRoom = id;
        this.titleRoom  = titleRoom;
    }


    /**
     * This method show the chat room under a string
     * @return title of the room
     */
    public String toString() {
        return this.titleRoom;
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
     * Getter of the titleRoom
     * @return
     */
    public String getTitleRoom() {
        return titleRoom;
    }

}
