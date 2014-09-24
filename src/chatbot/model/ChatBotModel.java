package chatbot.model;

public class ChatBotModel
{
	private String name;
	private int chatCount;

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
}
