public class Gear extends Item
{
	protected int defense;
	protected int attack;
	protected char itemslot;
	public Gear() 
	{
		super(// Some things here
				);
		this.defense = 0;
		this.attack = 0;
	}

	public Gear(int itemId, String itemName, String itemDesc, int defense, int attack)
	{
		super(itemId, itemName, itemDesc);
		this.defense = defense;
		this.attack = attack;
	}

	public Gear(int itemId, String itemName, String itemDesc, int defense, int attack, char itemslot)
	{
		super(itemId, itemName, itemDesc);
		this.defense = defense;
		this.attack = attack;
		this.itemslot = itemslot;
	}
	
	public int getDefense() 
	{
		return defense;
	}
	public int getAttack() 
	{
		return attack;
	}
	public char getItemslot()
	{
		return itemslot;
	}

	public void setDefense(int defense) 
	{
		this.defense = defense;
	}
	public void setAttack(int attack)
	{
		this.attack = attack;
	}
	public void setItemslot(char itemslot) {
		this.itemslot = itemslot;
	}
	public void equip()
	{
		
	}

	@Override
	public String toString()
	{
		return "Gear [defense=" + defense + "][attack=" + attack + "]";
	}
}