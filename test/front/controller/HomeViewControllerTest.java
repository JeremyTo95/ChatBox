package front.controller;

import front.model.User;
import front.view.HomeView;
import org.junit.Test;

import static org.junit.Assert.*;

public class HomeViewControllerTest {
    User user = new User("Prénom", "Nom", "Pseudo", "password");
    HomeView homeView = new HomeView(user);
    HomeViewController homeViewController = new HomeViewController(homeView, user);

    @Test
    public void getUser() {
        assertEquals(user, homeViewController.getUser());
    }

    @Test
    public void setUser() {
        User user2 = new User("Prénom1", "Nom1", "Pseudo1", "password1");
        homeViewController.setUser(user2);
        assertEquals(user2, homeViewController.getUser());
    }
}