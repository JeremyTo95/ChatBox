package front.controller;

import back.db.DataBaseManager;
import front.model.User;
import front.view.PopUpAddDiscussion;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

public class PopUpAddDiscussionControllerTest {
    private User user = new User("Prénom", "Nom", "Pseudo", "password");
    private PopUpAddDiscussion view = new PopUpAddDiscussion(user);
    private PopUpAddDiscussionController controller = new PopUpAddDiscussionController(view, user);


    @Test
    public void getUserInChatRoom() {
        List<UUID> list = new ArrayList<>();
        List<User> userListDB = DataBaseManager.getAllUsers();

        for (int i = 0; i < view.getModel().getSize(); i++) {
            if (view.getModel().get(i).isSelected()) {
                list.add(userListDB.get(i).getId());
            }
        }

        assertEquals(list, controller.getUserInChatRoom());
    }

    @Test
    public void getUser() {
        assertEquals(user, controller.getUser());
    }

    @Test
    public void getSelectedUUID() {
        List<String> list = new ArrayList();
        assertEquals(list, controller.getSelectedUUID());
    }

    @Test
    public void getView() {
        assertEquals(view, controller.getView());
    }
}