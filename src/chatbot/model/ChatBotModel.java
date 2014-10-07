package chatbot.model;

import java.util.ArrayList;

public class ChatBotModel
{
	private ArrayList<String> memeList;
	private String name;
	private int chatCount;

	/**
	 * Creates a ChatBot object with the supplied name and initializes the
	 * current number of chats to zero.
	 * 
	 * @param name
	 *            The supplied name for the ChatBot
	 */
	public ChatBotModel(String name)
	{
		memeList = new ArrayList<String>();
		this.name = name;
		chatCount = 0;
		fillTheMemeList();
	}

	/**
	 * This returns the supplied name for the ChatBot.
	 * 
	 * @return name
	 */
	public String getName()
	{
		return name;
	}

	private void fillTheMemeList()
	{
		memeList.add("music");
		memeList.add("Final Fantasy");
		memeList.add("cool beans");
		memeList.add("Marching Band");
		memeList.add("*slap*");
		memeList.add("doge");
	}

	/**
	 * This returns the current number of chats.
	 * 
	 * @return chatCount
	 */
	public int getChatCount()
	{
		return chatCount;
	}

	/**
	 * This sets the name of the ChatBot to the parameter.
	 * 
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
	 * Processes input from the user against the checker methods. Returns the
	 * next output for the view.
	 * 
	 * @param currentInput
	 *            The supplied text.
	 * @return The processed text based on checker or other methods.
	 */
	public String processText(String currentInput)
	{
		String result = "";

		if (stringChecker(currentInput))
		{
			result = "Woah, you talk too fast!";
		}
		else
		{

			if (memeChecker(currentInput))
			{
				result = "wow, " + currentInput + " is a meme. Wahoo!";
			}
			else
			{
				result = "not a meme, try again";
			}
		}
		
		return result;
	}

	/**
	 * This checks if the user wants to exit. It happens when the user types
	 * "quit".
	 * 
	 * @param input
	 * @return okToQuit
	 */
	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;

		if (input != null && input.equalsIgnoreCase("quit"))
		{
			okToQuit = true;
		}

		return okToQuit;
	}

	private boolean memeChecker(String input)
	{
		boolean isAMeme = false;

		for (String currentMeme : memeList)
		{
			if (input.equalsIgnoreCase(currentMeme))
			{
				isAMeme = true;
			}
		}

		for (int loopCounter = 0; loopCounter < memeList.size(); loopCounter++)
		{
			if (input.equalsIgnoreCase(memeList.get(loopCounter)))
			{
				isAMeme = true;
			}
		}

		return isAMeme;
	}

	private boolean stringChecker(String input)
	{
		boolean isVeryLong = false;
		int length = input.length();
		if (length > 30)
		{
			isVeryLong = true;
		}

		return isVeryLong;
	}
	
	//.contatins looks for that string exactly
	private String contentChecker(String input)
	{
		String topic = "";
		if(input.contains("Hey"))
		{
			topic = "Hey";
		}
		return topic;
	}
}
