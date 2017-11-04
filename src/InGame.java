import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class InGame extends MainMenu
{
	public static void beginNewGame()
	{
		vbox1.getChildren().clear();

		HBox hbox1 = new HBox();
		HBox hbox2 = new HBox();
		VBox vbox2 = new VBox();
		VBox vbox3 = new VBox();

		Label hitPoints = new Label("Hitpoints: ");
		Button inGameMenu = new Button("Menu");
		
		// hbox1 and children properties
		hbox1.setSpacing(10);
		hbox1.setStyle("-fx-background-color: #336699;");
		inGameMenu.setPadding(new Insets(5, 10, 5, 10));
		
		// hbox2 Properties

		vbox1.getChildren().addAll(hbox1, hbox2);
		hbox1.getChildren().addAll(hitPoints, inGameMenu);
		hbox2.getChildren().addAll(vbox2, vbox3);	
	}
}
