package front.model;

import back.db.DataBaseManager;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * <h1>Object UserRoom</h1>
 * This class enable to link a ChatRoom and a User
 */
public class UserRoom {
    private UUID idAuthor;
    private UUID idChatRoom;

    /**
     * Constructor of the class
     * @param idAuthor
     * @param idChatRoom
     */
    public UserRoom(UUID idAuthor, UUID idChatRoom) {
        this.idAuthor = idAuthor;
        this.idChatRoom = idChatRoom;
    }

    /**
     * Enable to get the user room of the user from his ID
     * @param idAuthor
     * @return
     */
    public static List<UserRoom> getUserRoomByIdUser(UUID idAuthor) {
        List<UserRoom> list = new ArrayList<>();
        List<UserRoom> userRoomDB = DataBaseManager.getAllUserRoom();

        for (int i = 0; i < userRoomDB.size(); i++) {
            if (userRoomDB.get(i).idAuthor.equals(idAuthor)) list.add(userRoomDB.get(i));
        }

        return list;
    }

    /**
     * Enable to get the chat room list from the id of the user
     * @param idAuthor
     * @return
     */
    public static List<ChatRoom> getChatRoomByIdUser(UUID idAuthor) {
        List<ChatRoom> list = new ArrayList<>();
        List<ChatRoom> chatRoomDB = DataBaseManager.getAllChatRoom();
        List<UserRoom> userRoomByUserId = getUserRoomByIdUser(idAuthor);

        for (int i = 0; i < userRoomByUserId.size(); i++) {
            for (int j = 0; j < chatRoomDB.size(); j++) {
                if (userRoomByUserId.get(i).getIdChatRoom().equals(chatRoomDB.get(j).getIdChatRoom()))
                    list.add(chatRoomDB.get(j));
            }
        }

        return list;
    }

    /**
     * Getter of the chatroom id
     * @return
     */
    public UUID getIdChatRoom() {
        return idChatRoom;
    }

    /**
     * Setter of the Chat room id
     * @param idChatRoom
     */
    public void setIdChatRoom(UUID idChatRoom) {
        this.idChatRoom = idChatRoom;
    }

    /**
     * Getter of the author id
     *
     * @return
     */
    public UUID getIdAuthor() {
        return idAuthor;
    }

    /**
     * Setter of the author id
     * @param idAuthor
     */
    public void setIdAuthor(UUID idAuthor) {
        this.idAuthor = idAuthor;
    }
}
