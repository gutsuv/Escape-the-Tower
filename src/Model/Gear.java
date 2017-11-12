// Subclass

package Model;

public class Gear extends Item
{
	protected int gearId;
	protected int defense;
	protected int attack;
	protected String type;

	public Gear() 
	{
		super(0, "", "");
		this.gearId = 0;
		this.defense = 0;
		this.attack = 0;
		this.type = "";
	}

	public Gear(int itemId, String itemName, String itemDesc, int gearId, int defense, int attack, String type)
	{
		super(itemId, itemName, itemDesc);
		this.gearId = gearId;
		this.defense = defense;
		this.attack = attack;
		this.type = type;
	}

	public int getGearId()
	{
		return gearId;
	}

	public void setGearId(int gearId) 
	{
		this.gearId = gearId;
	}

	@Override
	public String toString()
	{
		return "Gear [gearId=" + gearId + ", defense=" + defense + ", attack=" + attack + ", type=" + type + "]";
	}
}