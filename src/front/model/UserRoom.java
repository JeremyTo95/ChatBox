package front.model;

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

        for (int i = 0; i < Constants.allUserRoom.size(); i++) {
            if (Constants.allUserRoom.get(i).idAuthor.equals(idAuthor)) list.add(Constants.allUserRoom.get(i));
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