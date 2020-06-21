package front.view;

import org.junit.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;

public class LoginViewTest {
    String name = "myButton";
    Color backColor = Color.BLUE;
    Color textColor = Color.white;

    @Test
    public void createButtonTest() {
        LoginView loginView = new LoginView();
        JButton jb = new JButton(name);
        jb.setBackground(backColor);
        jb.setOpaque(true);
        jb.setBorderPainted(false);
        jb.setForeground(textColor);
        assertEquals(jb.toString(), loginView.createButton(name, backColor, textColor).toString());
    }
}