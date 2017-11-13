import java.util.*;
import java.io.*;
public class TestingVariables {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/TextFiles/RoomsA.txt");
		Scanner fileread = new Scanner(file);
		ArrayList<Room> rooms = new ArrayList<Room>();
		rooms.add(new Room(fileread.nextLine()));

		int i = 0;
		while(fileread.hasNextLine()) {
			try {
			rooms.add(new Room(fileread.nextLine()));
			System.out.println(rooms.get(i).getRoomId());
			System.out.println(rooms.get(i).getRoomDescription());
			System.out.println(rooms.get(i).getDoorsString());
			rooms.get(i).TestDoorDescriptionString();
			i++;
			System.out.println("------------------");
		}catch(Exception E) {System.out.println("error "+i);}}
	}

}
