package chatbot.controller;

import javax.swing.JOptionPane;

import chatbot.model.ChatBotModel;
import chatbot.view.ChatBotFrame;
import chatbot.view.ChatBotPanel;
import chatbot.view.ChatBotView;

/**
 * Runs the ChatBot Project. Owns the model and associated views.
 * 
 * @author Camron Heaps
 * @version 2.2 11/3/14
 */
public class ChatBotController
{
	/**
	 * This is the ChatBotView class.
	 */
	private ChatBotView applicationView;
	/**
	 * This is the ChatBotModel class
	 */
	public ChatBotModel myChatBot;
	/**
	 * This is the start message to be displayed.
	 */
	private String startMessage;
	/**
	 * This is the quit message to be displayed
	 */
	private String quitMessage;
	/**
	 * This is the ChatBotFrame class.
	 */
	private ChatBotFrame appFrame;
	/**
	 * This is the constructor for the controller.
	 */
	public ChatBotController()
	{
		applicationView = new ChatBotView(this);
		myChatBot = new ChatBotModel("Faron");
		startMessage = "Welcome to the " + myChatBot.getName() + " chatbot. What is your name?";
		quitMessage = "Goodbye cruel user :(";
		appFrame = new ChatBotFrame(this);
	}
	/**
	 * Gets the Chat Bot.
	 * @return Returns the current Chat Bot
	 */
	public ChatBotModel getMyChatBot()
	{
		return myChatBot;
	}

	/**
	 * This is the first method to be called.
	 */
	public void start()
	{
		String result = applicationView.showChatBotDialog(startMessage);
		ChatBotPanel.setUserName(result);
		myChatBot.setUserName(result);
		ChatBotPanel testPanel = (ChatBotPanel) appFrame.getContentPane();
	}
}
