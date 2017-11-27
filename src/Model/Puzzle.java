package Model;

import View.View;
/**
 * Class: Puzzle
 * @author Team Hydra
 * @version 1.0
 * Course: ITEC 3860, Fall 2017
 * Written: 
 * 
 * This class – now describe what the class does 
 * 
 * Purpose: – Describe the purpose of this class
 */
public abstract class Puzzle implements Cloneable
{
	protected int puzzleId;
	protected String puzzleName;
	protected String puzzleDesc;
	protected String hint;
	protected View view;
	protected boolean solved = false;

	/**
     * Method: getPuzzleID()
     * Returns puzzle ID
     * @param none
     * @return puzzleId int value representing puzzle ID
     */
	public int getPuzzleID()
	{
		return puzzleId;
	}

	/**
     * Method: getHint()
     * Returns hint
     * @param none
     * @return hint String value representing puzzle hint
     */
	public String getHint()
	{
		return hint;
	}

	/**
     * Method: printHint()
     * Displays hint
     * @param none
     * @return nothing
     */
	public void printHint()
	{
		view.line(125);
		view.printString(hint, 125);
	}

	/**
     * Method: getPuzzleDescription()
     * Returns puzzle description
     * @param none
     * @return puzzleDesc String value representing puzzle description
     */
	public String getPuzzleDescription()
	{
		return puzzleDesc;
	}
	
	/**
     * Method: printPuzzleDescription()
     * Displays puzzle description
     * @param none
     * @return nothing
     */
	public void printPuzzleDescription()
	{
		view.printString(puzzleDesc, 125);
	}

	/**
     * Method: setView()
     * Sets view
     * @param view View object
     * @return nothing
     */
	public void setView(View view)
	{
		this.view = view;
	}

	/**
     * Method: isSolved()
     * Returns solved status
     * @param view View object
     * @return solved boolean value representing solved status
     */
	public boolean isSolved()
	{
		return solved;
	}

	/**
     * Method: Solve()
     * Sets solved to true
     * @param solved boolean value representing solved status
     * @return nothing
     */
	public void Solve(boolean solved)
	{
		solved = true;
	}

	/**
     * Method: getName()
     * Returns puzzle name
     * @param none
     * @return puzzleName String value representing puzzle name
     */
	public String getName()
	{
		return puzzleName;
	}

	/**
     * Method: initialize()
     * 
     * @param none
     * @return nothing
     */
	public abstract void initialize();

	/**
     * Method: attemptSolve()
     * 
     * @param none
     * @return nothing
     */
	public abstract void attemptSolve(String answer);

	/**
     * Method: attemptSolve()
     * 
     * @param none
     * @return nothing
     */
	public abstract void attemptSolve(int itemId);

	/**
     * Method: display()
     * 
     * @param none
     * @return nothing
     */
	public abstract void display();

	// I'm aware of redundancy but I did it this way for a reason
	/**
     * Method: toString()
     * Displays puzzle name and description
     * @param none
     * @return nothing
     */
	@Override
	public String toString()
	{
		return puzzleName + ", " + puzzleDesc;
	}

	/**
     * Method: clone()
     * Returns clone
     * @param none
     * @return super.clone()
     */
	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
}