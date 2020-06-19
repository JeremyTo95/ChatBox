package front.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class Message implements Serializable {
    private UUID idMessage;
    private UUID idAuthor;
    private String content;
    private LocalDateTime date;

    public Message(UUID idAuthor, String content) {
        this.idAuthor = idAuthor;
        this.content = content;
        this.idMessage = UUID.randomUUID();
        this.date = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Message{" +
                "idMessage=" + idMessage +
                ", idAuthor=" + idAuthor +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }

    public UUID getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(UUID idMessage) {
        this.idMessage = idMessage;
    }


    public UUID getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(UUID idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
