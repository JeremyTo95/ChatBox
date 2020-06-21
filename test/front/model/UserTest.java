package front.model;

import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class UserTest {
    String id = "6952bd59-63e0-47ab-b0f1-034465b8efe8";
    String firstname = "Prénom";
    String lastname = "Nom";
    String pseudo = "pseudo";
    String password = "password";
    User user = new User(id, firstname, lastname, pseudo, password);

    @Test
    public void getUserFromId() {
        assertEquals(UUID.fromString(id), user.getId());
    }

    @Test
    public void testToString() {
        String exit = "User{" +
                "id=" + id +
                ", firstName='" + firstname + '\'' +
                ", lastName='" + lastname + '\'' +
                ", pseudo='" + pseudo + '\'' +
                '}';
        assertEquals(exit, user.toString());
    }

    @Test
    public void getFirstName() {
        assertEquals(firstname, user.getFirstName());
    }

    @Test
    public void setFirstName() {
        String newFirstname = "Nouveau Prénom";
        User u = user;
        u.setFirstName(newFirstname);
        assertEquals(newFirstname, u.getFirstName());
    }

    @Test
    public void getPseudo() {
        assertEquals(pseudo, user.getPseudo());
    }

    @Test
    public void setPseudo() {
        String newPseudo = "newPseudo";
        User u = user;
        u.setPseudo(newPseudo);
        assertEquals(newPseudo, u.getPseudo());
    }

    @Test
    public void getLastName() {
        assertEquals(lastname, user.getLastName());
    }

    @Test
    public void getId() {
        assertEquals(UUID.fromString(id), user.getId());
    }

    @Test
    public void setId() {
        String newId = "a8270806-10a1-45ce-97aa-342910cd1954";
        User u = user;
        u.setId(UUID.fromString(newId));
        assertEquals(UUID.fromString(newId), u.getId());
    }

    @Test
    public void setLastName() {
        String last = "last";
        User u = user;
        u.setLastName(last);
        assertEquals(last, u.getLastName());
    }

    @Test
    public void getPassword() {
        assertEquals(password, user.getPassword());
    }

    @Test
    public void setPassword() {
        String pass = "pass";
        User u = user;
        u.setPassword(pass);
        assertEquals(pass, u.getPassword());
    }
}