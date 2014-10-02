package chatbot.view;

import javax.swing.JOptionPane;

import chatbot.controller.ChatBotController;
import chatbot.model.ChatBotModel;

public class ChatBotView
{
	private ChatBotController baseController;

	public ChatBotView(ChatBotController baseController)
	{
		this.baseController = baseController;
	}

	/**
	 * Shows a String from the ChatBot with the availability of user input.
	 * @param currentInput The supplied String.
	 * @return The users typed response.
	 */
	
	public String showChatBotDialog(String currentInput)
	{
		String result = "";

		result = JOptionPane.showInputDialog(null, baseController.getMyChatBot().getName() + " says: " + currentInput);
		
		return result;
	}
	
	/**
	 * Shows a String from the ChatBot as a popup window.
	 * @param currentInput The string from the ChatBot.
	 */
	public void showChatBotMessage(String currentInput)
	{
		JOptionPane.showMessageDialog(null, baseController.getMyChatBot().getName() + " says: " + currentInput);
	}

}
