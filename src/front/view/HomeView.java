package front.view;

import front.controller.HomeViewController;
import front.model.Constants;
import front.model.Message;
import front.model.User;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <h1>Object HomeView</h1>
 * This class is the Home UI
 */
public class HomeView extends JFrame {
    private User user;
    private String ipChatRoom;
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
    }

    /**
     * This method enable to show and configure the UI
     */
    public void run() {
        setDefaultListModel();
        setView();
        this.addingListListener(this.listDiscussionArea);
        setSubmitButton();
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
            listDiscussionModel.addElement(controller.getChatRoomList().get(k));
        }
        for (int i = 0; i < controller.getChatRoomList().size(); i++) {
            for (int j = 0; j < controller.getChatRoomList().get(i).getMessageList().size(); j++) {
                listMessageModel.addElement(controller.getChatRoomList().get(i).getMessageList().get(j).getContent());
            }
        }
    }

    /**
     * This method enable to configure the discussion label
     */
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

    /**
     * This method add a listener to the list view to get focus on a chat room
     * @param list
     */
    private void addingListListener(JList list) {
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting() == false) {
                    setCurrentDiscussionLabel();
                    ipChatRoom = controller.getChatRoomList().get(list.getSelectedIndex()).getIp();
                    System.out.println(ipChatRoom + " " + list.getSelectedIndex());
                    Constants.client.connect(Constants.IP_SERVER);
                }
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
        writingField.setText("");
        Constants.client.sendMessage(new Message(user.getId(), msg));
    }

    /**
     * Getter of the user
     * @return
     */
    public User getUser() {
        return user;
    }
}