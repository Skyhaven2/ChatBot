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
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(600, 400);
		this.setResizable(false);
		setVisible(true);
	}

}
