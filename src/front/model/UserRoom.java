package front.model;

import back.db.DataBaseManager;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserRoom {
    private UUID idAuthor;
    private UUID idChatRoom;

    public UserRoom(UUID idAuthor, UUID idChatRoom) {
        this.idAuthor = idAuthor;
        this.idChatRoom = idChatRoom;
    }

    public static List<UserRoom> getUserRoomByIdUser(UUID idAuthor) {
        List<UserRoom> list = new ArrayList<>();
        List<UserRoom> userRoomDB = DataBaseManager.getAllUserRoom();

        for (int i = 0; i < userRoomDB.size(); i++) {
            if (userRoomDB.get(i).idAuthor.equals(idAuthor)) list.add(userRoomDB.get(i));
        }

        return list;
    }

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

    public UUID getIdChatRoom() {
        return idChatRoom;
    }

    public void setIdChatRoom(UUID idChatRoom) {
        this.idChatRoom = idChatRoom;
    }

    public UUID getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(UUID idAuthor) {
        this.idAuthor = idAuthor;
    }
}
