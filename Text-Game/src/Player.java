import java.util.*;

public class Player extends Character
{
	View view;
	int maxAttack;
	int minAttack;
	ArrayList<Item> inventory = new ArrayList<Item>();
	ArrayList<Gear> equippedItems = new ArrayList<Gear>();
	public Player(View view) {
		health = 100;
		maxHealth = 100;
		minAttack = 0;
		defense = 0;
		acc = 100;
		alive = true;
		this.view=view;
	}
	public Player(int health, int minAttack, int defense, int acc, boolean alive, View view) {
		this.health = health;
		minAttack = minAttack;
		this.defense = defense;
		this.acc = acc;
		this.alive = alive;
		this.view = view;
	}
	public void displayStats() {
		view.line(125);
		view.print("Health: "+health+"/"+maxHealth);
		view.print("Max Attack: "+maxAttack);
		view.print("Min Attack: "+minAttack);
		view.print("Defense: "+defense);
		view.print("Accuracy: "+acc+"/100");
	}
	private void updateStats()
	{
		maxAttack=0;minAttack=0;defense=0;acc=100;
		for(int i=0;i<equippedItems.size();i++) {
			maxAttack=+equippedItems.get(i).getAttackMax();
			minAttack=+equippedItems.get(i).getAttackMin();
			defense= equippedItems.get(i).getDefense();
			acc= 100 - equippedItems.get(i).getAcc();
		}
		displayEquippedItems();
		displayStats();
	}
	@Override
	public int dealDamage() {
		if((Math.random()*100)>acc){
			return (int) (minAttack +
					(Math.random()*(maxAttack - minAttack)));
		}
		else return 0;
	}
	public void updateMaxHealth(int i) 
	{
		maxHealth =+ i;
	}
	//Inventory Exists on player so methods for item based things exist here to interact with player items.
	public Item getItem(int i){
		return inventory.get(i);
	}
	public void pickUp(Item item) {
		inventory.add(item);
	}
	public void drop(int i) {
		for(int j=0;j<equippedItems.size();j++) {
			if (inventory.get(i)==equippedItems.get(j)) {
				unequip(j);
			}
		}
		inventory.remove(i);
	}
	public void equip(int i) throws Exception{
		equip(inventory.get(i));
	}
	public void equip(Item item) throws Exception{
		for(int i=0; i<equippedItems.size();i++) {
			if(((Gear)item).getItemslot()==equippedItems.get(i).getItemslot())
			{if(equippedItems.get(i).getItemslot()!='e')
			{unequip(i);}}}
		for(int i=0; i<equippedItems.size();i++) {
			if (equippedItems.get(i).getItemId()==item.getItemId()) 
			{unequip(i);}}
		equippedItems.add((Gear) item);
		updateStats();
	}
	public void unequip(int i) {
		equippedItems.remove(i);
	}
	public void displayInventory() {
		view.line(125);
		view.print("Items");
		for(int i = 0; i<inventory.size();i++) {
			view.print(i+": "+inventory.get(i).getDisplay());
		}
		view.print("exit: ");
	}
	public void displayEquippedItems() {
		view.line(125);
		view.print(equippedItems);
	}
}