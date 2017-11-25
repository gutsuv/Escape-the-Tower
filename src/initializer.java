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
			view.line(12);
			view.print("New Game:");
			view.print("Load Game One:");
			view.print("Load Game Two:");
			view.print("Load Game Three:");
			view.print("Close Game:");
			view.line(12);
			String input = scan.nextLine();
			if(input.matches("New Game"))
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
			if(input.matches("Load Game One"))
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
			if(input.matches("Load Game Two"))
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
			if(input.matches("Load Game Three"))
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
			if(input.matches("Close Game"))
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
