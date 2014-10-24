package chatbot.view;

import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import chatbot.controller.ChatBotController;

import java.awt.Font;

public class ChatBotPanel extends JPanel
{
	private ChatBotController baseController;

	private JButton InputButton;
	private JTextField InputTextField;
	private SpringLayout baseLayout;
	private JTextArea chatBotArea;
	private JScrollPane chatBotPane;
	private JScrollPane userChatPane;
	private JTextArea userChatArea;
	private Label chatBotTitle;
	private Label chatBotName;
	private static Label userNameLabel;

	public ChatBotPanel(ChatBotController baseController)
	{
		this.baseController = baseController;

		InputButton = new JButton("Enter");
		InputTextField = new JTextField(45);
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.WEST, InputTextField, 20, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, InputTextField, -6, SpringLayout.WEST, InputButton);
		chatBotArea = new JTextArea(15, 15);
		chatBotArea.setFont(new Font("Monospaced", Font.BOLD, 13));
		chatBotArea.setForeground(new Color(255, 0, 0));
		chatBotPane = new JScrollPane(chatBotArea);
		baseLayout.putConstraint(SpringLayout.WEST, chatBotPane, 20, SpringLayout.WEST, this);
		userChatArea = new JTextArea(15, 15);
		userChatArea.setFont(new Font("Monospaced", Font.BOLD, 13));
		userChatArea.setForeground(new Color(0, 0, 255));
		userChatPane = new JScrollPane(userChatArea);
		baseLayout.putConstraint(SpringLayout.NORTH, InputButton, 4, SpringLayout.SOUTH, userChatPane);
		baseLayout.putConstraint(SpringLayout.EAST, InputButton, 0, SpringLayout.EAST, userChatPane);
		baseLayout.putConstraint(SpringLayout.WEST, userChatPane, 220, SpringLayout.WEST, this);
		chatBotTitle = new Label("ChatBot");
		chatBotTitle.setForeground(Color.BLACK);
		chatBotTitle.setFont(new Font("Arial", Font.BOLD, 30));
		chatBotName = new Label(baseController.getMyChatBot().getName());
		chatBotName.setFont(new Font("Arial", Font.BOLD, 12));
		chatBotName.setForeground(Color.BLACK);
		userNameLabel = new Label("?????????????????");
		userNameLabel.setFont(new Font("Arial", Font.BOLD, 12));
		baseLayout.putConstraint(SpringLayout.WEST, userNameLabel, 220, SpringLayout.WEST, this);

		setupPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPane()
	{
		chatBotArea.setLineWrap(true);
		chatBotArea.setWrapStyleWord(true);
		userChatArea.setLineWrap(true);
		userChatArea.setWrapStyleWord(true);
		
	}
	
	/**
	 * Sets up the Panel inside the Frame. Adds objects into the panel.
	 */
	private void setupPanel()
	{
		this.setBackground(Color.CYAN);
		this.setSize(600, 600);
		this.setLayout(baseLayout);
		this.add(InputButton);
		this.add(InputTextField);
		this.add(chatBotPane);
		this.add(userChatPane);
		this.add(chatBotTitle);
		this.add(chatBotName);
		this.add(userNameLabel);
	}

	/**
	 * Sets up the location for all of the objects.
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, InputTextField, 5, SpringLayout.SOUTH, chatBotPane);
		baseLayout.putConstraint(SpringLayout.NORTH, chatBotPane, 60, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatBotTitle, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatBotTitle, 130, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, userChatPane, 60, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatBotName, 20, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatBotName, 40, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, userNameLabel, 40, SpringLayout.NORTH, this);
	}

	/**
	 * Sets up listeners for interactive objects.
	 */
	private void setupListeners()
	{
		InputButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				InputTextField.setText(InputTextField.getText()+" :)");
			}
		});
	}
	
	public static void setUserName(String name)
	{
		userNameLabel.setText(name);
	}
}
