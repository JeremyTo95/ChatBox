package front.model;

import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class ChatRoomTest {
    @Test
    public void testToString() {
        String title = "My ChatRoom";
        ChatRoom chatRoom = new ChatRoom(UUID.fromString("ad944d49-9ece-4c88-922d-23d9c7058632"), title);
        assertEquals(title, chatRoom.toString());
    }

    @Test
    public void getIdChatRoom() {
        String title = "My ChatRoom";
        ChatRoom chatRoom = new ChatRoom(UUID.fromString("ad944d49-9ece-4c88-922d-23d9c7058632"), title);
        assertEquals(UUID.fromString("ad944d49-9ece-4c88-922d-23d9c7058632"), chatRoom.getIdChatRoom());
    }

    @Test
    public void setIdChatRoom() {
        String title = "My ChatRoom";
        String oldId = "ad944d49-9ece-4c88-922d-23d9c7058632";
        String newId = "aecc2de8-c902-4df9-aaa2-63046f64fa9a";
        ChatRoom chatRoom = new ChatRoom(UUID.fromString(oldId), title);
        chatRoom.setIdChatRoom(UUID.fromString(newId));
        assertEquals(UUID.fromString(newId), chatRoom.getIdChatRoom());
    }

    @Test
    public void getTitleRoom() {
        String title = "My ChatRoom";
        ChatRoom chatRoom = new ChatRoom(UUID.fromString("ad944d49-9ece-4c88-922d-23d9c7058632"), title);
        assertEquals(title, chatRoom.toString());
    }
}