import java.util.Scanner;

public class Controller
{
	Scanner control = new Scanner(System.in);
	ObjectHolder model;
	View menuView = new View();

	public Controller(ObjectHolder main)
	{
		model = main;
		while (true)
		{
			determine(control.nextLine());
		}
	}

	public void controllerEnemy()
	{
		while (true)
		{
			menuView.print("Health: " + model.getUser().getHealth() + "/" + model.getUser().getMaxHealth());
			if (model.getCurrentRoom().getEnemy() != null)
			{
				model.getCurrentRoom().getEnemy().display();
			}
			if (determineEnemy(control.next()) == true)
			{
				break;
			}
		}
	}

	public void controllerItem()
	{
		while (true)
		{
			model.getUser().displayInventory();
			if (determineItem(control.next()) == true)
			{
				break;
			}
		}
	}

	public void controllerItem(int i)
	{
		model.getUser().getItem(i).displayCommands();
		determineItem(control.next(), i);
	}

	// Puzzle controller
	public void controllerObjectPuzzle()
	{
		String itemNumber;
		while (true)
		{
			((ObjectPuzzle) model.getCurrentRoom().getPuzzle()).display(model.getUser().getInventory());
			itemNumber = control.nextLine();
			if (itemNumber.matches("exit"))
			{
				break;
			}
			if (itemNumber.matches("hint"))
			{
				model.getCurrentRoom().getPuzzle().printHint();
			}
			if (itemNumber.matches("[0-9]+"))
			{
				model.getCurrentRoom().getPuzzle()
						.attemptSolve(model.getUser().getItem(Integer.parseInt(itemNumber)).getItemId());
			}
			if (model.getCurrentRoom().getPuzzle().isSolved())
			{
				model.getCurrentRoom().setPuzzle(null);
				model.user.removeItem(Integer.parseInt(itemNumber));
				break;
			}
		}
	}

	public void controllerPuzzleDebuff()
	{
		String answer;
		while (true)
		{
			model.getCurrentRoom().getPuzzle().display();
			answer = control.nextLine();
			if (answer.matches("exit"))
			{
				break;
			}
			if (answer.matches("hint"))
			{
				model.getCurrentRoom().getPuzzle().printHint();
			}
			if(answer.matches("drink"))
			{
				((PuzzleDebuff) model.getCurrentRoom().getPuzzle()).printPoison();
				model.getUser().setPoisoned(true);
				model.getUser().updateStats();
			}
			if(answer.matches("ignore"))
			{
				model.getCurrentRoom().getPuzzle().attemptSolve(answer);
			}
			if(model.getCurrentRoom().getPuzzle().isSolved())
			{
				model.getCurrentRoom().setPuzzle(null);
			}
		}
	}

	public void controllerPuzzleNumber()
	{
		String answer;
		while (true)
		{
			model.getCurrentRoom().getPuzzle().display();
			answer = control.nextLine();
			if (answer.matches("exit"))
			{
				break;
			}
			if (answer.matches("hint"))
			{
				model.getCurrentRoom().getPuzzle().printHint();
			}
			if (answer.matches("[0-9]+"))
			{
				model.getCurrentRoom().getPuzzle().attemptSolve(answer);
				if (!model.getCurrentRoom().getPuzzle().isSolved())
				{
					model.getUser().receiveDamage(((PuzzleNumber) model.getCurrentRoom().getPuzzle()).getDamage());
				}
			}
			if (model.getCurrentRoom().getPuzzle().isSolved())
			{
				model.getCurrentRoom().setPuzzle(null);
				break;
			}
		}
	}

	public void controllerPuzzleRiddle()
	{
		String answer;
		while (true)
		{
			model.getCurrentRoom().getPuzzle().display();
			answer = control.nextLine();
			if (answer.matches("exit"))
			{
				break;
			} 
			else if (answer.matches("hint"))
			{
				model.getCurrentRoom().getPuzzle().printHint();
			} 
			else
			{
				model.getCurrentRoom().getPuzzle().attemptSolve(answer);
			}
			if (model.getCurrentRoom().getPuzzle().isSolved())
			{
				model.getCurrentRoom().setPuzzle(null);
				break;
			}
		}
	}

	public void controllerDoorPuzzle()
	{
		String itemNumber;
		while (true)
		{
			((DoorPuzzle) model.getCurrentRoom().getPuzzle()).display(model.getUser().getInventory());
			itemNumber = control.nextLine();
			if (itemNumber.matches("exit"))
			{
				break;
			}
			if (itemNumber.matches("hint"))
			{
				model.getCurrentRoom().getPuzzle().printHint();
			}
			if (itemNumber.matches("[0-9]+"))
			{
				try {
					model.getCurrentRoom().getPuzzle()
						.attemptSolve(model.getUser().getItem(Integer.parseInt(itemNumber)).getItemId());
				}
				catch(Exception E)
				{
					
				}
			}
			if (model.getCurrentRoom().getPuzzle().isSolved())
			{
				model.getCurrentRoom().setPuzzle(null);
				model.user.getInventory().remove(Integer.parseInt(itemNumber));
				break;
			}
		}
	}

	public void controllerWordPuzzle()
	{
		String answer;
		while (true)
		{
			model.getCurrentRoom().getPuzzle().display();
			answer = control.nextLine();
			if (answer.matches("exit"))
			{
				break;
			}
			model.getCurrentRoom().getPuzzle().attemptSolve(answer);
			if (model.getCurrentRoom().getPuzzle().isSolved())
			{
				model.getCurrentRoom().addItem(((WordPuzzle) model.getCurrentRoom().getPuzzle()).getItem());
				model.getCurrentRoom().setPuzzle(null);
				break;
			}
		}
	}

