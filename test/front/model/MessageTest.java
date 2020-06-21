package front.model;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.Assert.*;

public class MessageTest {
    String idMessage = "ad944d49-9ece-4c88-922d-23d9c7058632";
    String idAuthor = "ad944d49-9ece-4c88-922d-23d9c7058610";
    String idChatRoom = "ad944d49-9ece-4c88-922d-23d9c5058632";
    String content = "Message 1";
    String date = "2020-06-21T19:01:00.900974500";
    Message message = new Message(UUID.fromString(idMessage), UUID.fromString(idAuthor), UUID.fromString(idChatRoom), content, date);


    @Test
    public void testToString() {
        String testExit = "Message{" + "idMessage=" + idMessage + "!: idAuthor=" + idAuthor + "!: idChatRoom=" + idChatRoom + "!: content=" + content + "!: date=" + date + '}';
        assertEquals(testExit, message.toString());
    }

    @Test
    public void fromString() {
        String testExit = "Message{" + "idMessage=" + idMessage + "!: idAuthor=" + idAuthor + "!: idChatRoom=" + idChatRoom + "!: content=" + content + "!: date=" + date + '}';
        Message messageTest =  new Message(UUID.fromString(idMessage), UUID.fromString(idAuthor), UUID.fromString(idChatRoom), content, date);
        assertEquals(messageTest.toString(), Message.fromString(testExit).toString());
    }

    @Test
    public void getIdMessage() {
        assertEquals(UUID.fromString(idMessage), message.getIdMessage());
    }

    @Test
    public void setIdMessage() {
        String newIdMessage = "3147dab9-3b85-4e76-81b7-d76a4c7292cc";
        Message m = message;
        m.setIdMessage(UUID.fromString(newIdMessage));
        assertEquals(UUID.fromString(newIdMessage), m.getIdMessage());
    }

    @Test
    public void getIdAuthor() {
        assertEquals(UUID.fromString(idAuthor), message.getIdAuthor());
    }

    @Test
    public void setIdAuthor() {
        String newIdAuthor = "3147dab9-3b85-4e76-81b7-d76a4c7292cc";
        Message m = message;
        m.setIdAuthor(UUID.fromString(newIdAuthor));
        assertEquals(UUID.fromString(newIdAuthor), m.getIdAuthor());
    }

    @Test
    public void getContent() {
        assertEquals(content, message.getContent());
    }

    @Test
    public void setContent() {
        String newContent = "new Messagee";
        Message m = message;
        m.setContent(newContent);
        assertEquals(newContent, m.getContent());
    }

    @Test
    public void getDate() {
        assertEquals(LocalDateTime.parse(date), message.getDate());
    }

    @Test
    public void setDate() {
        LocalDateTime newDate = LocalDateTime.parse("2020-06-21T19:19:11.735983300");
        Message m = message;
        m.setDate(newDate);
        assertEquals(newDate, m.getDate());
    }

    @Test
    public void getIdChatRoom() {
        assertEquals(UUID.fromString(idChatRoom), message.getIdChatRoom());
    }
}