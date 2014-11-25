package chatbot.model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import chatbot.view.ChatBotPanel;
import chatbot.view.ChatBotView;

public class ChatBotModel
{
	/**
	 * This is whether the ChatBot knows if the user likes video games or not.
	 */
	private static boolean knowsLikesVideoGames = false;
	/**
	 * This is whether the ChatBot knows if the user is male or not.
	 */
	private static boolean knowsIsMale = false;
	/**
	 * This contains all of the memes.
	 */
	private static ArrayList<String> memeList;
	/**
	 * This contains all of the possible topics that ChatBot can discuss.
	 */
	public static ArrayList<String> topicList;
	/**
	 * This is the ChatBot's name.
	 */
	private String name;
	/**
	 * This is the number chats the user has input.
	 */
	private int chatCount;
	/**
	 * This is the position inside a topic that the chatBot is on.
	 */
	private int talkPostion = 0;
	/**
	 * False means the chatBot will find a new topic. True means the chatBot is
	 * currently talking about one topic.
	 */
	private boolean isStillDiscussing = false;
	/**
	 * This topic currently being discussed.
	 */
	private String topic = "";
	/**
	 * The current user.
	 */
	private static ChatBotUser myUser;
	/**
	 * This is the ChatBotPanel class
	 */
	private ChatBotPanel myPanel;
	private ChatBotView applicationView;

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
		topicList = new ArrayList<String>();
		this.name = name;
		chatCount = 0;
		myUser = new ChatBotUser();
		fillTheMemeList();
		fillTheTopicList();
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

	/**
	 * Get the information stored about the user.
	 * 
	 * @return The user info
	 */
	public ChatBotUser getMyUser()
	{
		return myUser;
	}

	/**
	 * This sets what the user is.
	 * 
	 * @param myUser
	 *            The user
	 */
	public void setMyUser(ChatBotUser myUser)
	{
		this.myUser = myUser;
	}

	/**
	 * This fills the Meme list with memes.
	 */
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
	 * This fills the Topic list with topics.
	 */
	private void fillTheTopicList()
	{
		topicList.add("Final Fantasy");
		topicList.add("Minecraft");
		topicList.add("Colors");
		topicList.add("Music");
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
		ChatBotPanel.updateChatCount(chatCount);
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

		if (currentInput != null)
		{
			if (!isStillDiscussing)
			{
				result = setTopic(currentInput);
			}
			else if (isStillDiscussing)
			{
				result = findTopic(currentInput);
			}
		}
		updateChatCount();

		return result;
	}

	/**
	 * This sets the topic according to the user input and returns the first
	 * response.
	 * 
	 * @param currentInput
	 *            The current input of the user.
	 * @return The ChatBot response
	 */
	private String setTopic(String currentInput)
	{
		String result = "";
		int randomPosition = (int) (Math.random() * 2);

		if (contentChecker(currentInput))
		{
			if (topic.equalsIgnoreCase("Final Fantasy"))
			{
				result = "I love Final Fantasy! Who is your favorite character?";
				isStillDiscussing = true;
			}
			else if (topic.equalsIgnoreCase("Minecraft"))
			{
				result = "Minecraft is a fun game. What is your favorite mob.";
				isStillDiscussing = true;
			}
			else if (topic.equalsIgnoreCase("Colors"))
			{
				result = "Oh, you want to talk about colors? Ok, what is your favorite color?";
				isStillDiscussing = true;
			}
			else if (topic.equalsIgnoreCase("Music"))
			{
				result = "I love talking about music. What is your favorite genre?";
				isStillDiscussing = true;
			}
		}
		else if (randomPosition == 0)
		{
			result = "Lets talk about you! What is your age?";
			topic = "you";
			isStillDiscussing = true;
		}
		else
		{
			result = "I don't want to talk about that...";
		}

		return result;
	}

