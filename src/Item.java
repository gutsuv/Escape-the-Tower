import javafx.scene.control.Button;

public abstract class Item implements Cloneable, Comparable<Item>
{
	protected int itemId;
	protected String itemName;
	protected String itemDescLong;
	protected String itemDescShort;
	protected View view;

	public int getItemId()
	{
		return itemId;
	}

	public String getItemName()
	{
		return itemName;
	}

	public String getItemDesc()
	{
		return itemDescLong;
	}

	public String getItemDescShort()
	{
		return itemDescShort;
	}

	public void setView(View view)
	{
		this.view = view;
	}

	public abstract void use();

	public abstract void drop();

	public abstract void examine();

	public abstract String getDisplay();

	public abstract void displayCommands();

	protected Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}

	@Override
	public String toString()
	{
		return "Item [" + itemName + ", " + itemDescShort + "]";
	}

	@Override
	public int compareTo(Item o)
	{
		if (itemId > o.getItemId())
		{
			return 1;
		}
		else if (itemId < o.getItemId())
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
}