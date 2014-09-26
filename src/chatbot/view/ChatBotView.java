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
		result = JOptionPane.showInputDialog(null, "What topic would you like to talk about? Options: Music");
		
		if (result.equalsIgnoreCase("music"))
		{
			result = JOptionPane.showInputDialog(null, "I like jazz. Do you like jazz?");
				if (result.equalsIgnoreCase("yes"))
				{
					JOptionPane.showMessageDialog(null, "Cool! We have that in common.");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Well, I won't hold that against you.");
				}
			
		}
		result = JOptionPane.showInputDialog(null, "are you done?");
		return result;
	}
	
}
