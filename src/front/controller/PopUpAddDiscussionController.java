package front.controller;

import back.db.DataBaseManager;
import front.model.User;
import front.view.PopUpAddDiscussion;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * <h1>Object PopUpAddDiscussionController</h1>
 * This class is the controller of the PopUpAddDiscussion object
 */
public class PopUpAddDiscussionController {
    private User user;
    private ArrayList<String> selectedUUID;
    private PopUpAddDiscussion view;

    /**
     * Constructor of the controller
     * @param view
     * @param user
     */
    public PopUpAddDiscussionController(PopUpAddDiscussion view, User user) {
        this.view = view;
        this.user = user;
        selectedUUID = new ArrayList<>();
    }

    /**
     * Getter of the users in a chat room
     * @return
     */
    public List<UUID> getUserInChatRoom() {
        List<UUID> list = new ArrayList<>();
        List<User> userListDB = DataBaseManager.getAllUsers();

        for (int i = 0; i < view.getModel().getSize(); i++) {
            if (view.getModel().get(i).isSelected()) {
                list.add(userListDB.get(i).getId());
            }
        }

        return list;
    }

    /**
     * Getter of User
     * @return
     */
    public User getUser() { return user; }

    /**
     * Setter of the User
     * @param user
     */
    public void setUser(User user) { this.user = user; }

    /**
     * Getter of the selectedUUID
     * @return
     */
    public ArrayList<String> getSelectedUUID() { return selectedUUID; }

    /**
     * Getter of the view
     * @return
     */
    public PopUpAddDiscussion getView() { return view; }
}
