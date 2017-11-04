

public class Consumable extends Item
{	
	protected int healthEffect;	
	protected int maxHealthEffect;
	
	public Consumable() 
	{
		//super(// Some things here);
		this.healthEffect = 0;
		this.maxHealthEffect = 0;
	}

	public Consumable(int itemID, String itemName, String itemDesc, int healthEffect, int maxHealthEffect) 
	{
		super(itemID, itemName, itemDesc);
		this.healthEffect = healthEffect;
		this.maxHealthEffect = maxHealthEffect;
	}

	public int getHealthEffect() 
	{
		return healthEffect;
	}

	public void setHealthEffect(int healthEffect) 
	{
		this.healthEffect = healthEffect;
	}
	
	public void use()
	{
		
	}

	@Override
	public String toString() 
	{
		return "Consumable [healthEffect=" + healthEffect + "]";
	}
}