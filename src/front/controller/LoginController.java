package front.controller;

import back.db.DataBaseManager;
import front.model.Constants;
import front.model.User;
import front.view.HomeView;
import front.view.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * <h1>Object LoginController</h1>
 * This class is the controller of the LoginView
 */
public class LoginController {
    private LoginView view;

    /**
     * Constructor of the controller
     * @param view
     */
    public LoginController(LoginView view) {
        this.view = view;
    }

    /**
     * This method enable to define the logic of the submit button
     */
    public void setSubmitButton() {
        List<User> userListDB = DataBaseManager.getAllUsers();
        view.getSubmitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = view.getUsernameField().getText();
                String password = view.getPasswordField().getText();

                for (int i = 0; i < userListDB.size(); i++) {
                    if (userListDB.get(i).getPseudo().equals(username) && userListDB.get(i).getPassword().equals(password)) {
                        System.out.println("connexion : ok");
                        Constants.currentUser = userListDB.get(i);
                        i = userListDB.size();
                        goToHome();
                        view.dispose();

                    } else {
                        System.out.println("connexion : ko");
                        view.getPasswordField().setText("");
                    }
                }
            }
        });
    }


    /**
     * This method enable to run the HomeView
     */
    private void goToHome() {
        view.removeAll();
        HomeView letsGo = new HomeView(Constants.currentUser);
        letsGo.run();
    }

}
