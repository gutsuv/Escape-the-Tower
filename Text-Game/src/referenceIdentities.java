import java.io.*;
import java.util.*;
public class referenceIdentities {
	ArrayList<Item> items = new ArrayList<Item>();
	ArrayList<Room> rooms = new ArrayList<Room>();
	File file;
	Scanner fileread;
	public void loaditems() throws FileNotFoundException {
		file = new File("TextFiles/Gear.txt");
		fileread = new Scanner(file);
		try {
			BufferedReader buff = new BufferedReader(new FileReader(file));
			buff.readLine();
		while(buff.ready()) {
				items.add(new Gear(buff.readLine()));
				System.out.println(items.get(items.size()-1));
			}
		}catch(Exception E) {
				System.out.println("error");}
	}
}	