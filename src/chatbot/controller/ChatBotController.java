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
	private ChatBotView applicationView;
	public ChatBotModel myChatBot;
	private String startMessage;
	private String quitMessage;
	private ChatBotFrame appFrame;

	public ChatBotController()
	{
		applicationView = new ChatBotView(this);
		myChatBot = new ChatBotModel("Faron");
		startMessage = "Welcome to the " + myChatBot.getName() + " chatbot. What is your name?";
		quitMessage = "Goodbye cruel user :(";
		appFrame = new ChatBotFrame(this);
	}

	public ChatBotModel getMyChatBot()
	{
		return myChatBot;
	}

	public void start()
	{
		String result = applicationView.showChatBotDialog(startMessage);
		ChatBotPanel.setUserName(result);
		ChatBotPanel testPanel = (ChatBotPanel) appFrame.getContentPane();
	}
}
