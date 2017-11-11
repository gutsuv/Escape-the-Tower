// Subclass

package Model;
import View.Console;

public class Consumable extends Item
{
	Console view;
	
	protected int healthEffect;
	protected int maxHealthEffect;
	
	public Consumable()
	{
		super(0, "", "");
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

	public int getMaxHealthEffect()
	{
		return maxHealthEffect;
	}

	public void setMaxHealthEffect(int maxHealthEffect)
	{
		this.maxHealthEffect = maxHealthEffect;
	}
	
	@Override
	public String toString()
	{
		return "Gear [healthEffect=" + healthEffect + "]";
	}
}