	private void determine(String input)
	{
		if (input.length() == 1)
		{
			try
			{
				navigate(input);
			} 
			catch (Exception E)
			{
				
			}
		} 
		else if (input.matches("pick up"))
		{
			pickUpAll();
		} 
		else if (input.matches("inventory"))
		{
			controllerItem();
		} 
		else if (input.matches("stats"))
		{
			model.getUser().displayStats();
			model.getUser().displayEquippedItems();
		} 
		else if (input.matches("combat") && model.getCurrentRoom().getEnemy() != null)
		{
			controllerEnemy();
		} 
		else if (input.matches("puzzle") && model.getCurrentRoom().getPuzzle() != null)
		{
			if (model.getCurrentRoom().getPuzzle() instanceof DoorPuzzle)
			{
				controllerDoorPuzzle();
			}
			if (model.getCurrentRoom().getPuzzle() instanceof ObjectPuzzle)
			{
				controllerObjectPuzzle();
			}
			if (model.getCurrentRoom().getPuzzle() instanceof PuzzleDebuff)
			{
				controllerPuzzleDebuff();
			}
			if (model.getCurrentRoom().getPuzzle() instanceof PuzzleNumber)
			{
				controllerPuzzleNumber();
			}
			if (model.getCurrentRoom().getPuzzle() instanceof PuzzleRiddle)
			{
				controllerPuzzleRiddle();
			}
			if (model.getCurrentRoom().getPuzzle() instanceof WordPuzzle)
			{
				controllerWordPuzzle();
			}
			try
			{
				model.getCurrentRoom().display();
			} 
			catch (Exception E)
			{
				
			}
		}
	}

	private boolean determineItem(String input)
	{
		if (input.matches("[0-9]+"))
		{
			try
			{
				controllerItem(Integer.parseInt(input));
			} 
			catch (Exception E)
			{

			}
		}
		if (input.matches("exit"))
		{
			try
			{
				model.getCurrentRoom().display();
			} 
			catch (Exception E)
			{
				
			}
			return true;
		}
		return false;
	}

	private boolean determineItem(String input, int i)
	{
		try
		{
			if (input.matches("exit"))
			{
				return true;
			} 
			else if (input.matches("use"))
			{
				if (model.getUser().getItem(i) instanceof Consumable)
				{
					model.getUser().receiveDamage(-((Consumable) model.getUser().getItem(i)).getHealthEffect());
					model.getUser().updateMaxHealth(-((Consumable) model.getUser().getItem(i)).getMaxHealthEffect());
					model.getUser().drop(i);
				}
				if (model.getUser().getItem(i) instanceof PuzzleItem)
				{
					if(model.getUser().getItem(i).getItemId() == 102)
					{
						model.getUser().removeItem(i);
						model.getUser().setPoisoned(false);
						model.getUser().updateStats();
					}
				}
				// model.getUser().getItem(i).use();
				// ran into problem. AoK work around
				return true;
			} 
			else if (input.matches("drop"))
			{
				model.currentRoom.addItem(model.getUser().getItem(i));
				model.getUser().getItem(i).drop();// this part of code does nothing most of the time
				model.getUser().drop(i);
				return true;
			} 
			else if (input.matches("equip"))
			{
				model.getUser().equip(i);
				return true;
			} 
			else if (input.matches("examine"))
			{
				model.getUser().getItem(i).examine();
				return true;
			}
		} catch (Exception E)
		{
		}
		return false;
	}

	private boolean determineEnemy(String input)
	{
		if (input.matches("exit"))
		{
			try
			{
				model.getCurrentRoom().display();
			} 
			catch (Exception E)
			{
				
			}
			return true;
		} 
		else if (input.matches("attack"))
		{
			int j = model.getCurrentRoom().getEnemy().getDefense();
			int i = model.getUser().dealDamage() - j;
			
			if (i <= 0)
			{
				menuView.print("The attack Missed");
			} 
			else
			{
				model.getCurrentRoom().getEnemy().receiveDamage(i);
				if (model.getCurrentRoom().getEnemy().isAlive())
				{
					menuView.print("Player attack: " + i + " damage");
				}
			}
			if (!model.getCurrentRoom().getEnemy().isAlive())
			{
				model.getCurrentRoom().enemyDeathEffects();
				return true;
			} 
			else
			{
				int f = model.getUser().getDefense();
				int g = model.getCurrentRoom().getEnemy().dealDamage() - f;
				
				if (g <= 0)
				{
					menuView.print("Enemy attack Missed");
				} 
				else
				{
					menuView.print("Enemy attack: " + g + " damage");
					model.getUser().receiveDamage(g);
					if (!model.getUser().isAlive())
					{
						menuView.print("player died");
						menuView.print("game over");
						System.exit(0);
					}
				}
			}
		} 
		else if (input.matches("inventory"))
		{
			controllerItem();
		}
		return false;
	}

	private void navigate(String input) throws Exception
	{
		model.navigate(input.charAt(0));
	}

	private void pickUpAll()
	{
		while (model.getCurrentRoom().getItems().size() > 0)
		{
			model.getUser().pickUp(model.getCurrentRoom().getItems().get(0));
			model.getCurrentRoom().getItems().remove(0);
		}
		menuView.line(125);
		menuView.print("Items Picked Up");
		try
		{
			model.getCurrentRoom().display();
		} 
		catch (Exception e)
		{
			
		}
	}
}
