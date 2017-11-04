public class Gear extends Item
{
	protected int defense;

	public Gear() 
	{
		super(// Some things here);
		this.defense = 0;
	}

	public Gear(int itemId, String itemName, String itemDesc, int defense)
	{
		super(itemId, itemName, itemDesc);
		this.defense = defense;
	}

	public int getDefense() 
	{
		return defense;
	}

	public void setDefense(int defense) 
	{
		this.defense = defense;
	}
	
	public void equip()
	{
		
	}

	@Override
	public String toString()
	{
		return "Gear [defense=" + defense + "]";
	}
}