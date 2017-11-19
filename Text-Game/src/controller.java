import java.util.Scanner;

public class controller {
	Scanner control = new Scanner(System.in);
	ObjectHolder model;
	View menuView = new View();
	public controller(ObjectHolder main) {
		model = main;
		while(true) {
			determine(control.nextLine());
		}
	}
	public void controllerItem() {
		while(true) {
			model.getUser().displayInventory();
			if(determineItem(control.next())==true) {break;}
		}
	}
	public void controllerItem(int i) {
		model.getUser().getItem(i).displayCommands();
		determineItem(control.next(),i);
	}
	private void determine(String input) {
		if(input.length()==1) {
			try {navigate(input);}catch(Exception E) {}}
		else if(input.matches("pick up")){
			pickUpAll();}
		else if(input.matches("inventory")) {
			controllerItem();}
		else if(input.matches("stats")) {
			model.getUser().displayStats();
			model.getUser().displayEquippedItems();
		}
	}
	private boolean determineItem(String input) {
		if(input.matches("[0-9]+")) {
			try{controllerItem(Integer.parseInt(input));}
			catch(Exception E) {}
		}
		if(input.matches("exit"))
		{
			try{model.getCurrentRoom().display();}catch(Exception E) {}
			return true;
		}
		return false;
	}
	private boolean determineItem(String input, int i) {
		try {
		if(input.matches("exit")) {return true;}
		else if(input.matches("use")) {
			if(model.getUser().getItem(i) instanceof Consumable) {
				model.getUser().receiveDamage(-((Consumable)model.getUser().getItem(i)).getHealthEffect());
				model.getUser().updateMaxHealth(-((Consumable)model.getUser().getItem(i)).getMaxHealthEffect());
				model.getUser().drop(i);
			}
			if(model.getUser().getItem(i) instanceof PuzzleItem) {}
			//model.getUser().getItem(i).use();
			//ran into problem. AoK work around
			return true;}
		else if(input.matches("drop")) {
			model.currentRoom.addItem(model.getUser().getItem(i));
			model.getUser().getItem(i).drop();//this part of code does nothing most of the time
			model.getUser().drop(i);
			return true;}
		else if(input.matches("equip")) {
			model.getUser().equip(i);
			return true;}
		else if(input.matches("examine")) {
			model.getUser().getItem(i).examine();
			return true;}
		}catch(Exception E) {}
		return false;
	}
	private boolean determineEnemy(String input) {
		if(input.matches("exit")) {
			return true;}
		
		return false;
	}
	private void navigate(String input) throws Exception {
		model.navigate(input.charAt(0));
	}
	private void pickUpAll() {
		while(model.getCurrentRoom().getItems().size()>0) {
			model.getUser().pickUp(
					model.getCurrentRoom().getItems().get(0));
			model.getCurrentRoom().getItems().remove(0);
		}
		try {model.getCurrentRoom().display();} catch (Exception e) {}
	}
	
}
