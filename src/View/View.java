package View;

import java.util.ArrayList;

/**
 * Class: View
 * @author Team Hydra
 * @version 1.0
 * Course: ITEC 3860, Fall 2017
 * Written: 
 * 
 * This class – now describe what the class does 
 * 
 * Purpose: – Describe the purpose of this class
 */
public class View<e>
{
	public void line()
	{
		System.out.println();
	}

	public void line(int i)
	{
		while (i > 0)
		{
			i--;
			System.out.print("-");
		}
		line();
	}

	public void printString(String a)
	{
		System.out.println(a);
	}

	public void printString(String a, int i)
	{
		int j = 0, k = 0, m = a.length();
		while (k < m)
		{
			j++;
			if (j > i)
			{
				System.out.print("-");
				System.out.println();
				j = 0;
				System.out.print("    -");
			}
			System.out.print(a.charAt(k));
			k++;
		}
		System.out.println();
	}

	public void printStringO(Object o, int i)
	{
		printString(o.toString(), i);
	}

	public void print(String[] a)
	{
		int i = a.length;
		while (i > 0)
		{
			System.out.println(a[i]);
			i--;
		}
	}

	public void print(Object o)
	{
		if (o == null)
		{
			return;
		}
		if (o instanceof ArrayList)
		{
			if (((ArrayList) o).size() == 0)
			{
				return;
			}
			for (int i = 0; i < ((ArrayList) o).size(); i++)
			{
				System.out.println(((ArrayList) o).get(i));
			}
			return;
		}
		System.out.println(o);
	}

	public void printStrO(Object o, int j)
	{
		if (o == null)
		{
			return;
		}
		if (o instanceof ArrayList)
		{
			if (((ArrayList) o).size() == 0)
			{
				return;
			}
			for (int i = 0; i < ((ArrayList) o).size(); i++)
			{
				printStringO(((ArrayList) o).get(i), j);
			}
			return;
		}
		printStringO(o, j);
	}

	public void print(Object[] o)
	{
		int i = o.length;
		while (i > 0)
		{
			System.out.println(o[i]);
			i--;
		}
	}

	public void print(Object o, Object e)
	{
		System.out.print(o);
		System.out.println(": " + e);
	}

	public void printString(Object o, Object e, int i)
	{
		printString((o.toString() + ": " + e.toString()), i);
	}
}
