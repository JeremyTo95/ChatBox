package front.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.xml.crypto.Data;

import back.db.DataBaseManager;
import front.model.ChatRoom;
import front.model.Constants;
import front.model.User;
import front.model.UserRoom;

public class PopUpAddDiscussion extends JFrame {
	User user;
	JButton addButton;
	JButton cancelButton;
	JPanel container;
	ArrayList<String> selectedUUID;
	DefaultListModel<JCheckBox> model;
	DefaultListModel listDiscussionModel;

	public PopUpAddDiscussion(User user) {
		this.user = user;
		this.addButton = new JButton("Add");
		this.cancelButton = new JButton("Cancel");
		this.container = new JPanel();
		this.selectedUUID = new ArrayList<>();
		this.model = new DefaultListModel<JCheckBox>();
		this.listDiscussionModel = new DefaultListModel();
	}

	public void run() {
		setView();
		setCancelButton();
		setAddButton();
	}

	public void setView() {
		setPanel(container, new BoxLayout(container, BoxLayout.Y_AXIS), Color.PINK);
		JLabel messagePopUpLabel = new JLabel("Ajout nouvelle conversation");

		JPanel buttonsPanel = new JPanel();
		setPanel(buttonsPanel, new BoxLayout(buttonsPanel, BoxLayout.X_AXIS), Color.PINK);
		buttonsPanel.add(this.cancelButton);
		buttonsPanel.add(this.addButton);

		container.add(messagePopUpLabel);

		for (int i = 0; i < Constants.allUsers.size(); i++) {
			model.addElement(new JCheckBox(
					Constants.allUsers.get(i).getPseudo() + " (" + Constants.allUsers.get(i).getFirstName() + ")"));
		}

		JScrollPane listPeoplePan = new JScrollPane(new JCheckBoxList(model));

		container.add(listPeoplePan);
		container.add(buttonsPanel);

		setFrame();
	}

	public void setFrame() {
		this.setResizable(false);
		this.setSize(new Dimension(Constants.POPUP_WIDTH, Constants.POPUP_HEIGHT));
		this.setTitle("ChatBox");
		this.setLocationRelativeTo(null);
		this.setContentPane(container);
		this.setVisible(true);
	}

	private void setPanel(JPanel p, LayoutManager lm, Color bg) {
		p.setLayout(lm);
		p.setBackground(bg);
	}

	public void exitJFrame() {
		this.dispose();
	}

	public List<UUID> getUserInChatRoom() {
		List<UUID> list = new ArrayList<>();

		for (int i = 0; i < this.model.getSize(); i++) {
			if (this.model.get(i).isSelected()) {
				System.out.println(Constants.allUsers.get(i).getPseudo());
				list.add(Constants.allUsers.get(i).getId());
//				this.selectedUUID.add(Constants.allUsers.get(i).getId().toString());
//				// ICI IL Y A UNE ERREUR
//				this.listDiscussionModel.addElement(new ChatRoom(UUID.fromString(selectedUUID.get(i)), "Discussion" + i));
			}
		}

		return list;
	}

	/**
	 * This method configure the send button to send the message to the server
	 */
	private void setAddButton() {
		this.addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChatRoom chatRoom = new ChatRoom(UUID.randomUUID(), "Discussion" + (Constants.allChatRoom.size() + 1));
				DataBaseManager.sendChatRoomToDB(chatRoom);
				List<UUID> usersInChatRoom = getUserInChatRoom();
				for (int i = 0; i < usersInChatRoom.size(); i++) DataBaseManager.sendUserRoomToDB(new UserRoom(usersInChatRoom.get(i), chatRoom.getIdChatRoom()));

				exitJFrame();
			}
		});
	}

	public DefaultListModel getListDiscussionModel() {
		return this.listDiscussionModel;
	}

	private void setCancelButton() {
		this.cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exitJFrame();
			}
		});
	}

	public ArrayList<String> getUUIDList() {
		return this.selectedUUID;
	}

	@SuppressWarnings("serial")
	public class JCheckBoxList extends JList<JCheckBox> {
		protected Border noFocusBorder = new EmptyBorder(1, 1, 1, 1);

		public JCheckBoxList() {
			setCellRenderer(new CellRenderer());
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					int index = locationToIndex(e.getPoint());
					if (index != -1) {
						JCheckBox checkbox = (JCheckBox) getModel().getElementAt(index);
						checkbox.setSelected(!checkbox.isSelected());
						repaint();
					}
				}
			});
			setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}

		public JCheckBoxList(ListModel<JCheckBox> model) {
			this();
			setModel(model);
		}

		protected class CellRenderer implements ListCellRenderer<JCheckBox> {
			public Component getListCellRendererComponent(JList<? extends JCheckBox> list, JCheckBox value, int index,
					boolean isSelected, boolean cellHasFocus) {
				JCheckBox checkbox = value;

				// Drawing checkbox, change the appearance here
				checkbox.setBackground(isSelected ? getSelectionBackground() : getBackground());
				checkbox.setForeground(isSelected ? getSelectionForeground() : getForeground());
				checkbox.setEnabled(isEnabled());
				checkbox.setFont(getFont());
				checkbox.setFocusPainted(false);
				checkbox.setBorderPainted(true);
				checkbox.setBorder(isSelected ? UIManager.getBorder("List.focusCellHighlightBorder") : noFocusBorder);
				return checkbox;
			}
		}
	}
}
