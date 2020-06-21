package front.view;

import front.controller.HomeViewController;
import front.model.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * <h1>Object HomeView</h1>
 * This class is the Home UI
 */
public class HomeView extends JFrame {
    private JPanel container;
    private JButton refreshButton;
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
    private HomeViewController controller;

    /**
     * This constructor initalize the home view feature from a user
     * @param user
     */
    public HomeView(User user) {
        super();
        this.container                = new JPanel();
        this.controller               = new HomeViewController(this, user);
        this.refreshButton            = new JButton("Refresh");
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
        controller.onCreate();
        addingButton.setEnabled(false);
    }

    /**
     * This method enable to show and configure the UI
     */
    public void run() {
        setView();
        this.addingListListener(this.listDiscussionArea);
    }

    /**
     * This methode enable to show the view
     */
    public void setView() {
        //buttonsPanel
        JPanel buttonsPanel = new JPanel();
        setPanel(buttonsPanel, new GridLayout(1, 2), Color.PINK);
        buttonsPanel.add(addingButton);
        buttonsPanel.add(refreshButton);
        // sendPanel
        JPanel sendPanel = new JPanel();
        setPanel(sendPanel, new GridLayout(1, 2), Color.PINK);
        writingField.setColumns(100);
        sendPanel.add(writingField);
        sendPanel.add(sendButton);
        // leftPanel
        JPanel leftPanel = new JPanel();
        setPanel(leftPanel, new BoxLayout(leftPanel, BoxLayout.Y_AXIS), Color.PINK);
        leftPanel.add(buttonsPanel);
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
     * This method enable to configure the discussion label
     */
    private void setCurrentDiscussionLabel() {
        if (listDiscussionArea.isSelectionEmpty()) currentDiscussionLabel.setText("Please select or add a discussion");
        else currentDiscussionLabel.setText(Constants.chatRoom.toString());
    }

    /**
     * This method add a listener to the list view to get focus on a chat room
     * @param list
     */
    private void addingListListener(JList list) {
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting() == false) {
                    System.out.println(list.getSelectedIndex());
                    if (list.getSelectedIndex() != -1) {
                        Constants.chatRoom = UserRoom.getChatRoomByIdUser(controller.getUser().getId()).get(list.getSelectedIndex());
                        System.out.println(Constants.chatRoom);
                        setCurrentDiscussionLabel();
                        clearScreenMessage();
                        controller.loadScreenMessage();
                        addingButton.setEnabled(true);
                    }
                }
            }
        });
    }

    /**
     * This method add a message on the UI
     * @param listDiscussionModel
     * @param chat
     */
    public static void addDiscussionToModel(DefaultListModel listDiscussionModel, ChatRoom chat) {
        listDiscussionModel.addElement(chat);
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

    private void clearScreenMessage() { listMessageModel.clear(); }
    private void clearDiscussion() { this.listDiscussionModel.clear(); }


    public DefaultListModel getListDiscussionModel() { return listDiscussionModel; }
    public DefaultListModel getListMessageModel() { return listMessageModel; }
    public JPanel getContainer() { return container; }
    public void setContainer(JPanel container) { this.container = container; }
    public JButton getRefreshButton() { return refreshButton; }
    public void setRefreshButton(JButton refreshButton) { this.refreshButton = refreshButton; }
    public JButton getDisconnectButton() { return disconnectButton; }
    public void setDisconnectButton(JButton disconnectButton) { this.disconnectButton = disconnectButton; }
    public JButton getAddingButton() { return addingButton; }
    public void setAddingButton(JButton addingButton) { this.addingButton = addingButton; }
    public JButton getSendButton() { return sendButton; }
    public void setSendButton(JButton sendButton) { this.sendButton = sendButton; }
    public JLabel getCurrentDiscussionLabel() { return currentDiscussionLabel; }
    public void setCurrentDiscussionLabel(JLabel currentDiscussionLabel) { this.currentDiscussionLabel = currentDiscussionLabel; }
    public JTextField getWritingField() { return writingField; }
    public void setWritingField(JTextField writingField) { this.writingField = writingField; }
    public void setListDiscussionModel(DefaultListModel listDiscussionModel) { this.listDiscussionModel = listDiscussionModel; }
    public void setListMessageModel(DefaultListModel listMessageModel) { this.listMessageModel = listMessageModel; }
    public JList getListDiscussionArea() { return listDiscussionArea; }
    public void setListDiscussionArea(JList listDiscussionArea) { this.listDiscussionArea = listDiscussionArea; }
    public JList getListMessageArea() { return listMessageArea; }
    public void setListMessageArea(JList listMessageArea) { this.listMessageArea = listMessageArea; }
    public JScrollPane getListDiscussionScrollPane() { return listDiscussionScrollPane; }
    public void setListDiscussionScrollPane(JScrollPane listDiscussionScrollPane) { this.listDiscussionScrollPane = listDiscussionScrollPane; }
    public JScrollPane getListMessageScrollPane() { return listMessageScrollPane; }
    public void setListMessageScrollPane(JScrollPane listMessageScrollPane) { this.listMessageScrollPane = listMessageScrollPane; }
    public HomeViewController getController() { return controller; }
    public void setController(HomeViewController controller) { this.controller = controller; }
}
