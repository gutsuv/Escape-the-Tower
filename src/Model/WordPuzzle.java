package Model;

/**
 * Class: WordPuzzle
 * @author Team Hydra
 * @version 1.0
 * Course: ITEC 3860, Fall 2017
 * Written: November 25
 * 
 * This class stores and holds the functionality of word based puzzles in the game.
 * 
 * Purpose: To contain the methods and attributes needed to create word based puzzles.
 */
public class WordPuzzle extends Puzzle
{
	String answer;
	Item item;

	/**
     * Method: WordPuzzle()
     * WordPuzzle constructor
     * @param loadedString String representing the string inputs to be parsed
     * @param library ReferenceIdentities object 
     * @return nothing
     */
	public WordPuzzle(String loadedString, ReferenceIdentities library)
	{
		// loaded from file
		// int puzzleId String name, int itemId,
		// String answer, String puzzleDesc, String hint

		try
		{
			String[] splitString = loadedString.split("-_");
			puzzleId = Integer.parseInt(splitString[0]);
			puzzleName = splitString[1];
			item = library.cloneItem(Integer.parseInt(splitString[2]));
			answer = splitString[3];
			puzzleDesc = splitString[4];
			hint = splitString[5];
		}
		catch (Exception E)
		{
			System.out.println("Error");
		}
	}

	/**
     * Method: getItem()
     * Returns item
     * @param none
     * @return item Item object
     */
	public Item getItem()
	{
		return item;
	}

	/**
     * Method: initialize()
     * 
     * @param none
     * @return nothing
     */
	@Override
	public void initialize()
	{
	}

	/**
     * Method: attemptSolve()
     * Evaluates user result
     * @param answer String value representing user answer
     * @return nothing
     */
	@Override
	public void attemptSolve(String answer)
	{
		if (this.answer.matches(answer))
		{
			solved = true;
			view.line(125);
			view.print("Puzzle solved");
			view.print("Item available");
		}
		else
		{
			view.line(125);
			view.print("incorrect solution");
		}
	}

	/**
     * Method: attemptSolve()
     * 
     * @param itemId int 
     * @return nothing
     */
	@Override
	public void attemptSolve(int itemId)
	{
	}

	/**
     * Method: display()
     * Displays word puzzle
     * @param none
     * @return nothing
     */
	@Override
	public void display()
	{
		view.line(125);
		view.print(puzzleName);
		view.printString(puzzleDesc, 125);
		view.printString("Input solution to puzzle or type 'exit' or type 'hint'", 125);
	}
}
