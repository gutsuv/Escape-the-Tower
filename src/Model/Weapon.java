public class Weapon extends Gear
{
	protected int attack;

	public Weapon() 
	{
		super();
		this.attack = 0;
	}

	public Weapon(int itemID, String itemName, String itemDesc, int attack) 
	{
		super(itemID, itemName, itemDesc, attack);
		this.attack = attack;
	}
	
	public int getAttack()
	{
		return attack;
	}

	public void setAttack(int attack)
	{
		this.attack = attack;
	}

	@Override
	public String toString()
	{
		return "Weapon [attack=" + attack + "]";
	}
}