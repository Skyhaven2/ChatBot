package chatbot.model;

public class ChatBotUser
{
	/**
	 * This is the name of the user
	 */
	private String userName;
	/**
	 * This is the age of the user
	 */
	private int age;
	/**
	 * This is if the user likes Video Games
	 */
	private boolean likesVideoGames;
	/**
	 * This is if the user is male
	 */
	private boolean isMale;
	
	/**
	 * This is the constructor for the ChatBotUser
	 */
	public ChatBotUser()
	{
		this.userName = "";
		this.age = 0;
		this.likesVideoGames = false;
		this.isMale = false;
	}

	/**
	 * This gets the Username
	 * @return The user's name
	 */
	public String getUserName()
	{
		return userName;
	}

	/**
	 * This sets the users name
	 * @param userName The name of the user
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	/**
	 * This gets the age of the user
	 * @return the age of the user
	 */
	public int getAge()
	{
		return age;
	}

	/**
	 * This sets the age of the user
	 * @param age the age of the user
	 */
	public void setAge(int age)
	{
		this.age = age;
	}

	/**
	 * This gets the boolean likesVideoGames
	 * @return likesVideoGames
	 */
	public boolean getLikesVideoGames()
	{
		return likesVideoGames;
	}

	/**
	 * This sets the boolean likesVideoGames
	 * @return likesVideoGames
	 */
	public void setLikesVideoGames(boolean likesVideoGames)
	{
		this.likesVideoGames = likesVideoGames;
	}
	
	/**
	 * This gets the boolean isMale
	 * @return isMale
	 */
	public boolean getIsMale()
	{
		return isMale;
	}

	/**
	 * This sets the boolean isMale
	 * @return isMale
	 */
	public void setIsMale(boolean isMale)
	{
		this.isMale = isMale;
	}
}
