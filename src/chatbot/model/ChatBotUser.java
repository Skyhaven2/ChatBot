package chatbot.model;

public class ChatBotUser
{
	private String userName;
	private int age;
	private boolean likesVideoGames;
	private boolean isMale;
	
	public ChatBotUser()
	{
		this.userName = "";
		this.age = 0;
		this.likesVideoGames = false;
		this.isMale = false;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public boolean isLikesVideoGames()
	{
		return likesVideoGames;
	}

	public void setLikesVideoGames(boolean likesVideoGames)
	{
		this.likesVideoGames = likesVideoGames;
	}

	public boolean isMale()
	{
		return isMale;
	}

	public void setMale(boolean isMale)
	{
		this.isMale = isMale;
	}
}
