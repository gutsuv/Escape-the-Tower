package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

//import Model.Text;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;

public class helpView
{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					helpView window = new helpView();
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
	public helpView()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();

		frame.setResizable(false);
		frame.setBounds(100, 100, 461, 428);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(6, 6, 449, 328);
		// frame.getContentPane().add(lblNewLabel);

		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.setVisible(false);
				GUI.main(null);
			}
		});
		
		
		
		btnMainMenu.setBounds(167, 346, 132, 42);
		frame.getContentPane().add(btnMainMenu);
		// lblNewLabel.setText(Text.help());

		TextArea textArea = new TextArea();
		textArea.setBounds(6, 32, 445, 302);
		frame.getContentPane().add(textArea);
		// textArea.setText(Text.help());
		textArea.setEditable(false);

		JLabel lblHelpMenu = new JLabel("Help menu");
		lblHelpMenu.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblHelpMenu.setBounds(179, 6, 91, 20);
		frame.getContentPane().add(lblHelpMenu);
	}
	
	
	
	
}
