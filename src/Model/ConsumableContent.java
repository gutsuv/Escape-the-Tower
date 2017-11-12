package Model;

import java.util.ArrayList;
import View.Console;

public class ConsumableContent
{
	Console view;
	public String consumableId;
	public String consumableName;
	public String consumableDesc;
	public int consumableUse;
	
	private ArrayList<Item> inventory = new ArrayList<Item>();


	public ArrayList<Item> getinventory() 
	{
		return inventory;
	}

	public void addItem(Item item)
	{
		inventory.add(item);
	}
	
	public void removeItem(String item) 
	{
		Item i = this.search(item);
		if (i != null)
		{
			inventory.remove(i);
		}
	}

	public Item search(String name) 
	{
		Item item = null;
		for (Item i : inventory) 
		{
			if (i.getItemName().equalsIgnoreCase(name)) 
			{
				item = i;
			}
		}
		return item;
	}
	
	int exampleId = 1;
	String exampleName = "name";
	String exampleDesc = "Description";
	int exampleUse = 5;
	
	int example2Id = 1;
	String example2Name = "name";
	String example2Desc = "Description";
	int example2Use = 5;

	int[] consumableIdArray = {exampleId, example2Id};
	String[] consumableNameArray = {exampleName, example2Name};
	String[] consumableDescArray = {exampleDesc, example2Desc};
	int[] consumableUseArray = {example2Use, example2Use};

	public String[] getConsumableName() 
	{
		return consumableNameArray;
	}

	public void setConsumableName(String[] consumableNameArray) 
	{
		this.consumableNameArray = consumableNameArray;
	}

	public String[] getConsumableDesc() 
	{
		return consumableDescArray;
	}
	
	public void setConsumableDesc(String[] consumableDescArray) 
	{
		this.consumableDescArray = consumableDescArray;
	}
	
	public void getConsumable(double consumable)
	{
		if(consumable == 1) 
		{
			view.println(exampleDesc); 
		}
		else if (consumable == 2)
		{
			view.println(example2Desc);
		}			
		else
		{
			view.println("No Items");
		}
	}

	public void setConsumableDescription(double consumable) 
	{
		if(consumable == 1)
		{
			consumableDesc = exampleDesc; 
		}
		else if (consumable == 2)
		{
			view.println(exampleDesc);
		}
		else if (consumable == 3)
		{
			view.println(example2Desc);
		}
		else
		{
			view.println("No Items");
		}
	}

	public void getConsumableName(double consumable)
	{
		if(consumable == 1)
		{
			consumableName = exampleDesc; 
		}
		else if (consumable == 2)
		{
			consumableName = example2Desc; 
		}
		else
		{
			view.println("No Items");
		}
	}
}