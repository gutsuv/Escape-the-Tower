import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
public class Initializer
{
	static ObjectHolder main;
	static View view;
	static Controller cont;
	
	public static void main(String[] args)
	{
		initializerControl();
	}
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
			}
			if(input.equalsIgnoreCase("Load Game One"))
			{
				try
				{
					loadGame(scan,"One");
				}
				catch (FileNotFoundException e)
				{
					System.out.println("failed to load");
				}
			}
			if(input.equalsIgnoreCase("Load Game Two"))
			{
				try
				{
					loadGame(scan,"Two");
				}
				catch (FileNotFoundException e)
				{
					System.out.println("failed to load");
				}
			}
			if(input.equalsIgnoreCase("Load Game Three"))
			{
				try
				{
					loadGame(scan,"Three");
				}
				catch (FileNotFoundException e)
				{
					System.out.println("failed to load");
				}
			}
			if(input.equalsIgnoreCase("Close Game"))
			{
				System.exit(0);
			}
		}

	}
	
	public static void initializerControlLoad()
	{
		
	}

	public static void newGame(Scanner control) throws FileNotFoundException
	{
		main = new ObjectHolder(view);
		main.initializeNew();
		cont = new Controller(main, control);
	}
	
	public static void loadGame(Scanner control, String number) throws FileNotFoundException
	{
		main = new ObjectHolder(view);
		main.initializeLoad(number);
		cont = new Controller(main, control);
	}
}
