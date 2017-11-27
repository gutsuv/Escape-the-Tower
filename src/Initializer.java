import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import View.View;
import Model.ObjectHolder;
import Controller.Controller;
/**
 * Class: Initializer
 * @author Team Hydra
 * @version 1.0
 * Course: ITEC 3860, Fall 2017
 * Written: 
 * 
 * This class initializes all of the objects
 * 
 * Purpose: â€“ Stores the object instantiations
 */
public class Initializer
{
	static ObjectHolder main;
	static View view;
	static Controller cont;
	
	/**
     * Method: main()
     * Main method
     * @param args
     * @return nothing
     */
	public static void main(String[] args)
	{
		initializerControl();
	}
	
	/**
     * Method: initializerControl()
     * Displays main menu
     * @param none
     * @return nothing
     */
	public static void initializerControl()
	{
		while(true)
		{
			Scanner scan = new Scanner(System.in);
			view = new View();
			view.line(60);
			view.line(60);
			view.print( 

					"	╔═╗┌─┐┌─┐┌─┐┌─┐┌─┐  ┌┬┐┬ ┬┌─┐  ╔╦╗┌─┐┬ ┬┌─┐┬─┐\r\n" + 
					"	║╣ └─┐│  ├─┤├─┘├┤    │ ├─┤├┤    ║ │ ││││├┤ ├┬┘\r\n" + 
					"	╚═╝└─┘└─┘┴ ┴┴  └─┘   ┴ ┴ ┴└─┘   ╩ └─┘└┴┘└─┘┴└─" );
			
			view.print("	  [ 		 New Game 		 ]\n"
					 + "	  [ 		Load Game 1		 ]\n"
					 + "	  [ 		Load Game 2		 ]\n"
				     + "	  [ 		Load Game 3		 ]\n"
					 + "	  [ 		Close Game		 ]"
					);
			
			view.line(60);
			view.line(60);
			String input = scan.nextLine();
			if(input.equalsIgnoreCase("New Game"))
			{
				try
				{
					newGame(scan);
				}
				catch (FileNotFoundException e)
				{
					System.out.println("failed to load");
				}
				catch (ArithmeticException e)
				{
					
				}
			}
			if(input.equalsIgnoreCase("Load Game 1")||input.matches("1"))
			{
				try
				{
					loadGame(scan,"One");
				}
				catch (FileNotFoundException e)
				{
					System.out.println("failed to load");
				}
				catch (ArithmeticException e)
				{
					
				}
			}
			if(input.equalsIgnoreCase("Load Game 2")||input.matches("2"))
			{
				try
				{
					loadGame(scan,"Two");
				}
				catch (FileNotFoundException e)
				{
					System.out.println("failed to load");
				}
				catch (ArithmeticException e)
				{
					
				}
			}
			if(input.equalsIgnoreCase("Load Game 3")||input.matches("3"))
			{
				try
				{
					loadGame(scan,"Three");
				}
				catch (FileNotFoundException e)
				{
					System.out.println("failed to load");
				}
				catch (ArithmeticException e)
				{
					
				}
			}
			if(input.equalsIgnoreCase("Close Game"))
			{
				System.exit(0);
			}
		}

	}
	
	/**
     * Method: initializerControlLoad()
     * loads the controller
     * @param none
     * @return nothing
     */
	public static void initializerControlLoad()
	{
		
	}

	/**
     * Method: newGame()
     * Sets up a new game
     * @param control Scanner 
     * @return nothing
     */
	public static void newGame(Scanner control) throws FileNotFoundException
	{
		main = new ObjectHolder(view);
		main.initializeNew();
		cont = new Controller(main, control);
	}
	
	/**
     * Method: loadGame()
     * Loads game
     * @param control Scanner 
     * @param number String 
     * @return nothing
     */
	public static void loadGame(Scanner control, String number) throws FileNotFoundException
	{
		main = new ObjectHolder(view);
		main.initializeLoad(number);
		cont = new Controller(main, control);
	}
}
