package chatbot.view;

import javax.swing.JFrame;

import chatbot.controller.ChatBotController;

public class ChatBotFrame extends JFrame
{
	private ChatBotPanel basePanel;

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
		this.setSize(415, 380);
		this.setResizable(false);
		setVisible(true);
	}

}