	/**
	 * Finds the topic the ChatBot is talking about and sends the current input
	 * to that topic.
	 * 
	 * @param currentInput
	 *            The input of the user.
	 * @return The response of the ChatBot.
	 */
	private String findTopic(String currentInput)
	{
		String result = "";
		if (topic.equalsIgnoreCase("Final Fantasy"))
		{
			result = topicFinalFantasy(currentInput);
		}
		else if (topic.equalsIgnoreCase("Minecraft"))
		{
			result = topicMinecraft(currentInput);
		}
		else if (topic.equalsIgnoreCase("Colors"))
		{
			result = topicColors(currentInput);
		}
		else if (topic.equalsIgnoreCase("you"))
		{
			result = topicUser(currentInput);
		}
		else if (topic.equalsIgnoreCase("Music"))
		{
			result = topicMusic(currentInput);
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
	public static boolean memeChecker(String input)
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
	public static boolean stringChecker(String input)
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
		else if (input.contains("Colors"))
		{
			topic = "Colors";
			hasContent = true;
		}
		else if (input.contains("Music"))
		{
			topic = "Music";
			hasContent = true;
		}
		return hasContent;
	}

	/**
	 * This method returns responses for the Final Fantasy topic.
	 * 
	 * @param currentInput
	 *            The input the user typed in
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
					result = "Ragnarok has a lot of nice vocal parts.";
				}
				else if (currentInput.contains("Dreadnoughts"))
				{
					result = "March of the Dreadnoughts is a fun upbeat song.";
				}
				else if (currentInput.contains("Prelude"))
				{
					result = "This song made me so excited to play the game.";
				}
				else if (currentInput.contains("Lightning's"))
				{
					result = "This song is epic but also sad.";
				}
				else
				{
					result = "That song is ok but I like others better.";
				}
				result = result + " What do you want to talk about now?";
				talkPostion = 0;
				isStillDiscussing = false;
			}
			else
			{
				talkPostion = 0;
				isStillDiscussing = false;
				result = "I don't want to talk about " + topic + " anymore.";
				result = result + " What do you want to talk about now?";
			}
		}

		return result;
	}

	/**
	 * This method returns responses for the Minecraft topic.
	 * 
	 * @param currentInput
	 *            The input the user typed in
	 * @return The message to be displayed
	 */
	private String topicMinecraft(String currentInput)
	{
		String result = "";
		if (talkPostion == 0)
		{
			if (currentInput.contains("Creeper") || currentInput.contains("creeper"))
			{
				result = "Really? I think these guys are super annoying. Have you built anything cool on Minecraft?";
			}
			else if (currentInput.contains("Ender") || currentInput.contains("ender"))
			{
				result = "Yeah, that guy can be tough. What have you built on Minecraft?";
			}
			else if (currentInput.contains("Ghast") || currentInput.contains("ghast"))
			{
				result = "If you don't have cobble, this guy can make traveling the Nether hard. Have you built anything cool on Minecraft?";
			}
			else
			{
				result = "That mob isn't very noteworthy. What have you built on Minecraft?";
			}
			talkPostion = 1;
		}
		else if (talkPostion == 1)
		{
			result = "If I could see. I might know if that was cool looking or not.";
			result = result + " What do you want to talk about now?";
			talkPostion = 0;
			isStillDiscussing = false;
		}
		else
		{
			talkPostion = 0;
			isStillDiscussing = false;
			result = "I don't want to talk about " + topic + " anymore.";
			result = result + " What do you want to talk about now?";
		}
		return result;
	}

	/**
	 * This method returns responses for the colors topic.
	 * 
	 * @param currentInput
	 *            The input the user typed in
	 * @return The message to be displayed.
	 */
	private String topicColors(String currentInput)
	{
		String result = "";
		if (talkPostion == 0)
		{
			if (currentInput.contains("Blue"))
			{
				result = "That is my favorite color.";
			}
			else
			{
				result = "That is not my favorite color.";
			}
			result = result + " What do you want to talk about now?";
			isStillDiscussing = false;
			talkPostion = 0;
		}
		else
		{
			result = "I don't want to talk about " + topic + " anymore.";
			result = result + " What do you want to talk about now?";
			isStillDiscussing = false;
			talkPostion = 0;

		}

		return result;
	}

	/**
	 * This method returns responses for the user topic.
	 * 
	 * @param currentInput
	 *            The user's current input.
	 * @return The ChatBot's response.
	 */
	private String topicUser(String currentInput)
	{
		String result = "";
		if (talkPostion == 0)
		{
			try
			{
				int currentAge = Integer.parseInt(currentInput);
				myUser.setAge(currentAge);
				result = "Do you like video games?";
				talkPostion = 1;
			}
			catch(NumberFormatException currentError)
			{
				JOptionPane.showMessageDialog(null, "Please type a numerical value.");
			}
		}
		else if (talkPostion == 1)
		{
			if ((currentInput.contains("yes")) || (currentInput.contains("Yes")))
			{
				myUser.setLikesVideoGames(true);
				knowsLikesVideoGames = true;
			}
			else
			{
				myUser.setLikesVideoGames(false);
				knowsLikesVideoGames = true;
			}
			result = "Just so you know, I like video games. Are you Male or Female?";
			talkPostion = 2;
		}
		else if (talkPostion == 2)
		{
			if ((currentInput.contains("female")) || (currentInput.contains("Female")))
			{
				myUser.setIsMale(false);
				knowsIsMale = true;
			}
			else if ((currentInput.contains("male")) || (currentInput.contains("Male")))
			{
				myUser.setIsMale(true);
				knowsIsMale = true;
			}
			result = "I liked learning about you.";
			result = result + " What do you want to talk about now?";
			isStillDiscussing = false;
			talkPostion = 0;
		}
		else
		{
			result = "I don't want to talk about " + topic + " anymore.";
			result = result + " What do you want to talk about now?";
			isStillDiscussing = false;
			talkPostion = 0;
		}
		return result;
	}

	/**
	 * This method returns responses for the music topic
	 * 
	 * @param currentInput
	 * @return
	 */
	private String topicMusic(String currentInput)
	{
		String result = "";
		if (talkPostion == 0)
		{
			if (currentInput.contains(""))
			{
				result = "You typed nothing";
			}
			else
			{
				result = "hi";
			}
			result = result + " What do you want to talk about now?";
			isStillDiscussing = false;
			talkPostion = 0;
		}
		else
		{
			result = "I don't want to talk about " + topic + " anymore.";
			result = result + " What do you want to talk about now?";
			isStillDiscussing = false;
			talkPostion = 0;

		}

		return result;
	}

	/**
	 * This sets the name of the user.
	 * 
	 * @param userName
	 *            The name of the user.
	 */
	public void setUserName(String userName)
	{
		myUser.setUserName(userName);
	}

	/**
	 * This collects all of the information the ChatBot knows about the user.
	 * 
	 * @return A string containing the information.
	 */
	public static String getKnownUserInformation()
	{
		String userInformation = "";
		userInformation = ("Name: " + myUser.getUserName());
		if (myUser.getAge() >= 1)
		{
			userInformation = userInformation + "\n" + "Age: " + myUser.getAge();
		}
		if (knowsIsMale)
		{
			if (myUser.getIsMale())
			{
				userInformation = userInformation + "\n" + "Gender: Male";
			}
			else
			{
				userInformation = userInformation + "\n" + "Gender: Female";
			}
		}
		if (knowsLikesVideoGames)
		{
			if (myUser.getLikesVideoGames())
			{
				userInformation = userInformation + "\n" + "Likes video games";
			}
			else
			{
				userInformation = userInformation + "\n" + "Doesn't like video games";
			}
		}
		return userInformation;
	}
	
	public static String noMashingDetected(String currentInput)
	{
		String noMashing = "Thank you for not mashing your keyboard with ";
		if (currentInput.length() > 1)
		{
			noMashing += currentInput.substring(currentInput.length() / 3, currentInput.length() / 2);
		}
		return noMashing;
	}
	
	public static boolean mashChecker(String userInput)
	{
		boolean isMashing = false;
		
		if (userInput.indexOf("sdf") > -1)
		{
			isMashing = true;
		}
		
		return isMashing;
	}
}
