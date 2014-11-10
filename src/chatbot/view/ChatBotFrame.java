package chatbot.view;

import javax.swing.JFrame;
import javax.swing.JRootPane;

import chatbot.controller.ChatBotController;

public class ChatBotFrame extends JFrame
{
	private ChatBotPanel basePanel;
	/**
	 * this is the constructor for ChatBotFrame
	 * @param baseController
	 */
	public ChatBotFrame(ChatBotController baseController)
	{
		basePanel = new ChatBotPanel(baseController);
		
		setupFrame();
	}

	/**
	 * Sets up Frame properties. The first thing it does is sets up the panel
	 * inside it by calling the ChatBotPanel method in ChatBotPanel Class.
	 */
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(370, 400);
		this.setResizable(false);
		setVisible(true);
	}

}
