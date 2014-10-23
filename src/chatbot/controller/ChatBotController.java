package chatbot.controller;

import javax.swing.JOptionPane;

import chatbot.model.ChatBotModel;
import chatbot.view.ChatBotFrame;
import chatbot.view.ChatBotPanel;
import chatbot.view.ChatBotView;

/**
 * Runs the ChatBot Project. Owns the model and associated views.
 * @author Camron Heaps
 *@version 1.2 10/2/14
 */
public class ChatBotController
{
	private ChatBotView applicationView;
	private ChatBotModel myChatBot;
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
		
//		while(!myChatBot.quitChecker(result))
//		{
//			result = myChatBot.processText(result);
//			result = applicationView.showChatBotDialog(result);
//		}
//			quit();
	}
	
	private void quit()
	{
		applicationView.showChatBotMessage(quitMessage);
		System.exit(0);
	}

}
