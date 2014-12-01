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
	/**
	 * This is the ChatBotController class
	 */
	private ChatBotController baseController;
	private ChatBotModel myChatBot;
	/**
	 * This button sends information to the ChatBot.
	 */
	private JButton InputButton;
	/**
	 * This is where the user inputs info
	 */
	private JTextField InputTextField;
	/**
	 * This is the layout of the GUI
	 */
	private SpringLayout baseLayout;
	/**
	 * This is where the ChatBot's chats appear
	 */
	private JTextArea chatBotArea;
	/**
	 * This is what contains the chatBotArea
	 */
	private JScrollPane chatBotPane;
	/**
	 * This is what contains the userChatArea
	 */
	private JScrollPane userChatPane;
	/**
	 * This is where the user's Chats appear
	 */
	private JTextArea userChatArea;
	/**
	 * This is the title of the program
	 */
	private Label chatBotTitle;
	/**
	 * This is the name of the Chat Bot
	 */
	private Label chatBotName;
	/**
	 * This is the name of the user
	 */
	private static Label userNameLabel;
	/**
	 * This executes the length checker
	 */
	private JButton checkLengthButton;
	/**
	 * This is the word Checkers
	 */
	private Label checkersLabel;
	/**
	 * This executes the meme checker
	 */
	private JButton checkMemeButton;
	/**
	 * When pressed, this will display the available topics in the ChatBot's area
	 */
	private JButton showTopicsButton;
	/**
	 * This is the word Information
	 */
	private Label informationLabel;
	/**
	 * This is the string "Chats:"
	 */
	private Label chatCountLabel;
	/**
	 * This displays the current number of chats
	 */
	public static Label chatCountNumberLabel;
	private JButton showUserInfoButton;
	private JButton mashButton;

	/**
	 * This is the constructor for the Panel
	 * @param baseController
	 */
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
		showTopicsButton = new JButton("Topics");
		informationLabel = new Label("Information");
		chatCountLabel = new Label("Chats:");
		chatCountNumberLabel = new Label("0");
		showUserInfoButton = new JButton("You");
		mashButton = new JButton("Mash");

		setupPane();
		setupPanel();
		setupLayout();
		setupListeners();
//		ChatBotFrame.getRootPane().setDefaultButton(InputButton);
//		find out why doesn't work
	}

	/**
	 * This sets up the properties of the objects
	 */
	private void setupPane()
	{
		chatBotArea.setLineWrap(true);
		chatBotArea.setWrapStyleWord(true);
		chatBotArea.setText("---------------" + "\n" + "What do you want to talk about?" + "\n" + "\n" + "(press the topics button for available topics)");
		chatBotArea.setFont(new Font("Monospaced", Font.BOLD, 13));
		chatBotArea.setForeground(new Color(255, 0, 0));
		chatBotArea.setEditable(false);
		userChatArea.setLineWrap(true);
		userChatArea.setWrapStyleWord(true);
		userChatArea.setText("---------------");
		userChatArea.setFont(new Font("Monospaced", Font.BOLD, 13));
		userChatArea.setForeground(new Color(0, 0, 255));
		userChatArea.setEditable(false);
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
		this.add(showTopicsButton);
		this.add(informationLabel);
		this.add(chatCountLabel);
		this.add(chatCountNumberLabel);
		this.add(showUserInfoButton);
		this.add(mashButton);
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
		baseLayout.putConstraint(SpringLayout.WEST, showTopicsButton, 2, SpringLayout.EAST, chatBotPane);
		baseLayout.putConstraint(SpringLayout.WEST, informationLabel, 5, SpringLayout.EAST, chatBotPane);
		baseLayout.putConstraint(SpringLayout.SOUTH, informationLabel, 180, SpringLayout.NORTH, checkersLabel);
		baseLayout.putConstraint(SpringLayout.WEST, chatCountLabel, 0, SpringLayout.EAST, chatBotPane);
		baseLayout.putConstraint(SpringLayout.EAST, chatCountNumberLabel, 0, SpringLayout.WEST, userChatPane);
		baseLayout.putConstraint(SpringLayout.NORTH, chatCountLabel, 0, SpringLayout.NORTH, chatCountNumberLabel);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatCountNumberLabel, -6, SpringLayout.NORTH, InputTextField);
		baseLayout.putConstraint(SpringLayout.NORTH, showTopicsButton, 5, SpringLayout.SOUTH, informationLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, showUserInfoButton, 5, SpringLayout.SOUTH, showTopicsButton);
		baseLayout.putConstraint(SpringLayout.EAST, showUserInfoButton, -8, SpringLayout.EAST, showTopicsButton);
		baseLayout.putConstraint(SpringLayout.NORTH, mashButton, 6, SpringLayout.SOUTH, checkMemeButton);
		baseLayout.putConstraint(SpringLayout.WEST, mashButton, 6, SpringLayout.EAST, chatBotPane);
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

		mashButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent click)
			{
				if(ChatBotModel.mashChecker(InputTextField.getText()))
				{
					chatBotArea.setText(chatBotArea.getText() + "\n" + "\n" + ChatBotModel.mashingDetected(InputTextField.getText()));
				}
				else
				{
					chatBotArea.setText(chatBotArea.getText() + "\n" + "\n" + ChatBotModel.noMashingDetected(InputTextField.getText()));
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
		
		checkMemeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				if(ChatBotModel.memeChecker(InputTextField.getText()))
				{
					chatBotArea.setText(chatBotArea.getText() + "\n" + "\n" + "Wow, " + InputTextField.getText() + " is a meme. Wahoo!");
				}
				else
				{
					chatBotArea.setText(chatBotArea.getText() + "\n" + "\n" + "Do you like using memes? Because I didn't see you use one.");
				}
			}
		});
		
		showTopicsButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				chatBotArea.setText(chatBotArea.getText() + "\n" + "\n" + ChatBotModel.topicList);
			}
		});
		showUserInfoButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				chatBotArea.setText(chatBotArea.getText() + "\n" + "\n" + ChatBotModel.getKnownUserInformation());
			}
			
		});
	}

	/**
	 * This sets the user's name
	 * @param name
	 */
	public static void setUserName(String name)
	{
		userNameLabel.setText(name);
	}
	
	/**
	 * This updates the Chat Count
	 * @param chatCount
	 */
	public static void updateChatCount(int chatCount)
	{
		chatCountNumberLabel.setText(Integer.toString(chatCount));
	}
	
	/**
	 * This displays the users text
	 * @param userInput
	 */
	public void showTextMessage(String userInput)
	{
		userChatArea.append("\n" + "\n" + userInput);
	}
}
