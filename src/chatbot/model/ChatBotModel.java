package chatbot.model;

public class ChatBotModel
{
	private String name;
	private int chatCount;

	/**
	 * Creates a Chatbot object with the supplied name and initializes the current number of chats to zero.
	 * @param name The supplied name for the Chatbot
	 */
	public ChatBotModel(String name)
	{
		this.name = name;
		chatCount = 0;
	}

	public String getName()
	{
		return name;
	}

	public int getChatCount()
	{
		return chatCount;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	private void updateChatCount()
	{
		chatCount++;
	}
	
	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;
		
		if(input.equalsIgnoreCase("exit"))
		{
			okToQuit = true;
		}
		
		return okToQuit;
	}
}
