package chatbot.controller;

/**
 * The runner for the Chatbot.
 * @author Camron Heaps
 * @version 10/1/14
 */
public class ChatBotRunner
{
	/**
	 * Starting ponit for all Java programs.
	 * @param args Unused!
	 */
	public static void main(String[] args)
	{
		ChatBotController appController = new ChatBotController();
		appController.start();
	}

}
