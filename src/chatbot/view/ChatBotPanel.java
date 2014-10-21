package chatbot.view;

import javax.swing.JPanel;

import chatbot.controller.ChatBotController;

public class ChatBotPanel extends JPanel
{
	private ChatBotController baseController;

	public ChatBotPanel(ChatBotController baseController)
	{
		this.baseController = baseController;
	}

}
