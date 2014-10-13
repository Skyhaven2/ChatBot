package chatbot.model;

import java.util.ArrayList;

public class ChatBotModel
{
	private ArrayList<String> memeList;
	private String name;
	private int chatCount;
	private int talkPostion = 0;
	private boolean isStillDiscussing = false;
	private String topic = "";

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
		memeList.add("I had fun once, it was awful.");
		memeList.add("ROFL");
		memeList.add("cool beans");
		memeList.add("sax appeal");
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
		int randomPosition = (int) (Math.random() * 4);
		if (currentInput != null)
		{
			if (!isStillDiscussing)
			{
				if (randomPosition == 0)
				{
					if (stringChecker(currentInput))
					{
						result = "Woah, you talk to fast!";
					}

					else
					{
						result = "You are talking so sloooow.";
					}
				}
				else if (randomPosition == 1 || randomPosition == 3)
				{
					if (contentChecker(currentInput))
					{
						if (topic.equalsIgnoreCase("Final Fantasy"))
						{
							result = "Cool, I love Final Fantasy! Who is your favorite character?";
							isStillDiscussing = true;
						}
					}
					else
					{
						result = "I don't want to talk about that...";
					}
				}
				else
				{
					if (memeChecker(currentInput))
					{
						result = "Wow, " + currentInput + " is a meme. Wahoo!";
					}
					else
					{
						result = "Do you like using memes? Because I didn't see you use one.";
					}
				}
			}
			else
			{
				if (topic.equalsIgnoreCase("Final Fantasy"))
				{
					result = topicFinalFantasy(currentInput);
				}
				else if (topic.equalsIgnoreCase("Minecraft"))
				{
					result = topicMinecraft(currentInput);
				}
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

		if ((input != null && input.equalsIgnoreCase("quit")) || (input != null && input.equalsIgnoreCase("exit")))
		{
			okToQuit = true;
		}

		return okToQuit;
	}

	/**
	 * This checks to see if the string input is a meme.
	 * 
	 * @param input
	 *            the string input
	 * @return Returns true if it is a meme.
	 */
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

	/**
	 * Checks to see if the string is longer than 30 Characters
	 * 
	 * @param input
	 *            The current input string.
	 * @return Returns true or false
	 */
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

	/**
	 * Checks to see if a word appears somewhere in string. It must be separated
	 * by spaces.
	 * 
	 * @param input
	 *            The current input string
	 * @return Returns true or false
	 */
	private boolean contentChecker(String input)
	{
		boolean hasContent = false;
		if (input.contains("Final Fantasy"))
		{
			topic = "Final Fantasy";
			hasContent = true;
		}
		else if (input.contains("Minecraft"))
		{
			topic = "Minecraft";
			hasContent = true;
		}
		return hasContent;
	}

	/**
	 * This method returns responses for the Final Fantasy topic.
	 * @param currentInput The input the user typed in
	 * @return The message to be displayed
	 */
	private String topicFinalFantasy(String currentInput)
	{
		String result = "";
		if (topic.equalsIgnoreCase("Final Fantasy"))
		{
			if (talkPostion == 0)
			{
				if (currentInput.contains("Hope"))
				{
					result = "He is my favorite character. What is your favorite area in FFXIII?";
				}
				else if (currentInput.contains("Lightning"))
				{
					result = "She is my second favorite character. What is your favorite area in FFXIII?";
				}
				else if (currentInput.contains("Sazh"))
				{
					result = "I love Sazh! He is so cool. What is your favorite area in FFXIII?";
				}
				else
				{
					result = "That is not one of my favorite characters. What is your favorite area in FFXIII?";
				}
				talkPostion = 1;
			}
			else if (talkPostion == 1)
			{
				if (currentInput.contains("Oerba"))
				{
					result = "Oerba is a cool place. I like the music in that area. What is your favorite FFXIII song?";
				}
				else if (currentInput.contains("Nautilus"))
				{
					result = "I think Nautilus would be a cool place to visit. What is your favorite FFXIII song?";
				}
				else if (currentInput.contains("Grapa"))
				{
					result = "The Grapa Whitewood is very pretty. What is your favorite FFXIII song?";
				}
				else if (currentInput.contains("Palumpolum"))
				{
					result = "I like Palumpolum but I wouldn't want to live their. What is your favorite FFXIII song?";
				}
				else
				{
					result = "That place is ok but I like others better. What is your favorite FFXIII song?";
				}
				talkPostion = 2;
			}
			else if (talkPostion == 2)
			{
				if (currentInput.contains("Ragnarok"))
				{
					result = "Ragnarok has a lot of nice vocal parts. I don't want to talk about " + topic + " anymore.";
				}
				else if (currentInput.contains("Dreadnoughts"))
				{
					result = "March of the Dreadnoughts is a fun upbeat song. I don't want to talk about " + topic + " anymore";
				}
				else if (currentInput.contains("Prelude"))
				{
					result = "This song made me so excited to play the game. I don't want to talk about " + topic + " anymore";
				}
				else if (currentInput.contains("Lightning's"))
				{
					result = "This song is epic but also sad. I don't want to talk about " + topic + " anymore";
				}
				else
				{
					result = "That song is ok but I like others better. I don't want to talk about " + topic + " anymore";
				}
				talkPostion = 0;
				isStillDiscussing = false;
			}
			else
			{
				talkPostion = 0;
				isStillDiscussing = false;
				result = "I don't want to talk about " + topic + " anymore.";
			}
		}

		return result;
	}
	
	private String topicMinecraft(String currentInput)
	{
		String result = "";
		if (talkPostion == 0)
		{
			
		}
		else
		{
			talkPostion = 0;
			isStillDiscussing = false;
			result = "I don't want to talk about " + topic + " anymore";
		}
		return result;
	}
}
