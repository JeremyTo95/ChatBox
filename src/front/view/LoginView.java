package front.view;

import back.db.DataBaseManager;
import front.controller.LoginController;
import front.model.Constants;
import front.model.User;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * <h1>Object LoginView</h1>
 * This class is the login UI
 */
public class LoginView extends JFrame {
    private JLabel welcomeTextLabel;
    private JButton signInButton;
    private JButton signUpButton;
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton submitButton;

    private LoginController controller;

    /**
     * Constructor of the UI
     */
    public LoginView() {
        super();
        controller = new LoginController(this);
        this.setView();
    }

    /**
     * This method enable to show and configure the UI
     */
    public void setView() {
        this.setResizable(false);
        this.setSize(new Dimension(700, 350));
        this.setTitle("ChatBox");
        this.setBackground(Color.PINK);
        this.setLocationRelativeTo(null);

        Border blackline = BorderFactory.createLineBorder(Color.BLACK);

        JPanel pan = new JPanel();
        this.setContentPane(pan);
        pan.setBackground(Color.PINK);
        pan.setBorder(blackline);

        this.setLayout(new BoxLayout(pan, BoxLayout.Y_AXIS));

        this.welcomeTextLabel = new JLabel("Bienvenue!");
        welcomeTextLabel.setBorder(blackline);
        pan.add(welcomeTextLabel);

        JPanel signPanel = new JPanel();
        signPanel.setLayout(new BoxLayout(signPanel, BoxLayout.X_AXIS));
        signPanel.setBackground(Color.PINK);
        signPanel.setBorder(blackline);
        pan.add(signPanel);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.X_AXIS));
        loginPanel.setBackground(Color.PINK);
        loginPanel.setBorder(blackline);

        this.usernameLabel = new JLabel("Username", SwingConstants.RIGHT);
        this.usernameField = new JTextField();
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        pan.add(loginPanel);

        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.X_AXIS));
        passwordPanel.setBackground(Color.PINK);
        this.passwordLabel = new JLabel("Password", SwingConstants.RIGHT);
        this.passwordField = new JPasswordField();
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        pan.add(passwordPanel);

        this.submitButton = createButton("CONNEXION", Color.BLACK, Color.WHITE);
        pan.add(submitButton);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        controller.setSubmitButton();
    }

    /**
     * This method enable to create a button from a name, background color and text color
     *
     * @param name
     * @param color
     * @param textColor
     * @return
     */
    public JButton createButton(String name, Color color, Color textColor) {
        JButton b = new JButton(name);
        b.setBackground(color);
        b.setOpaque(true);
        b.setBorderPainted(false);
        b.setForeground(textColor);
        return b;
    }


    public JLabel getWelcomeTextLabel() { return welcomeTextLabel; }
    public JButton getSignInButton() { return signInButton; }
    public JButton getSignUpButton() { return signUpButton; }
    public JLabel getUsernameLabel() { return usernameLabel; }
    public JTextField getUsernameField() { return usernameField; }
    public JLabel getPasswordLabel() { return passwordLabel; }
    public JPasswordField getPasswordField() { return passwordField; }
    public JButton getSubmitButton() { return submitButton; }
}
