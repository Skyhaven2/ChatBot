package chatbot.model;

import java.util.ArrayList;

public class ChatBotModel
{
	private ArrayList<String> memeList;
	private String name;
	private int chatCount;

	/**
	 * Creates a Chatbot object with the supplied name and initializes the current number of chats to zero.
	 * @param name The supplied name for the ChatBot
	 */
	public ChatBotModel(String name)
	{
		this.name = name;
		chatCount = 0;
	}

	/**
	 * This returns the supplied name for the ChatBot.
	 * @return name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * This returns the current number of chats.
	 * @return chatCount
	 */
	public int getChatCount()
	{
		return chatCount;
	}

	/**
	 * This sets the name of the ChatBot to the parameter.
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * This adds one to the ChatCount.
	 */
	private void updateChatCount()
	{
		chatCount++;
	}
	
	/**
	 * This checks if the user wants to exit. It happens when the user types "quit".
	 * @param input
	 * @return okToQuit
	 */
	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;
		
		if(input != null && input.equalsIgnoreCase("exit"))
		{
			okToQuit = true;
		}
		
		return okToQuit;
	}
	
	private boolean memeChecker(String currentString)
	{
		boolean isAMeme = false;
		return isAMeme;
	}
}
