package front.view;

import back.db.DataBaseManager;
import back.server.Client;
import front.controller.HomeViewController;
import front.model.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * <h1>Object HomeView</h1>
 * This class is the Home UI
 */
public class HomeView extends JFrame {
    private User user;
    private List<UserRoom> userRoomList;
    private JPanel container;
    private HomeViewController controller;
    private JButton disconnectButton;
    private JButton addingButton;
    private JButton sendButton;
    private JLabel currentDiscussionLabel;
    private JTextField writingField;
    private DefaultListModel listDiscussionModel;
    private DefaultListModel listMessageModel;
    private JList listDiscussionArea;
    private JList listMessageArea;
    private JScrollPane listDiscussionScrollPane;
    private JScrollPane listMessageScrollPane;

    /**
     * This constructor initalize the home view feature from a user
     * @param user
     */
    public HomeView(User user) {
        super();
        this.user                     = user;
        this.container                = new JPanel();
        this.controller               = new HomeViewController(this);
        this.disconnectButton         = new JButton("Disconnect");
        this.addingButton             = new JButton("Add discussion");
        this.sendButton               = new JButton("Send");
        this.currentDiscussionLabel   = new JLabel("Select or add a discussion");
        this.writingField             = new JTextField();
        this.listMessageModel         = new DefaultListModel();
        this.listDiscussionModel      = new DefaultListModel();
        this.listDiscussionArea       = new JList(listDiscussionModel);
        this.listMessageArea          = new JList(listMessageModel);
        this.listDiscussionScrollPane = new JScrollPane(listDiscussionArea);
        this.listMessageScrollPane    = new JScrollPane(listMessageArea);
        Constants.client              = new Client(listMessageModel);
        Constants.client.connect(Constants.IP_SERVER);
        this.userRoomList = UserRoom.getUserRoomByIdUser(user.getId());
    }

    /**
     * This method enable to show and configure the UI
     */
    public void run() {
        setDefaultListModel();
        setView();
        this.addingListListener(this.listDiscussionArea);
        setSubmitButton();
        setDisconnectButton();
        setAddingButton();
    }

    /**
     * This methode enable to show the view
     */
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

    /**
     * This method define the frame
     */
    public void setFrame() {
        this.setResizable(false);
        this.setSize(new Dimension(700, 350));
        this.setTitle("ChatBox");
        this.setLocationRelativeTo(null);
        this.setContentPane(container);
        this.setVisible(true);
    }

    /**
     * This method define a panel from a LayoutManager and a background color
     * @param p
     * @param lm
     * @param bg
     */
    private void setPanel(JPanel p, LayoutManager lm, Color bg) {
        p.setLayout(lm);
        p.setBackground(bg);
    }

    /**
     * This method enable to set a default model list
     */
    private void setDefaultListModel() {
        for (int k = 0; k < controller.getChatRoomList().size(); k++) {
            for (int l = 0; l < userRoomList.size(); l++) {
                if (controller.getChatRoomList().get(k).getIdChatRoom().equals(userRoomList.get(l).getIdChatRoom()))
                    this.addDiscussionToModel(controller.getChatRoomList().get(k));
            }
        }
        for (int i = 0; i < controller.getChatRoomList().size(); i++) {
//            for (int j = 0; j < controller.getChatRoomList().get(i).getMessageList().size(); j++) {
//                listMessageModel.addElement(controller.getChatRoomList().get(i).getMessageList().get(j).getContent());
//            }
        }
    }

    /**
     * This method enable to configure the discussion label
     */
    private void setCurrentDiscussionLabel() {
        int currentIndex = this.listDiscussionArea.getSelectedIndex();
        if (currentIndex < 0) {
            currentIndex = 0;
        }
        if (this.listDiscussionArea.isSelectionEmpty()) {
            currentDiscussionLabel.setText("Please select or add a discussion");
        } else {
            currentDiscussionLabel.setText(this.listDiscussionModel.getElementAt(currentIndex).toString());
        }
    }

    /**
     * This method add a listener to the list view to get focus on a chat room
     * @param list
     */
    private void addingListListener(JList list) {
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting() == false) {
                    setCurrentDiscussionLabel();
                    Constants.chatRoom = controller.getChatRoomList().get(list.getSelectedIndex());
                    System.out.println(Constants.chatRoom);
                    clearScreenMessage();
                    loadScreenMessage();
                }
            }
        });
    }

    private void loadScreenMessage() {
        List<Message> allMessages = Constants.allMessages;
        // GET ALL MESSAGE AND GET THE MESSAGE OF CHATROOM
        for (int i = 0; i < allMessages.size(); i++) {
            if (allMessages.get(i).getIdChatRoom().equals(Constants.chatRoom.getIdChatRoom()))
                writeNewMessage(listMessageModel, Constants.chatRoom, allMessages.get(i));
        }
    }

    private void addDiscussionToModel(ChatRoom chat) {
        this.listDiscussionModel.addElement(chat);
    }

    /**
     * This method configure the adding button to open a pop up that allows you to
     */
    private void setAddingButton() {
        this.addingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PopUpAddDiscussion popupDiscussion = new PopUpAddDiscussion(user);
                popupDiscussion.run();
                listDiscussionModel = popupDiscussion.getListDiscussionModel();
            }
        });
    }

    private void clearDiscussion() {
        this.listDiscussionModel.clear();
    }

    private void setDisconnectButton() {
        this.disconnectButton.addActionListener(new ActionListener() {
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
    private void setSubmitButton() {
        this.sendButton.addActionListener(new ActionListener() {
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
        String msg = writingField.getText();
        Message m = new Message(user.getId(), Constants.chatRoom.getIdChatRoom(), msg);
        writingField.setText("");
        Constants.client.sendMessage(m);
        Constants.allMessages.add(m);
        DataBaseManager.sendMessageToDB(m);
    }

    /**
     * This method write a message in the message area
     * @param listMessageModel
     * @param msg
     */
    public static void writeNewMessage(DefaultListModel listMessageModel, ChatRoom chatRoom, Message msg) {
        User user = User.getUserFromId(msg.getIdAuthor());
        if (msg.getIdChatRoom().equals(chatRoom.getIdChatRoom()) && user != null)
            listMessageModel.addElement(user.getPseudo() + " : " + msg.getContent());
    }

    private void clearScreenMessage() {
        listMessageModel.clear();
    }

    /**
     * Getter of the user
     * @return
     */
    public User getUser() {
        return user;
    }
}
