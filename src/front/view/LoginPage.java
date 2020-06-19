package front.view;

import back.server.full.Client;
import front.controller.ChatRoomUI;
import front.model.ChatRoom;
import front.model.Constants;
import front.model.Message;
import front.model.User;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class LoginPage extends JFrame {
	private JLabel welcomeTextLabel;
	private JButton signInButton;
	private JButton signUpButton;
	private JLabel usernameLabel;
	private JTextField usernameField;
	private JLabel passwordLabel;
	private JTextField passwordField;
	private JButton submitButton;
	
	
	public LoginPage() {
		super();
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
		this.signInButton = createButton("SignIn", Color.BLUE, Color.WHITE);
		this.signUpButton = createButton("SignUp", Color.RED, Color.WHITE);
		signPanel.add(signInButton);
		signPanel.add(signUpButton);
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
	}
	
		
	public void clearScreen() {
		// Rendre la page complétement blanche pour passer à la prochaine page
	}
	
	public JButton createButton(String name, Color color, Color textColor) {
		JButton b = new JButton(name);
		b.setBackground(color);
		b.setOpaque(true);
		b.setBorderPainted(false);
		b.setForeground(textColor);
		return b;
	}

	public static void main(String[] args) {
		LoginPage letsGo = new LoginPage();
		letsGo.setView();

		ChatRoomUI chatRoomUI = new ChatRoomUI();
		User user = new User("Jérémy", "Tourari", "Sparta");
		User user2 = new User("Sofiane", "Serkesti", "JakenPon");
		ChatRoom chatRoom = new ChatRoom("ChatRoom first test", user);
		chatRoom.addUser(user2);
		chatRoom.addMessage(new Message(user.getId(), "Yo Sof"));
		chatRoomUI.initNewChatRoom(chatRoom);
		chatRoomUI.printChatRoomList();

		chatRoomUI.getChatRoomList().get(0).removeUser(user);
		chatRoomUI.getChatRoomList().get(0).removeUser(user2);
		chatRoomUI.printChatRoomList();

		Client client = new Client();

		client.connect(Constants.IP_SERVER);
		Message message = new Message(user.getId(), "Hello (from Jérémy)");
		Message message2 = new Message(user2.getId(), "Hello (from Sofiane)");
		client.sendMessage(message);
		client.sendMessage(message2);

	}
}

/*
TODO: ................................. FONCTION PRINCIPALE .................................

TODO: MENU DE CONNEXION (LOGIN PAGE) 	--> Récupère l'utilisateur courant et son profil
										--> Récupère tous les chatRooms où il est identifié

TODO: MENU D'ACCEUIL (HOME PAGE) 	--> Rejoindre un chat room
									--> Créer un nouveau chatRoom
										--> Ajouter / Selectionner des utilisateurs
										--> Ajouter un titre au salon

TODO: FENETRE DE DISCUSSION (CHAT ROOM) 	--> Récupère les messages de ce chat
											--> Envoie d'un nouveau message dans le chat
 */
