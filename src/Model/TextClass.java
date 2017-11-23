package Model;

public class TextClass
{

	public static void main(String[] args)
	{
		Room room = new Room();
		
		RoomContent roomContent = new RoomContent();
		
		System.out.println(roomContent.room1_26.roomDesc.toString());
	
		roomContent.getRoom(30);
		
		room.getRoomDesc();
		
		roomContent.examineRoom(30);
		
		

	}

}
