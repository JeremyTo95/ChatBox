package front.view;

import front.model.Constants;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JLabel welcomeTextLabel;
    private JButton signInButton;
    private JButton signUpButton;
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JTextField passwordField;
    private JButton submitButton;

    public LoginView() {
        super();
        this.setView();
    }

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
        this.passwordField = new JTextField();
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        pan.add(passwordPanel);

        this.submitButton = createButton("CONNEXION", Color.BLACK, Color.WHITE);
        pan.add(submitButton);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSubmitButton();
    }

    public JButton createButton(String name, Color color, Color textColor) {
        JButton b = new JButton(name);
        b.setBackground(color);
        b.setOpaque(true);
        b.setBorderPainted(false);
        b.setForeground(textColor);
        return b;
    }

    private void setSubmitButton() {
        this.submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();

                for (int i = 0; i < Constants.allUsers.size(); i++) {
                    if (Constants.allUsers.get(i).getPseudo().equals(username) && Constants.allUsers.get(i).getPassword().equals(password)) {
                        // TODO: ENCHAINE SUR LA HOMEVIEW
                        System.out.println("connexion : ok");
                        Constants.currentUser = Constants.allUsers.get(i);
                        i = Constants.allUsers.size();
                        goToHome();
                        dispose();

                    } else {
                        // TODO: EFFACE LES CHAMPS PASSWORD
                        System.out.println("connexion : ko");
                        passwordField.setText("");
                    }
                }
            }
        });
    }

    private void goToHome() {
        this.removeAll();
        HomeView letsGo = new HomeView(Constants.currentUser);
        letsGo.run();
    }
}

/*
 * TODO: ................................. FONCTION PRINCIPALE
 * .................................
 *
 * TODO: MENU DE CONNEXION (LOGIN PAGE) --> Récupère l'utilisateur courant et
 * son profil --> Récupère tous les chatRooms où il est identifié
 *
 * TODO: MENU D'ACCEUIL (HOME PAGE) --> Rejoindre un chat room --> Créer un
 * nouveau chatRoom --> Ajouter / Selectionner des utilisateurs --> Ajouter un
 * titre au salon
 *
 * TODO: FENETRE DE DISCUSSION (CHAT ROOM) --> Récupère les messages de ce chat
 * --> Envoie d'un nouveau message dans le chat
 */
