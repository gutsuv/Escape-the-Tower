import java.util.*;

public class Player extends Character
{
	View view;
	private int maxAttack;
	private int minAttack;
	private ArrayList<Item> inventory = new ArrayList<Item>();
	private ArrayList<Gear> equippedItems = new ArrayList<Gear>();
	private boolean poisoned = false;
	public Player(View view)
	{
		health = 100;
		maxHealth = 100;
		minAttack = 0;
		defense = 0;
		acc = 100;
		alive = true;
		this.view = view;
	}

	public Player(int health, int minAttack, int defense, int acc, boolean alive, View view)
	{
		this.health = health;
		this.minAttack = minAttack;
		this.defense = defense;
		this.acc = acc;
		this.alive = alive;
		this.view = view;
	}

	public void displayStats()
	{
		view.line(125);
		view.print("Health: " + health + "/" + maxHealth);
		view.print("Max Attack: " + maxAttack);
		view.print("Min Attack: " + minAttack);
		view.print("Defense: " + defense);
		view.print("Accuracy: " + acc + "/100");
	}

	public void updateStats()
	{
		maxAttack = 0;
		minAttack = 0;
		defense = 0;
		acc = 100;
		for (int i = 0; i < equippedItems.size(); i++)
		{
			maxAttack = maxAttack + equippedItems.get(i).getAttackMax();
			minAttack = minAttack + equippedItems.get(i).getAttackMin();
			defense = defense + equippedItems.get(i).getDefense();
			acc = acc - equippedItems.get(i).getAcc();
		}
		if(poisoned)
		{
			minAttack = (minAttack*3)/4;
			maxAttack = (maxAttack*3)/4;
			defense = (defense*3)/4;
			acc = (acc*3)/4;
		}
		displayEquippedItems();
		displayStats();
	}

	@Override
	public int dealDamage()
	{
		if ((Math.random() * 100) < acc)
		{
			return (int) (minAttack + (Math.random() * (1 + maxAttack - minAttack)));
		}
		else
			return 0;
	}

	public void updateMaxHealth(int i)
	{
		maxHealth = maxHealth + i;
	}
	
	public void setPoisoned(boolean poison)
	{
		poisoned = poison;
	}
	
	public boolean isPoisoned()
	{
		return poisoned;
	}

	// Inventory Exists on player so methods for item based things exist here to
	// interact with player items.
	public ArrayList<Item> getInventory()
	{
		return inventory;
	}

	public Item getItem(int i)
	{
		return inventory.get(i);
	}

	public void pickUp(Item item)
	{
		inventory.add(item);
	}

	public void drop(int i)
	{
		for (int j = 0; j < equippedItems.size(); j++)
		{
			if (inventory.get(i) == equippedItems.get(j))
			{
				unequip(j);
			}
		}
		inventory.remove(i);
	}

	public void equip(int i) throws Exception
	{
		equip(inventory.get(i));
	}

	public void equip(Item item) throws Exception
	{
		for (int i = 0; i < equippedItems.size(); i++)
		{
			if (((Gear) item).getItemslot() == equippedItems.get(i).getItemslot())
			{
				if (equippedItems.get(i).getItemslot() != 'e')
				{
					unequip(i);
				}
			}
		}
		for (int i = 0; i < equippedItems.size(); i++)
		{
			if (equippedItems.get(i).getItemId() == item.getItemId())
			{
				unequip(i);
			}
		}
		equippedItems.add((Gear) item);
		updateStats();
	}

	public void unequip(int i)
	{
		equippedItems.remove(i);
	}

	public void displayInventory()
	{
		view.line(125);
		view.print("Items");
		for (int i = 0; i < inventory.size(); i++)
		{
			view.print(i + ": " + inventory.get(i).getDisplay());
		}
		view.print("exit: ");
	}

	public void displayEquippedItems()
	{
		view.line(125);
		view.print(equippedItems);
	}
}