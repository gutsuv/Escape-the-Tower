package View;

import java.util.concurrent.TimeUnit;

import Model.Text;

public class playGame {
	public static void main(String [] a) throws InterruptedException
	{
		
		while(Floor.frame==null || !Floor.frame.isVisible())
		{
			
		}
	TimeUnit.SECONDS.sleep(3);
	
		Floor.textPane.setText(Floor.textPane.getText()+"\n"+Text.printBackgroundStory(Floor.nickName,Floor.gender));
	}

}
