package chatbot.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import chatbot.controller.ChatBotController;

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

	public ChatBotPanel(ChatBotController baseController)
	{
		this.baseController = baseController;

		InputButton = new JButton("Enter");
		InputTextField = new JTextField(45);
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.NORTH, InputButton, 0, SpringLayout.NORTH, InputTextField);
		baseLayout.putConstraint(SpringLayout.WEST, InputButton, 5, SpringLayout.EAST, InputTextField);
		baseLayout.putConstraint(SpringLayout.WEST, InputTextField, 20, SpringLayout.WEST, this);
		chatBotArea = new JTextArea(20, 15);
		chatBotPane = new JScrollPane(chatBotArea);
		baseLayout.putConstraint(SpringLayout.NORTH, InputTextField, 5, SpringLayout.SOUTH, chatBotPane);
		userChatArea = new JTextArea(20, 15);
		userChatPane = new JScrollPane(userChatArea);

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
	}

	/**
	 * Sets up the location for all of the objects.
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, chatBotPane, 20, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, InputTextField, 0, SpringLayout.EAST, chatBotPane);
		baseLayout.putConstraint(SpringLayout.WEST, chatBotPane, 220, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, userChatPane, 20, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, userChatPane, 20, SpringLayout.WEST, this);
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

}
