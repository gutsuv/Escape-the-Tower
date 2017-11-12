// Superclass ITEM
package Model;
import View.Console;
import java.util.ArrayList;

public class Item 
{
	protected Console view;

	protected int itemId;
	protected String itemName;
	protected String itemDesc;
	protected ArrayList<Gear> gears;
	
	public Item()
	{
		this.itemId = 0;
		this.itemName = "";
		this.itemDesc = "";
	}

	public Item(int itemId, String itemName, String itemDesc) 
	{
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDesc = itemDesc;
	}

	public int getItemId() 
	{
		return itemId;
	}

	public void setItemId(int itemId)
	{
		this.itemId = itemId;
	}

	public String getItemName() 
	{
		return itemName;
	}

	public void setItemName(String itemName) 
	{
		this.itemName = itemName;
	}

	public String getItemDesc()
	{
		return itemDesc;
	}

	public void setItemDesc(String itemDesc)
	{
		this.itemDesc = itemDesc;
	}

	public ArrayList<Gear> getInventory() 
	{
		return gears;
	}

	public void setWeapon(ArrayList<Gear> gear)
	{
		this.gears = gear;
	}

	public void addGear(Gear gear) 
	{
		gears.add(gear);
	}
	
	@Override
	public String toString() 
	{
		return "Item [itemID=" + itemId + ", itemName=" + itemName + ", itemDesc=" + itemDesc + "]";
	}
}