import java.io.*;
import java.util.*;
public class referenceIdentities {
	referenceIdentities library; 
	ArrayList<Item> items = new ArrayList<Item>();
	ArrayList<Enemy> enemys = new ArrayList<Enemy>();
	File file;
	Scanner fileread;
	View itemView = new View();
	View enemyView = new View();
	
	public Item cloneItem(int i) throws Exception {
		return (Item) getItem(i).clone();
	}
	// this method clones an item
	public Item getItem(int i) throws Exception{
		for (int j=0; j<items.size();j++) {
			if(items.get(j).getItemId()==i) {
				return items.get(j);
			}
		}
		return null;
	}
	// the method searches for an item based off of item Id
	
	public Enemy cloneEnemy(int i) throws Exception {
		return (Enemy) getEnemy(i).clone();
	}
	//this method clones an enemy
	public Enemy getEnemy(int i) throws Exception{
		for (int j=0; j<items.size();j++) {
			if(enemys.get(j).getEnemyId()==i) {
				return enemys.get(j);
			}
		}
		return null;
	}
	// the method searches for an enemy based off of enemy Id
	
	public void loaditems() throws FileNotFoundException {
		loadGearItems();
		loadConsumables();
		loadPuzzleItems();
	}
	public void loadEnemys() throws FileNotFoundException {
		loadEnemyTable();
	}
	// item load methods
	private void loadGearItems() throws FileNotFoundException {
		file = new File("TextFiles/Gear.txt");
		fileread = new Scanner(file);
		try {
			BufferedReader buff = new BufferedReader(new FileReader(file));
			buff.readLine();
		while(buff.ready()) {
				items.add(new Gear(buff.readLine()));
				items.get(items.size()-1).setView(itemView);
			}buff.close();
		}catch(Exception E) {
				System.out.println("error");}
	}
	private void loadConsumables() throws FileNotFoundException {
		file = new File("TextFiles/Consumable.txt");
		fileread = new Scanner(file);
		try {
			BufferedReader buff = new BufferedReader(new FileReader(file));
			buff.readLine();
		while(buff.ready()) {
				items.add(new Consumable(buff.readLine()));
				items.get(items.size()-1).setView(itemView);
			}buff.close();
		}catch(Exception E) {
				System.out.println("error");}
	}
	private void loadPuzzleItems() throws FileNotFoundException {
		file = new File("TextFiles/PuzzleItem.txt");
		fileread = new Scanner(file);
		try {
			BufferedReader buff = new BufferedReader(new FileReader(file));
			buff.readLine();
		while(buff.ready()) {
				items.add(new PuzzleItem(buff.readLine()));
				items.get(items.size()-1).setView(itemView);
			}buff.close();
		}catch(Exception E) {
				System.out.println("error");}
	}
	// enemy load method
	private void loadEnemyTable()throws FileNotFoundException {
		file = new File("TextFiles/EnemyTable.txt");
		fileread = new Scanner(file);
		try {
			BufferedReader buff = new BufferedReader(new FileReader(file));
			buff.readLine();
		while(buff.ready()) {
				enemys.add(new Enemy(buff.readLine(),library));
				enemys.get(enemys.size()-1).setView(enemyView);
			}buff.close();
		}catch(Exception E) {
				System.out.println("error");}
	}
	
	// this exists for self reference
	public void setLibray(referenceIdentities library){
		this.library = library;
	}
}	