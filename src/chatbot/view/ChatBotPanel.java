package chatbot.view;

import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import chatbot.controller.ChatBotController;
import chatbot.model.ChatBotModel;

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
	private JButton checkLengthButton;
	private Label checkersLabel;
	private JButton checkMemeButton;

	public ChatBotPanel(ChatBotController baseController)
	{
		this.baseController = baseController;

		InputButton = new JButton("Enter");
		InputTextField = new JTextField(45);
		baseLayout = new SpringLayout();
		chatBotArea = new JTextArea(15, 15);
		chatBotPane = new JScrollPane(chatBotArea);
		userChatArea = new JTextArea(15, 15);
		userChatPane = new JScrollPane(userChatArea);
		chatBotTitle = new Label("ChatBot");
		chatBotName = new Label(baseController.getMyChatBot().getName());
		userNameLabel = new Label("?????????????????");
		checkLengthButton = new JButton("Length");
		checkersLabel = new Label("Checkers");
		checkMemeButton = new JButton("Meme");

		setupPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPane()
	{
		chatBotArea.setLineWrap(true);
		chatBotArea.setWrapStyleWord(true);
		chatBotArea.setText("---------------");
		chatBotArea.setFont(new Font("Monospaced", Font.BOLD, 13));
		chatBotArea.setForeground(new Color(255, 0, 0));
		userChatArea.setLineWrap(true);
		userChatArea.setWrapStyleWord(true);
		userChatArea.setText("---------------");
		userChatArea.setFont(new Font("Monospaced", Font.BOLD, 13));
		userChatArea.setForeground(new Color(0, 0, 255));
		chatBotTitle.setForeground(Color.BLACK);
		chatBotTitle.setFont(new Font("Arial", Font.BOLD, 30));
		chatBotName.setFont(new Font("Arial", Font.BOLD, 12));
		chatBotName.setForeground(Color.BLACK);
		userNameLabel.setFont(new Font("Arial", Font.BOLD, 12));
		checkersLabel.setFont(new Font("Arial", Font.PLAIN, 12));
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
		this.add(checkLengthButton);
		this.add(checkersLabel);
		this.add(checkMemeButton);
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
		baseLayout.putConstraint(SpringLayout.WEST, InputTextField, 20, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, InputTextField, -6, SpringLayout.WEST, InputButton);
		baseLayout.putConstraint(SpringLayout.WEST, userNameLabel, 220, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, InputButton, 4, SpringLayout.SOUTH, userChatPane);
		baseLayout.putConstraint(SpringLayout.EAST, InputButton, 0, SpringLayout.EAST, userChatPane);
		baseLayout.putConstraint(SpringLayout.WEST, userChatPane, 220, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatBotPane, 20, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, checkLengthButton, -8, SpringLayout.WEST, checkersLabel);
		baseLayout.putConstraint(SpringLayout.EAST, checkersLabel, 0, SpringLayout.WEST, userChatPane);
		baseLayout.putConstraint(SpringLayout.NORTH, checkLengthButton, 0, SpringLayout.SOUTH, checkersLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, checkersLabel, 0, SpringLayout.NORTH, chatBotPane);
		baseLayout.putConstraint(SpringLayout.NORTH, checkMemeButton, 5, SpringLayout.SOUTH, checkLengthButton);
		baseLayout.putConstraint(SpringLayout.EAST, checkMemeButton, -3, SpringLayout.EAST, checkLengthButton);
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
				if(!InputTextField.getText().equals(""))
				{
					String result = InputTextField.getText();
					userChatArea.setText(userChatArea.getText() + "\n" + "\n" + InputTextField.getText());
					result = baseController.myChatBot.processText(result);
					chatBotArea.setText(chatBotArea.getText() + "\n" + "\n" + result);
					InputTextField.setText("");
				}
			}
		});

		checkLengthButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				if (ChatBotModel.stringChecker(InputTextField.getText()))
				{
					chatBotArea.setText(chatBotArea.getText() + "\n" + "\n" + "Wow! You talk really fast!");
				}
				else
				{
					chatBotArea.setText(chatBotArea.getText() + "\n" + "\n" + "You talk sooooo slow.");
				}

			}
		});
	}

	public static void setUserName(String name)
	{
		userNameLabel.setText(name);
	}
	
	public void showTextMessage(String userInput)
	{
		userChatArea.append("\n" + "\n" + userInput);
	}
}
