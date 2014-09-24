package chatbot.controller;

import javax.swing.JOptionPane;

import chatbot.view.ChatBotView;

public class ChatBotController
{
	private ChatBotView applicationView;
	
	public ChatBotController()
	{
		applicationView = new ChatBotView(this);
	}
	
	public void start()
	{
		String result = applicationView.showChatBotModel("Steve");
		
		if (result.equalsIgnoreCase("exit"))
		{
			quit();
		}
	}
	
	private void quit()
	{
		JOptionPane.showMessageDialog(null, "good bye cruel world");
		System.exit(0);
	}

}
