
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Floor
{
	static JFrame frame;
	private JButton btnNewButton;
	private String name;
	private JLabel lblP;
	private ImagePanel panel_2;
	public static JComboBox comboBox;
	static String gender;
	static String nickName;
	static public TextArea textPane;
	public static int next = 0;
	public static Floor window;

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
					window = new Floor();
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
	 * 
	 * @throws InterruptedException
	 */
	public Floor() throws InterruptedException
	{
		initialize();
	}

	public static void startStory() throws InterruptedException
	{

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		name = "aaa";
		name = JOptionPane.showInputDialog(frame, "Kindly Enter Your Name Please");

		while (name == null || name.length() == 0)
		{
			name = JOptionPane.showInputDialog("Err, no name entered. Kindly Enter Your Name Please");
		}
		
		Controller.eInstance().setPlayerGender(gender);

		Controller.eInstance().setPlayerName(name);
		JOptionPane.showMessageDialog(frame,
				"Nice to finally meet the cold blooded warrior " + name + ", lets Get Started");
		frame = new JFrame();
		frame.setBounds(100, 100, 834, 532);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setLayout(null);

		btnNewButton = new JButton("Name: " + name);
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(6, 3, 150, 38);
		
		frame.getContentPane().add(btnNewButton);

		JButton button = new JButton("HIT POINTS: 0");
		button.setForeground(Color.DARK_GRAY);
		button.setEnabled(false);
		button.setBackground(Color.WHITE);
		button.setBounds(162, 3, 150, 38);
		
		frame.getContentPane().add(button);

		JButton button2 = new JButton("Health: " + Controller.eInstance().getPlayer().getHealthPoints());
		button2.setForeground(Color.DARK_GRAY);
		button2.setEnabled(false);
		button2.setBackground(Color.WHITE);
		button2.setBounds(318, 3, 150, 38);
		
		frame.getContentPane().add(button2);

		JButton button3 = new JButton("Attack: " + Controller.eInstance().getPlayer().getAttackPoints() + "\n Defence: "
				+ Controller.eInstance().getPlayer().getDefencePoints());
		button3.setForeground(Color.DARK_GRAY);
		button3.setEnabled(false);
		button3.setBackground(Color.WHITE);
		button3.setBounds(474, 3, 200, 38);
		
		frame.getContentPane().add(button3);

		JButton button4 = new JButton("Help");
		button4.setForeground(Color.DARK_GRAY);
		// button4.setEnabled(false);
		button4.setBackground(Color.WHITE);
		button4.setBounds(10, 40, 40, 20);
		
		frame.getContentPane().add(button4);
		
		// JButton button5 = new JButton("Inventory");
		// button5.setForeground(Color.DARK_GRAY);
		// //button5.setEnabled(false);
		// button5.setBackground(Color.WHITE);
		// button5.setBounds(60, 40, 100, 20);
		// frame.getContentPane().add(button5);

		JButton btnMenu = new JButton("MENU");
		btnMenu.setForeground(Color.GRAY);
		btnMenu.setBounds(711, 6, 117, 29);
		
		frame.getContentPane().add(btnMenu);
		frame.setResizable(false);
		
		JButton btnMap = new JButton("MAP");
		btnMap.setForeground(Color.DARK_GRAY);
		btnMap.setEnabled(false);
		btnMap.setBackground(Color.WHITE);
		btnMap.setBounds(400, 36, 420, 29);
		
		frame.getContentPane().add(btnMap);

		Panel panel = new Panel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(6, 63, 370, 441);
		
		frame.getContentPane().add(panel);
		
		panel.setLayout(null);

		comboBox = new JComboBox();
		comboBox.setBounds(6, 28, 334, 27);
		panel.add(comboBox);
		
		comboBox.setEditable(true);
		JButton btnNewButton_1 = new JButton("Perform");
		
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textPane.setColumns(20);

				String selectedItem = (String) comboBox.getSelectedItem();
				
				if (selectedItem.equalsIgnoreCase("look"))
				{
					String resp = Controller.eInstance().getFloor(Controller.eInstance().getOnFloor())
							.getRoom(Controller.eInstance().getInRoom()).toString();
					textPane.setText("" + textPane.getText() + resp);
				} 
				
				else if (selectedItem.contains("Go to"))
				{
					ArrayList<String> nRooms = Controller.eInstance().getFloor(Controller.eInstance().getOnFloor())
							.getRoom(Controller.eInstance().getInRoom()).getNeigbourRooms();
					for (String nr : nRooms)
					{
						if (Controller.eInstance().getOnFloor() == 6)
						{
							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("cell block".toLowerCase()))
							{
								String resp = "Moving to " + nr.toLowerCase() + "\n";
								textPane.setText(textPane.getText() + "\n\n" + resp);
								lblP.setBounds(70, 150, 61, 16);
								Controller.eInstance().setInRoom(3);

								break;
							}
							
							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("cell # 1".toLowerCase()))
							{
								String resp = "Moving to " + nr.toLowerCase() + "\n";
								textPane.setText(textPane.getText() + "\n\n" + resp);
								lblP.setBounds(40, 54, 61, 16);
								;
								Controller.eInstance().setInRoom(3);

								break;
							}
							
							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("cell # 2".toLowerCase()))
							{
								String resp = "Moving to " + nr.toLowerCase() + "\n";
								textPane.setText(textPane.getText() + "\n\n" + resp);
								lblP.setBounds(150, 250, 61, 16);
								;
								Controller.eInstance().setInRoom(2);

								break;
							}

							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("torture room".toLowerCase()))
							{
								String resp = "Moving to " + nr.toLowerCase() + "\n";
								textPane.setText(textPane.getText() + "\n\n" + resp);
								lblP.setBounds(250, 200, 61, 16);
								;
								Controller.eInstance().setInRoom(4);

								break;
							}
							
							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("hallway".toLowerCase()))
							{
								String resp = "Moving to " + nr.toLowerCase() + "\n";
								textPane.setText(textPane.getText() + "\n\n" + resp);
								lblP.setBounds(250, 350, 61, 16);
								;
								Controller.eInstance().setInRoom(5);

								break;
							}
							
							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("staircase".toLowerCase()))
							{
								String resp = "Moving to " + nr.toLowerCase() + "\n";
								textPane.setText(textPane.getText() + "\n\n" + resp);
								lblP.setBounds(250, 350, 61, 16);
								;
								Controller.eInstance().setInRoom(6);
								Controller.eInstance().setOnFloor(5);
								
								
								panel_2.hide();
								panel_2 = new ImagePanel(new ImageIcon("_f5.png").getImage());
								panel_2.setBackground(Color.WHITE);
								panel_2.setBounds(379, 63, 449, 441);
								
								
								frame.getContentPane().add(panel_2);
								
								
								lblP = new JLabel("");
								lblP.setForeground(Color.YELLOW);
								lblP.setBounds(250, 350, 61, 16);
								
								
								
								panel_2.add(lblP);
								
								if (name.length() > 3)
								{
									lblP.setText(name.substring(0, 3));
								} 
								
								else
								{
									lblP.setText(name);
								}
								
								break;
							}
							
						} 
						
						
						
						
						else if (Controller.eInstance().getOnFloor() == 5)
						{
							// lblP.setBounds(250, 350, 61, 16);

							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("cell block".toLowerCase()))
							{
								String resp = "Moving to " + nr.toLowerCase() + "\n";
								textPane.setText(textPane.getText() + "\n\n" + resp);
								lblP.setBounds(250, 350, 61, 16);
								;
								Controller.eInstance().setInRoom(6);

								break;
							}
							
							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("cell 3".toLowerCase()))
							{
								String resp = "Moving to " + nr.toLowerCase() + "\n";
								textPane.setText(textPane.getText() + "\n\n" + resp);
								lblP.setBounds(60, 300, 61, 16);
								Controller.eInstance().setInRoom(7);

								break;
							}
							
							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("cell 4".toLowerCase()))
							{
								String resp = "Moving to " + nr.toLowerCase() + "\n";
								textPane.setText(textPane.getText() + "\n\n" + resp);
								lblP.setBounds(140, 300, 61, 16);
								;
								Controller.eInstance().setInRoom(8);

								break;
							}

							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("kennel".toLowerCase()))
							{
								String resp = "Moving to " + nr.toLowerCase() + "\n";
								textPane.setText(textPane.getText() + "\n\n" + resp);
								lblP.setBounds(380, 350, 61, 16);
								;
								Controller.eInstance().setInRoom(9);

								break;
							}

							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("guard room".toLowerCase()))
							{
								String resp = "Moving to " + nr.toLowerCase() + "\n";
								textPane.setText(textPane.getText() + "\n\n" + resp);
								lblP.setBounds(120, 150, 61, 16);
								Controller.eInstance().setInRoom(10);

								break;
							}

							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("storage".toLowerCase()))
							{
								String resp = "Moving to " + nr.toLowerCase() + "\n";
								textPane.setText(textPane.getText() + "\n\n" + resp);
								lblP.setBounds(380, 200, 61, 16);
								;
								Controller.eInstance().setInRoom(11);

								break;
							}

							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("staircase".toLowerCase()))
							{
								if (Controller.eInstance().getInRoom() == 10)
								{
									String resp = "Moving to " + nr.toLowerCase() + "\n";
									textPane.setText(textPane.getText() + "\n\n" + resp);
									lblP.setBounds(250, 350, 61, 16);
									;
									Controller.eInstance().setInRoom(12);
									Controller.eInstance().setOnFloor(4);
									
									
									panel_2.hide();
									panel_2 = new ImagePanel(new ImageIcon("_f4.png").getImage());
									panel_2.setBackground(Color.WHITE);
									panel_2.setBounds(379, 63, 449, 441);
									
									
									frame.getContentPane().add(panel_2);

									lblP = new JLabel("");
									lblP.setForeground(Color.YELLOW);
									lblP.setBounds(40, 54, 61, 16);
									
									
									panel_2.add(lblP);
									
									if (name.length() > 3)
									{
										lblP.setText(name.substring(0, 3));
									} 
									else
									{
										lblP.setText(name);
									}
									
									break;
								} 
								
								else
								{
									String resp = "Moving to " + nr.toLowerCase() + "\n";
									textPane.setText(textPane.getText() + "\n\n" + resp);
									lblP.setBounds(250, 350, 61, 16);
									;
									Controller.eInstance().setInRoom(5);
									Controller.eInstance().setOnFloor(6);
									
									
									panel_2.hide();
									panel_2 = new ImagePanel(new ImageIcon("_f6.png").getImage());
									panel_2.setBackground(Color.WHITE);
									panel_2.setBounds(379, 63, 449, 441);
									
									
									frame.getContentPane().add(panel_2);

									lblP = new JLabel("");
									lblP.setForeground(Color.YELLOW);
									lblP.setBounds(250, 350, 61, 16);
									
									
									panel_2.add(lblP);
									
									if (name.length() > 3)
									{
										lblP.setText(name.substring(0, 3));
									} 
									
									else
									{
										lblP.setText(name);
									}
									
									break;
								}
							}
						} 
						
						else if (Controller.eInstance().getOnFloor() == 4)
						{
							// lblP.setBounds(250, 350, 61, 16);

							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("dinning".toLowerCase()))
							{
								String resp = "Moving to " + nr.toLowerCase() + "\n";
								textPane.setText(textPane.getText() + "\n\n" + resp);
								lblP.setBounds(40, 54, 61, 16);
								Controller.eInstance().setInRoom(12);

								break;
							}

							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("hallway".toLowerCase()))
							{
								String resp = "Moving to " + nr.toLowerCase() + "\n";
								textPane.setText(textPane.getText() + "\n\n" + resp);
								lblP.setBounds(150, 300, 61, 16);
								Controller.eInstance().setInRoom(13);

								break;
							}

							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("servant quater".toLowerCase()))
							{
								String resp = "Moving to " + nr.toLowerCase() + "\n";
								textPane.setText(textPane.getText() + "\n\n" + resp);
								lblP.setBounds(80, 300, 61, 16);
								;
								Controller.eInstance().setInRoom(14);

								break;
							}


							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("pantry".toLowerCase()))
							{
								String resp = "Moving to " + nr.toLowerCase() + "\n";
								textPane.setText(textPane.getText() + "\n\n" + resp);
								lblP.setBounds(380, 150, 61, 16);
								Controller.eInstance().setInRoom(16);

								break;
							}

							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("staircase".toLowerCase()))
							{
								if (Controller.eInstance().getInRoom() == 13)
								{
									String resp = "Moving to " + nr.toLowerCase() + "\n";
									textPane.setText(textPane.getText() + "\n\n" + resp);
									lblP.setBounds(250, 350, 61, 16);
									
									Controller.eInstance().setInRoom(18);
									Controller.eInstance().setOnFloor(3);
									
									
									panel_2.hide();
									panel_2 = new ImagePanel(new ImageIcon("_f3.png").getImage());
									panel_2.setBackground(Color.WHITE);
									panel_2.setBounds(379, 63, 449, 441);
									
									
									frame.getContentPane().add(panel_2);

									lblP = new JLabel("");
									lblP.setForeground(Color.YELLOW);
									lblP.setBounds(80, 350, 61, 16);
									
									
									panel_2.add(lblP);
									
									if (name.length() > 3)
									{
										lblP.setText(name.substring(0, 3));
									}
									
									else
									{
										lblP.setText(name);
									}
									
									break;
								} 
								
								else
								{
									String resp = "Moving to " + nr.toLowerCase() + "\n";
									textPane.setText(textPane.getText() + "\n\n" + resp);
									lblP.setBounds(250, 350, 61, 16);
									;
									Controller.eInstance().setInRoom(5);
									Controller.eInstance().setOnFloor(6);
									
									
									panel_2.hide();
									panel_2 = new ImagePanel(new ImageIcon("_f5.png").getImage());
									panel_2.setBackground(Color.WHITE);
									panel_2.setBounds(379, 63, 449, 441);
									
									
									frame.getContentPane().add(panel_2);

									lblP = new JLabel("");
									lblP.setForeground(Color.YELLOW);
									lblP.setBounds(250, 350, 61, 16);
									
									
									panel_2.add(lblP);
									
									if (name.length() > 3)
									{
										lblP.setText(name.substring(0, 3));
									} 
									
									else
									{
										lblP.setText(name);
									}
									
									break;
								}
							}
						}

						else if (Controller.eInstance().getOnFloor() == 3)
						{
							// lblP.setBounds(250, 350, 61, 16);
							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("lobby".toLowerCase()))
							{
								String resp = "Moving to " + nr.toLowerCase() + "\n";
								textPane.setText(textPane.getText() + "\n\n" + resp);
								lblP.setBounds(250, 350, 61, 16);
								Controller.eInstance().setInRoom(18);

								break;
							}

							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("Training room".toLowerCase()))
							{
								String resp = "Moving to " + nr.toLowerCase() + "\n";
								textPane.setText(textPane.getText() + "\n\n" + resp);
								lblP.setBounds(40, 54, 61, 16);
								Controller.eInstance().setInRoom(21);

								break;
							}

							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("armoury".toLowerCase()))
							{
								String resp = "Moving to " + nr.toLowerCase() + "\n";
								textPane.setText(textPane.getText() + "\n\n" + resp);
								lblP.setBounds(40, 200, 61, 16);
								Controller.eInstance().setInRoom(19);

								break;
							}

							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("weaponary".toLowerCase()))
							{
								String resp = "Moving to " + nr.toLowerCase() + "\n";
								textPane.setText(textPane.getText() + "\n\n" + resp);
								lblP.setBounds(370, 250, 61, 16);
								;
								Controller.eInstance().setInRoom(20);

								break;
							}

							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("wine cellar".toLowerCase()))
							{
								String resp = "Moving to " + nr.toLowerCase() + "\n";
								textPane.setText(textPane.getText() + "\n\n" + resp);
								lblP.setBounds(380, 350, 61, 16);
								;
								Controller.eInstance().setInRoom(17);

								break;
							}

							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("staircase".toLowerCase()))
							{
								if (selectedItem.toLowerCase().contains("floor 2".toLowerCase()))
								{
									String resp = "Moving to " + nr.toLowerCase() + "\n";
									textPane.setText(textPane.getText() + "\n\n" + resp);
									lblP.setBounds(250, 350, 61, 16);
									;
									
									
									Controller.eInstance().setInRoom(22);
									Controller.eInstance().setOnFloor(2);
									
									
									panel_2.hide();
									panel_2 = new ImagePanel(new ImageIcon("_f2.png").getImage());
									panel_2.setBackground(Color.WHITE);
									panel_2.setBounds(379, 63, 449, 441);
									
									
									frame.getContentPane().add(panel_2);

									lblP = new JLabel("");
									lblP.setForeground(Color.YELLOW);
									lblP.setBounds(80, 350, 61, 16);
									
									
									panel_2.add(lblP);
									
									if (name.length() > 3)
									{
										lblP.setText(name.substring(0, 3));
									} 
									
									else
									{
										lblP.setText(name);
									}
									break;
								} 
								
								else
								{
									String resp = "Moving to " + nr.toLowerCase() + "\n";
									textPane.setText(textPane.getText() + "\n\n" + resp);
									lblP.setBounds(250, 350, 61, 16);
									;
									Controller.eInstance().setInRoom(5);
									Controller.eInstance().setOnFloor(6);
									
									
									panel_2.hide();
									panel_2 = new ImagePanel(new ImageIcon("_f4.png").getImage());
									panel_2.setBackground(Color.WHITE);
									panel_2.setBounds(379, 63, 449, 441);
									
									
									frame.getContentPane().add(panel_2);

									lblP = new JLabel("");
									lblP.setForeground(Color.YELLOW);
									lblP.setBounds(250, 350, 61, 16);
									
									
									panel_2.add(lblP);
									
									if (name.length() > 3)
									{
										lblP.setText(name.substring(0, 3));
									} 
									
									else
									{
										lblP.setText(name);
									}
									break;
								}
							}
						}

						else if (Controller.eInstance().getOnFloor() == 2)
						{
							// lblP.setBounds(250, 350, 61, 16);
							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("common".toLowerCase()))
							{
								String resp = "Moving to " + nr.toLowerCase() + "\n";
								
								textPane.setText(textPane.getText() + "\n\n" + resp);
								lblP.setBounds(250, 350, 61, 16);
								
								Controller.eInstance().setInRoom(22);

								break;
							}

							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("library".toLowerCase()))
							{
								String resp = "Moving to " + nr.toLowerCase() + "\n";
								
								textPane.setText(textPane.getText() + "\n\n" + resp);
								lblP.setBounds(40, 54, 61, 16);
								
								Controller.eInstance().setInRoom(25);
								

								break;
							}

							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("garderobe".toLowerCase()))
							{
								String resp = "Moving to " + nr.toLowerCase() + "\n";
								
								textPane.setText(textPane.getText() + "\n\n" + resp);
								lblP.setBounds(370, 350, 61, 16);
								
								Controller.eInstance().setInRoom(24);

								break;
							}

							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("barracks".toLowerCase()))
							{
								String resp = "Moving to " + nr.toLowerCase() + "\n";
								textPane.setText(textPane.getText() + "\n\n" + resp);
								
								lblP.setBounds(370, 250, 61, 16);
								;
								
								Controller.eInstance().setInRoom(23);

								break;
							}

							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("staircase".toLowerCase()))
							{
								
								if (Controller.eInstance().getInRoom() == 25)
								{
									String resp = "Moving to " + nr.toLowerCase() + "\n";
									textPane.setText(textPane.getText() + "\n\n" + resp);
									lblP.setBounds(250, 350, 61, 16);
									
									
									Controller.eInstance().setInRoom(26);
									Controller.eInstance().setOnFloor(1);
									
									
									
									panel_2.hide();
									panel_2 = new ImagePanel(new ImageIcon("_f1.png").getImage());
									panel_2.setBackground(Color.WHITE);
									panel_2.setBounds(379, 63, 449, 441);
									
									
									frame.getContentPane().add(panel_2);

									lblP = new JLabel("");
									lblP.setForeground(Color.YELLOW);
									lblP.setBounds(80, 40, 61, 16);
									
									
									panel_2.add(lblP);
									
									
									if (name.length() > 3)
									{
										lblP.setText(name.substring(0, 3));
									} 
									
									else
									{
										lblP.setText(name);
									}
									break;
								} 
								
								
								}
							}
						
						
						else if (Controller.eInstance().getOnFloor() == 1)
						{
							// lblP.setBounds(250, 350, 61, 16);
							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("Prep room".toLowerCase()))
							{
								String resp = "Moving to " + nr.toLowerCase() + "\n";
								textPane.setText(textPane.getText() + "\n\n" + resp);
								lblP.setBounds(50, 50, 61, 16);
								Controller.eInstance().setInRoom(26);

								break;
							}

							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("Reception".toLowerCase()))
							{
								String resp = "Moving to " + nr.toLowerCase() + "\n";
								textPane.setText(textPane.getText() + "\n\n" + resp);
								lblP.setBounds(50, 300, 61, 16);
								Controller.eInstance().setInRoom(27);

								break;
							}

							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("Morgue".toLowerCase()))
							{
								String resp = "Moving to " + nr.toLowerCase() + "\n";
								textPane.setText(textPane.getText() + "\n\n" + resp);
								lblP.setBounds(250, 50, 61, 16);
								Controller.eInstance().setInRoom(28);

								break;
							}

							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("warden office".toLowerCase()))
							{
								String resp = "Moving to " + nr.toLowerCase() + "\n";
								textPane.setText(textPane.getText() + "\n\n" + resp);
								lblP.setBounds(250, 190, 61, 16);
								;
								Controller.eInstance().setInRoom(29);

								break;
							}

							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("safe".toLowerCase()))
							{
								String resp = "Moving to " + nr.toLowerCase() + "\n";
								textPane.setText(textPane.getText() + "\n\n" + resp);
								lblP.setBounds(250, 300, 61, 16);
								;
								Controller.eInstance().setInRoom(30);
							}

							if (selectedItem.toLowerCase().contains(nr.toLowerCase())
									&& selectedItem.toLowerCase().contains("exit".toLowerCase()))
							{
								String resp = "Moving to " + nr.toLowerCase() + "\n";
								textPane.setText("You have won the game");
								button.setEnabled(false);
								lblP.setBounds(250, 150, 61, 16);
								;

							}
						}
					}

				} 
				else if (selectedItem.equalsIgnoreCase("Inventory"))
				{
					String resp = Controller.eInstance().inventaryList();
					textPane.setText(textPane.getText() + "\n\n" + resp);
				}
				
				else if (selectedItem.contains("Inspect"))
				{
					if (selectedItem.contains("Exit"))
					{
						String resp = Controller.eInstance().getFloor(Controller.eInstance().getOnFloor())
								.getRoom(Controller.eInstance().getInRoom()).doors();
						textPane.setText(textPane.getText() + "\n\n" + resp);
					}
				} 
				
				else if (selectedItem.contains("Use"))
				{
					if (Controller.eInstance().use(selectedItem))
					{
						textPane.setText(textPane.getText() + "\n\n" + selectedItem.substring(4, selectedItem.length())
								+ "is used");
					}

					else
					{
						textPane.setText(textPane.getText() + "\n\n" + selectedItem.substring(4, selectedItem.length())
								+ "is not found");

					}
				}

				else if (selectedItem.contains("Drop"))
				{
					if (Controller.eInstance().drop(selectedItem))
					{
						textPane.setText(textPane.getText() + "\n\n" + selectedItem.substring(5, selectedItem.length())
								+ "is dropped");
					}

					else
					{
						textPane.setText(textPane.getText() + "\n\n" + selectedItem.substring(5, selectedItem.length())
								+ "is not found");

					}

				}

				else if (selectedItem.contains("drop"))
				{
					if (Controller.eInstance().drop(selectedItem))
					{
						textPane.setText(textPane.getText() + "\n\n" + selectedItem.substring(5, selectedItem.length())
								+ "is dropped");
					}

					else
					{
						textPane.setText(textPane.getText() + "\n\n" + selectedItem.substring(5, selectedItem.length())
								+ "is not found");

					}

				}

				else if (selectedItem.contains("Pickup"))
				{
					Artifact artifact = Controller.eInstance().getFloor(Controller.eInstance().getOnFloor())
							.getRoom(Controller.eInstance().getInRoom()).getArtifact(selectedItem);
					if (artifact != null)
					{
						Controller.eInstance().getPlayer().getInventary().add(artifact);
						textPane.setText(textPane.getText() + "\n\n" + selectedItem.substring(7, selectedItem.length())
								+ " is picked up");
					}
					else
					{
						textPane.setText(textPane.getText() + "\n\n" + selectedItem.substring(7, selectedItem.length())
								+ " is not found");

					}

				} 
				
				else if (selectedItem.contains("pick up"))
				{
					Artifact artifact = Controller.eInstance().getFloor(Controller.eInstance().getOnFloor())
							.getRoom(Controller.eInstance().getInRoom()).getArtifact(selectedItem);
					if (artifact != null)
					{
						Controller.eInstance().getPlayer().getInventary().add(artifact);
						textPane.setText(textPane.getText() + "\n\n" + selectedItem.substring(7, selectedItem.length())
								+ " is picked up");
					} 
					
					else
					{
						textPane.setText(textPane.getText() + "\n\n" + selectedItem.substring(7, selectedItem.length())
								+ " is not found");

					}

				}

				else if (selectedItem.contains("Equip"))
				{
					if (Controller.eInstance().use(selectedItem))
					{
						textPane.setText(textPane.getText() + "\n\n" + selectedItem.substring(4, selectedItem.length())
								+ "is used");
					}
					
					else
					{
						textPane.setText(textPane.getText() + "\n\n" + selectedItem.substring(4, selectedItem.length())
								+ "is not found");

					}
				}

				else if (selectedItem.contains("Get Hint"))
				{
					if (!Controller.eInstance().getFloor(Controller.eInstance().getOnFloor())
							.getRoom(Controller.eInstance().getInRoom()).getPuzzles().isEmpty())
					{
						String resp = "\n" + Controller.eInstance().getFloor(Controller.eInstance().getOnFloor())
								.getRoom(Controller.eInstance().getInRoom()).getPuzzles().get(0).getHint();
						textPane.setText("" + textPane.getText() + resp);
					} 
					
					else
					{
						textPane.setText("" + textPane.getText() + "\nThere is no puzzle");
					}

				}
				// else if(selectedItem.contains("Engage Combat"))
				// {
				//
				// }
				else if (selectedItem.contains("Flee battle"))
				{
					textPane.setText("" + textPane.getText() + "\nFleeing battle, Running away");
				} 
				
				else if (selectedItem.contains("Attack Monster"))
				{
					if (!Controller.eInstance().getFloor(Controller.eInstance().getOnFloor())
							.getRoom(Controller.eInstance().getInRoom()).getMonsters().isEmpty())
					{
						Controller.eInstance().getFloor(Controller.eInstance().getOnFloor())
								.getRoom(Controller.eInstance().getInRoom())
								.attackMonster(Controller.eInstance().getPlayer());
						button2.setText("Health: " + Controller.eInstance().getPlayer().getHealthPoints());
						button.setText("Points: " + Controller.eInstance().getPlayer().getGameScore());
						button3.setText("Attack: " + Controller.eInstance().getPlayer().getAttackPoints()
								+ "\n Defence: " + Controller.eInstance().getPlayer().getDefencePoints());
					}
					
					else
					{
						textPane.setText("" + textPane.getText() + "\nThere is no monster to attack");
					}
				}
				

			}
		});
		
		
		
		btnNewButton_1.setBounds(108, 67, 117, 29);
		panel.add(btnNewButton_1);

		JLabel lblSelectAction = new JLabel("Select Action");
		lblSelectAction.setBounds(6, 6, 129, 16);
		panel.add(lblSelectAction);

		textPane = new TextArea();
		textPane.setBackground(Color.LIGHT_GRAY);
		textPane.setBounds(6, 107, 358, 300);
		
		
		panel.add(textPane);
		textPane.setText(name + " was born in the Wackdro kingdom of Littlevinelle. "
				+ "He had a detached temperament, \nwhich the queen disapproved of, "
				+ "so he went off on his own to discover the outskirts of his own kingdom \n"
				+ "at the age of 7. He defeated numerous monsters that crossed his path "
				+ "and found a great power in \nall of them.");
		
		
		
		JLabel lblConsole = new JLabel("Console");
		lblConsole.setBounds(6, 80, 129, 16);
		panel.add(lblConsole);

		JButton btnNewButton_2 = new JButton("Start");
		btnNewButton_2.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				btnNewButton_2.setEnabled(false);
				btnNewButton_2.hide();
				btnNewButton_1.setEnabled(true);
				updateUI("", 6);
				updateUI("", 0);
				textPane.setText("");
			}
		});
		
		
		
		btnNewButton_2.setBounds(124, 412, 117, 29);
		panel.add(btnNewButton_2);

		Panel panel_1 = new Panel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(401, 110, 289, 210);

		JLabel lblNewLabel = new JLabel("New label");

		panel_2 = new ImagePanel(new ImageIcon("_f6.png").getImage());

		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(379, 63, 449, 441);
		
		frame.getContentPane().add(panel_2);

		lblP = new JLabel("");
		lblP.setForeground(Color.YELLOW);
		lblP.setBounds(40, 54, 61, 16);
		panel_2.add(lblP);
		
		if (name.length() > 3)
		{
			lblP.setText(name.substring(0, 3));
		}
		
		else
		{
			lblP.setText(name);
		}

		panel_1.add(lblNewLabel);

	}
	

	public void updateUI(String menu,int room) 
	{
		
		if(room == 6)
		{
			comboBox.addItem("Look");
			
			comboBox.addItem("Go to ");
			
			comboBox.addItem("Inventory");
			
			comboBox.addItem("Inspect ");
			
			comboBox.addItem("Use ");	
			
			comboBox.addItem("Drop ");

			comboBox.addItem("Pickup ");

			comboBox.addItem("Equip  ");

			comboBox.addItem("Get Hint  ");

		}
		
		else if(room == 0)
		{
			comboBox.addItem("Start Puzzle ");
			
			comboBox.addItem("Leave Puzzle ");
			
			comboBox.addItem("Answer ");
			
			//comboBox.addItem("Engage Combat");
			
			comboBox.addItem("Attack Monster");
			
			comboBox.addItem("Flee battle");

		}
		
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
/*class ImagePanel extends JPanel
{

	  private Image img;

	  public ImagePanel(String img)
	  {
	    this(new ImageIcon(img).getImage());
	  }

	  public ImagePanel(Image img) 
	  {
	    this.img = img;
	    setLayout(null);
	  }

	  public void paintComponent(Graphics g) 
	  {
	    g.drawImage(img, 0, 0, null);
	  }

	}

*/




















}










