package Controller;

import Model.Model;
import Model.MiscellaneousContent;
import View.Console;

public class Main 
{
	public static void main(String[] args)
	{
		Model model = new Model();
		Console view = new Console();
		Controller controller = new Controller(model, view);
		view.println(MiscellaneousContent.displayIntro());
		view.println(MiscellaneousContent.displayMainMenu());
		controller.mainMenu();
	}
}