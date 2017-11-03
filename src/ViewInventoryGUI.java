import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import java.util.*;

public class ViewInventoryGUI extends Application
{
	Stage st1;
	Scene sc1;
	GridPane g1;
	ArrayList<Item> items = new ArrayList<Item>();
	public ViewInventoryGUI(ArrayList<Item> inventory) throws Exception 
	{
		items = inventory;
		g1 = new GridPane();
		st1 = new Stage();
		sc1 = new Scene(g1,250,(items.size()*25));
		// modify later to match longest item name
		st1.setScene(sc1);
		start(st1);
	}
	@Override
	public void start(Stage stage1) throws Exception 
	{
		int i = items.size();
		Button use,drop;
		Label l;
		while(i>0)
		{
			i--;
			items.get(i).setItemName("normal item name");
			//^^^^ delete later ^^^^
			l = new  Label(items.get(i).getItemName());
			use = new Button();
			if(items.get(i) instanceof Gear) 
			{
				use.setText("Equip");
				//setOnAction(equip(i));
			}else {
				use.setText("use");
				//setOnAction(use(i));
			}
			drop = new Button("Drop");
			//setOnAction(drop(i));
			//these setOnActions will use 
			
			g1.add(use, 0, i);
			g1.add(drop, 1, i);
			g1.add(l, 2, i);
		}
		st1.show();
	}
}