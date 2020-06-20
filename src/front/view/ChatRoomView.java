package front.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import front.controller.ChatRoomController;

public class ChatRoomView extends JFrame {
	JPanel container;
	ChatRoomController controller;
	JButton disconnectButton;
	JButton addingButton;
	JButton sendButton;
	JLabel currentDiscussionLabel;
	JTextField writingField;
	DefaultListModel listDiscussionModel;
	DefaultListModel listMessageModel;
	JList listDiscussionArea;
	JList listMessageArea;
	JScrollPane listDiscussionScrollPane;
	JScrollPane listMessageScrollPane;

	public ChatRoomView() {
		super();
		this.container = new JPanel();
		this.controller = new ChatRoomController();
		this.disconnectButton = new JButton("Disconnect");
		this.addingButton = new JButton("Add discussion");
		this.sendButton = new JButton("Send");
		this.currentDiscussionLabel = new JLabel("Select or add a discussion");
		this.writingField = new JTextField();
		this.listMessageModel = new DefaultListModel();
		this.listDiscussionModel = new DefaultListModel();
		this.listDiscussionArea = new JList(listDiscussionModel);
		this.listMessageArea = new JList(listMessageModel);
		this.listDiscussionScrollPane = new JScrollPane(listDiscussionArea);
		this.listMessageScrollPane = new JScrollPane(listMessageArea);
	}

	public void run() {
		setDefaultListModel();
		setView();
		this.addingListListener(this.listDiscussionArea);
	}

	public void setView() {
		// sendPanel
		JPanel sendPanel = new JPanel();
		setPanel(sendPanel, new GridLayout(1, 2), Color.PINK);
		writingField.setColumns(100);
		sendPanel.add(writingField);
		sendPanel.add(sendButton);
		// leftPanel
		JPanel leftPanel = new JPanel();
		setPanel(leftPanel, new BoxLayout(leftPanel, BoxLayout.Y_AXIS), Color.PINK);
		leftPanel.add(addingButton);
		leftPanel.add(listDiscussionScrollPane);
		leftPanel.add(disconnectButton);
		// rightPanel
		JPanel rightPanel = new JPanel();
		setPanel(rightPanel, new BoxLayout(rightPanel, BoxLayout.Y_AXIS), Color.PINK);
		rightPanel.add(currentDiscussionLabel);
		rightPanel.add(listMessageScrollPane);
		rightPanel.add(sendPanel);
		// container
		setPanel(container, new BoxLayout(container, BoxLayout.X_AXIS), Color.PINK);
		container.add(leftPanel);
		container.add(rightPanel);
		// setFrame
		this.setFrame();
	}

	public void setFrame() {
		this.setResizable(false);
		this.setSize(new Dimension(700, 350));
		this.setTitle("ChatBox");
		this.setLocationRelativeTo(null);
		this.setContentPane(container);
		this.setVisible(true);
	}

	private void setPanel(JPanel p, LayoutManager lm, Color bg) {
		p.setLayout(lm);
		p.setBackground(bg);
	}

	private void setDefaultListModel() {
		for (int k = 0; k < controller.getChatRoomList().size(); k++) {
			listDiscussionModel.addElement(controller.getChatRoomList().get(k));
		}
		for (int i = 0; i < controller.getChatRoomList().size(); i++) {
			for (int j = 0; j < controller.getChatRoomList().get(i).getMessageList().size(); j++) {
				listMessageModel.addElement(controller.getChatRoomList().get(i).getMessageList().get(j).getContent());

			}
		}
	}

	private void setCurrentDiscussionLabel() {
		int currentIndex = this.listDiscussionArea.getSelectedIndex();
		;
		if (currentIndex < 0) {
			currentIndex = 0;
		}
		if (this.listDiscussionArea.isSelectionEmpty()) {
			currentDiscussionLabel.setText("Please select or add a discussion");
		} else {
			currentDiscussionLabel.setText(this.listDiscussionModel.getElementAt(currentIndex).toString());
		}
	}

	private void addingListListener(JList list) {
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting() == false) {
					setCurrentDiscussionLabel();
				}
			}
		});
	}

}