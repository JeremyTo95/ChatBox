package front.model;

import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class UserRoomTest {
    UUID id1 = UUID.fromString("a8270806-10a1-45ce-97aa-342910cd1954");
    UUID id2 = UUID.fromString("bb88c042-5c32-47a5-b249-ce0750de2007");
    UUID id3 = UUID.fromString("6952bd59-63e0-47ab-b0f1-034465b8efe8");
    UUID id4 = UUID.fromString("ae58891b-e268-451d-841d-15e1e7a6c066");
    UserRoom userRoom = new UserRoom(id1, id2);
    UserRoom ur = userRoom;

    @Test
    public void getIdChatRoom() {
        assertEquals(id2, userRoom.getIdChatRoom());
    }

    @Test
    public void setIdChatRoom() {
        ur.setIdChatRoom(id3);
        assertEquals(id3, ur.getIdChatRoom());
    }

    @Test
    public void getIdAuthor() {
        assertEquals(id1, userRoom.getIdAuthor());
    }

    @Test
    public void setIdAuthor() {
        ur.setIdAuthor(id4);
        assertEquals(id4, ur.getIdAuthor());
    }
}