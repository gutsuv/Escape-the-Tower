import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class InGame extends MainMenu
{
	public static void beginNewGame()
	{
		vbox1.getChildren().clear();

		HBox hbox1 = new HBox();
		HBox hbox2 = new HBox();
		VBox vbox2 = new VBox();

		Label hitPoints = new Label("Hitpoints: ");
		Button inGameMenu = new Button("Menu");
		
		// hbox1 and children properties
		hbox1.setStyle("-fx-background-color: #5a4930;" 
				+ "-fx-border-style: solid inside;"
		        + "-fx-border-width: 1;" + "-fx-border-insets: 0;"
		        + "-fx-border-radius: 1;" + "-fx-border-color: black;");
		hbox1.setPadding(new Insets(5, 5, 5, 5));
		
		hitPoints.setPadding(new Insets(5, 885, 0, 0));
		hitPoints.setTextFill(Color.WHITE);
		hitPoints.setStyle("-fx-font-weight: bold");
		
		inGameMenu.setPadding(new Insets(5, 10, 5, 10));
		inGameMenu.setStyle("-fx-focus-color: brown;");
		
		// hbox2 Properties

		vbox1.getChildren().addAll(hbox1, hbox2);
		hbox1.getChildren().addAll(hitPoints, inGameMenu);
		hbox2.getChildren().addAll(vbox2);	
	}
}
