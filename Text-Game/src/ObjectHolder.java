import java.util.*;
import java.io.*;
public class ObjectHolder {
	View view;
	
	ArrayList<Room> rooms = new ArrayList<Room>();
	File file;
	Scanner fileread;
	
	Room currentRoom;
	referenceIdentities library = new referenceIdentities();
	
	
	public ObjectHolder(View v) throws FileNotFoundException {
		view = v;
		file = new File("TextFiles/RoomsA.txt");
		fileread = new Scanner(file);
		int i = 0;
		while(fileread.hasNextLine()) {
			try {
				rooms.add(new Room(fileread.nextLine()));
				rooms.get(i).setView(view);
				i++;
			}catch(Exception E) {
				System.out.println("error " + i);}}
		try {
			rooms.get(30).setLocked(true);
		}catch(Exception E){System.out.println("Final door error");}
		fileread.close();
		library.loaditems();
	}
	
	
	public void initializeNew() {
		currentRoom = rooms.get(0);
		
		
		
		//ey code here
		
		
	}
	public void navigate(char direction) {
		int i = currentRoom.getDirections().length;
		while(i>0) {
			i--;
			if(direction==currentRoom.getDirection(i)) {
				if(rooms.get(i).isLocked()) {
					view.print("locked");
				}else {setCurrentRoom(currentRoom.getExit(i));}
				
			}
		}
	}
	
	public void setCurrentRoom(int i) {
		currentRoom = rooms.get(i-1);
		if(currentRoom.getRoomId()==31) {
			view.print("You won");
			System.exit(0);}
		view.print(getCurrentRoom().toString());
		currentRoom.showPaths();
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
}
