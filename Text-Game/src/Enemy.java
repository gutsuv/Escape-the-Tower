import java.util.*;
public class Enemy extends Character implements Cloneable
{
	private String name;
	private String enemyDesc;
	private int enemyId;
	View view;
	protected ArrayList<Item> item = new ArrayList<Item>();
	public Enemy(String loadedString, referenceIdentities library)
	{
		//loaded from file
		//int enemyId, String name, int health, int damage, int defense, 
		//int acc, Item itemId, String enemyDescription
		try 
		{
			String[] splitString = loadedString.split("-_");
			enemyId = Integer.parseInt(splitString[0]);
			name = splitString[1];
			health = Integer.parseInt(splitString[2]);
			damage = Integer.parseInt(splitString[3]);
			defense = Integer.parseInt(splitString[4]);
			acc = Integer.parseInt(splitString[5]);
			if(splitString[6].equalsIgnoreCase("")) {}
			else {
				String [] ints = splitString[6].split("><");
				int i = ints.length;
				while(i>0) {
					i--;
					item.add(library.cloneItem(Integer.parseInt(ints[i])));}
				}
			enemyDesc = splitString[7];
			
			
		}catch(Exception E)
		{
			System.out.println("Text Spencer Williams to fix this. I might have messed up a TextFile."
					+ "I can fix it in like 30 minutes. Include Gear in the text message");
		}
		
	}

	public String getEnemyDesc()
	{
		return enemyDesc;
	}
	
	public int getEnemyId()
	{
		return enemyId;
	}
	public void setView(View view) 
	{
		this.view = view;
	}
	
	public ArrayList<Item> getItems(){
		return item;
	}
	@Override
	public String toString()
	{
		return "Enemy [" + name + ", " +enemyDesc+"]";
	}
	
	protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

	@Override
	public int dealDamage() {
		if((Math.random()*10)>acc){
			return damage;
		}
		else return 0;
	}
}