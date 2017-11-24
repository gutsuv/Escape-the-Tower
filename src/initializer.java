import java.io.FileNotFoundException;
import java.util.Scanner;

public class Initializer
{
	static ObjectHolder main;
	static View view;

	public static void main(String[] args)
	{
		Controller cont;
		view = new View();
		
		try
		{
			newGame();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("failed to load");
		}
		cont = new Controller(main);
	}

	public static void newGame() throws FileNotFoundException
	{
		main = new ObjectHolder(view);
		main.initializeNew();
	}
}
