
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI 
{
	private JFrame frame;
	//public static Floor f1;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					GUI window = new GUI();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 459, 369);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTextBasedGame = new JLabel("Tree House Adventure");
		lblTextBasedGame.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblTextBasedGame.setBounds(106, 38, 262, 43);
		frame.getContentPane().add(lblTextBasedGame);

		frame.setResizable(false);
		JButton btnNewButton = new JButton("New Game");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				try 
				{
					f1 = new Floor();
					f1.window.frame.setVisible(true);
					f1.main(null);
				} 
				catch (InterruptedException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
				
			}
		});
		btnNewButton.setBounds(149, 105, 147, 43);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		btnExit.setBounds(149, 270, 147, 43);
		frame.getContentPane().add(btnExit);
		
		JButton btnLoadgame = new JButton("Load Game");
		btnLoadgame.setBounds(149, 160, 147, 43);
		frame.getContentPane().add(btnLoadgame);
		
		JButton btnHelpMenu = new JButton("Help Menu");
		btnHelpMenu.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				helpView.main(null);
			}
		});
		btnHelpMenu.setBounds(149, 215, 147, 43);
		frame.getContentPane().add(btnHelpMenu);
	}

}








