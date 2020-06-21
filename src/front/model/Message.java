package front.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * <h1>Object Message</h1>
 * This class represents the message which are exanges on the chatroom
 */
public class Message implements Serializable {
//    vieux
//    private UUID idMessage;
//    private UUID idAuthor;
//    private String content;
//    private LocalDateTime date;

    // new
    private UUID idMessage;
    private UUID idAuthor;
    private UUID idChatRoom;
    private String content;
    private LocalDateTime date;

    /**
     * This constructor is use when parse a message
     *
     * @param idMessage
     * @param idAuthor
     * @param content
     * @param date
     */
    public Message(UUID idMessage, UUID idAuthor, UUID idChatRoom, String content, String date) {
        this.idMessage = idMessage;
        this.idAuthor = idAuthor;
        this.idChatRoom = idChatRoom;
        this.content = content;
        this.date = LocalDateTime.parse(date);
    }

    /**
     * This constructor is use when we create a new message
     *
     * @param idAuthor
     * @param content
     */
    public Message(UUID idAuthor, UUID idChatRoom, String content) {
        this.idAuthor = idAuthor;
        this.idChatRoom = idChatRoom;
        this.content = content;
        this.idMessage = UUID.randomUUID();
        this.date = LocalDateTime.now();
    }

    /**
     * This method is use to parse a message into string
     * @return
     */
    @Override
    public String toString() {
        return "Message{" +
                "idMessage=" + idMessage +
                ", idAuthor=" + idAuthor +
                ", idChatRoom=" + idChatRoom +
                ", content=" + content +
                ", date=" + date +
                '}';
    }

    /**
     * This method is use to parse a string json into a message
     * @param str
     * @return
     */
    public static Message fromString(String str) {
        String data = str.substring(8, str.length()-1);
        String[] dataSplit = data.split(",");
        return new Message(
                UUID.fromString(dataSplit[0].replace("idMessage=", "")),
                UUID.fromString(dataSplit[1].replace(" idAuthor=", "")),
                UUID.fromString(dataSplit[2].replace(" idChatRoom=", "")),
                dataSplit[3].replace(" content=", ""),
                dataSplit[4].replace(" date=", "")
        );
    }

    /**
     * Getter of the message id
     * @return
     */
    public UUID getIdMessage() {
        return idMessage;
    }

    /**
     * Setter of the message id
     * @param idMessage
     */
    public void setIdMessage(UUID idMessage) {
        this.idMessage = idMessage;
    }

    /**
     * Getter of the author id
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

    /**
     * Getter of the message content
     * @return
     */
    public String getContent() {
        return content;
    }

    /**
     * Setter of the message content
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Getter of the message date
     * @return
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Setter of the message date
     * @param date
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    public UUID getIdChatRoom() {
        return idChatRoom;
    }
}
