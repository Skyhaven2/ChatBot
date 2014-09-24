package chatbot.view;

import javax.swing.JOptionPane;

import chatbot.controller.ChatBotController;

public class ChatBotView
{
	private ChatBotController baseController;
	
	public ChatBotView(ChatBotController baseController)
	{
		this.baseController = baseController;
	}
	
	public String showChatBotModel(String currentInput)
	{
		String result = "";
		JOptionPane.showMessageDialog(null, "Hello, " + currentInput);
		result = JOptionPane.showInputDialog(null, "are you done?");
		return result;
	}
	
}
