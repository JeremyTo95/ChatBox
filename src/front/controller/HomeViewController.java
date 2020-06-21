package front.controller;

import back.db.DataBaseManager;
import back.server.Client;
import front.model.*;
import front.view.HomeView;
import front.view.PopUpAddDiscussion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * <h1>Object HomeViewController</h1>
 * This class is the controller of the HomeView
 */
public class HomeViewController {
	private HomeView view;
	private User user;
	private List<ChatRoom> chatRoomList;

	/**
	 * This constructor initialises the basic informations of a HomeViewController
	 *
	 * @param view
	 */
	public HomeViewController(HomeView view, User user) {
		this.view = view;
		this.user = user;
		this.chatRoomList = UserRoom.getChatRoomByIdUser(user.getId());
	}

	/**
	 * This methode enable to initialize all the controller methods on the UI
	 */
	public void onCreate() {
		Constants.client = new Client(view.getListMessageModel(), view.getListDiscussionModel());
		Constants.client.connect(Constants.IP_SERVER);
		setDefaultListModel(chatRoomList, UserRoom.getUserRoomByIdUser(user.getId()), view.getListDiscussionModel());
		setRefreshButton();
		setSubmitButton();
		setDisconnectButton();
		setAddingButton();
	}

	/**
	 * This method configure the refresh button
	 */
	public void setRefreshButton() {
		view.getRefreshButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("refresh");
				view.getListDiscussionModel().clear();
				setDefaultListModel(UserRoom.getChatRoomByIdUser(Constants.currentUser.getId()), UserRoom.getUserRoomByIdUser(user.getId()), view.getListDiscussionModel());
			}
		});
	}

	/**
	 * This method configure the adding button to open a pop up that allows you to
	 */
	public void setAddingButton() {
		view.getAddingButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PopUpAddDiscussion popupDiscussion = new PopUpAddDiscussion(user);
				popupDiscussion.run();
				 view.setListDiscussionModel(popupDiscussion.getListDiscussionModel());
			}
		});
	}

	/**
	 * This method configure the diconnect button
	 */
	public void setDisconnectButton() {
		view.getDisconnectButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Constants.client.disconnect();
				System.exit(0);
			}
		});
	}

	/**
	 * This method configure the send button to send the message to the server
	 */
	public void setSubmitButton() {
		view.getSendButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addMessageToList();
			}
		});
	}

	/**
	 * This method enable to send and stock a message on the server and to show the message on the screen
	 */
	public void addMessageToList() {
		String msg = view.getWritingField().getText();
		Message m = new Message(user.getId(), Constants.chatRoom.getIdChatRoom(), msg);
		view.getWritingField().setText("");
		Constants.client.sendMessage(m);
		DataBaseManager.sendMessageToDB(m);
	}

	/**
	 * This method enable to set a default model list
	 */
	public static void setDefaultListModel(List<ChatRoom> chatRoomList, List<UserRoom> userRoomList, DefaultListModel listDiscussionModel) {
		for (int k = 0; k < chatRoomList.size(); k++) {
			for (int l = 0; l < userRoomList.size(); l++) {
				if (chatRoomList.get(k).getIdChatRoom().equals(userRoomList.get(l).getIdChatRoom()))
					HomeView.addDiscussionToModel(listDiscussionModel, chatRoomList.get(k));
			}
		}
	}

	/**
	 * This method load the current messages of discussion
	 */
	public void loadScreenMessage() {
		List<Message> allMessages = DataBaseManager.getAllMessage();
		for (int i = 0; i < allMessages.size(); i++) {
			if (allMessages.get(i).getIdChatRoom().equals(Constants.chatRoom.getIdChatRoom()))
				view.writeNewMessage(view.getListMessageModel(), Constants.chatRoom, allMessages.get(i));
		}
	}


	/**
	 * Getter of chatRoomList
	 * @return
	 */
	public List<ChatRoom> getChatRoomList() { return chatRoomList; }

	/**
	 * Getter of user
	 * @return
	 */
	public User getUser() { return user; }

	/**
	 * Setter of User
	 * @param user
	 */
	public void setUser(User user) { this.user = user; }

	/**
	 * Setter of Chatroom
	 * @param chatRoomList
	 */
	public void setChatRoomList(List<ChatRoom> chatRoomList) { this.chatRoomList = chatRoomList; }
}
