import java.util.*;

public class Model {
	/*
	 * This class holds game stuff
	 * when the game is loaded,
	 * load rooms and other variables here
	 * format I recommend is something along the lines of
	 *<roomId/array[1],array[2],array[3]/other>
	 *it's an example of how to do it
	 * use the split command for "/" and ","
	 * divide it into from 1 to 1/1/1 to 1/1,1,1,/1
	 * 
	 * loaded from file
	 */
	Map<Double,Room> roomsmap = new HashMap<>();
	ArrayList<Item> inventory = new ArrayList<Item>();
	Room currentRoom;
	public Model() throws Exception 
	{
		//delete this code vvvv
		Room r1 = new Room(1.0,false,"","");
		roomsmap.put(r1.getRoomId(),r1);
		//delete this code ^^^^
		//delete this code vvvv
		inventory.add(new Item());
		inventory.add(new Item());
		inventory.add(new Item());
		ViewInventoryGUI v =new ViewInventoryGUI(inventory);
		//delete this code ^^^^
	}
	
}
