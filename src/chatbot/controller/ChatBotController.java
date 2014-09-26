package chatbot.controller;

import javax.swing.JOptionPane;

import chatbot.model.ChatBotModel;
import chatbot.view.ChatBotView;

public class ChatBotController
{
	private ChatBotView applicationView;
	private ChatBotModel myChatBot;
	
	public ChatBotController()
	{
		applicationView = new ChatBotView(this);
		myChatBot = new ChatBotModel("Hans");
	}
	
	public void start()
	{
		String result = applicationView.showChatBotModel("Camron");
		
		
		
		if (myChatBot.quitChecker(result))
		{
			quit();
		}
	}
	
	private void quit()
	{
		JOptionPane.showMessageDialog(null, "goodbye cruel world");
		System.exit(0);
	}

}
