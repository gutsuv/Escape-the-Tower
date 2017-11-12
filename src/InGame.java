import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class InGame extends MainMenu
{
	public static void beginNewGame()
	{
		vbox1.getChildren().clear();

		// Basic layout
		HBox hbox1 = new HBox();
		HBox hbox2 = new HBox(20);
		VBox vbox2 = new VBox(20);
		VBox vbox3 = new VBox(20);
		
		// Inside vbox 2 and 3
		HBox hbox3 = new HBox();
		HBox hbox4 = new HBox();
		
		// Initializing some buttons and whatnot for stats
		Label hitPoints = new Label("Hitpoints (HP): ");
		Label attackPower = new Label("Attack Power (DMG): ");
		Label defense = new Label("Defense (DEF): ");
		
		ComboBox<String> equipWeapon = new ComboBox<>();
		ComboBox<String> equipArmor = new ComboBox<>();
		
		Button inGameMenu = new Button("Menu");
		Button viewMap = new Button("View Map");
		
		vbox1.getChildren().addAll(hbox1, hbox2);
		hbox1.getChildren().addAll(inGameMenu);
		hbox2.getChildren().addAll(vbox2, vbox3);
		vbox2.getChildren().addAll(hbox3, hbox4);
		vbox3.getChildren().addAll(viewMap, hitPoints, attackPower, defense, equipWeapon, equipArmor);
		
		// hbox1 and children properties
		hbox1.setStyle("-fx-background-color: #382F27;" 
				+ "-fx-border-style: solid inside;"
		        + "-fx-border-width: 1;" + "-fx-border-insets: 0;"
		        + "-fx-border-radius: 1;" + "-fx-border-color: black;");
		hbox1.setPadding(new Insets(5, 5, 5, 20));
		
		inGameMenu.setPrefWidth(150);
		inGameMenu.setPadding(new Insets(5, 10, 5, 10));
		inGameMenu.setStyle("-fx-focus-color: brown;");
		
		
		// hbox2 and children properties
		hbox2.setPadding(new Insets(20, 20, 20, 20));
		vbox2.setStyle("-fx-background-color: #382F27;"
				+ "-fx-border-style: solid inside;"
		        + "-fx-border-width: 1;" + "-fx-border-insets: 0;"
		        + "-fx-border-radius: 1;" + "-fx-border-color: black;");
		vbox2.setPrefSize(600, 600);
		
		vbox3.setStyle("-fx-background-color: #382F27;"
				+ "-fx-border-style: solid inside;"
		        + "-fx-border-width: 1;" + "-fx-border-insets: 0;"
		        + "-fx-border-radius: 1;" + "-fx-border-color: black;");
		vbox3.setPrefSize(360, 600);
		
		// vbox2 properties
		vbox2.setPadding(new Insets(20, 20, 20, 20));
		hbox3.setStyle("-fx-background-color: #56483C;"
				+ "-fx-border-style: solid inside;"
		        + "-fx-border-width: 1;" + "-fx-border-insets: 5;"
		        + "-fx-border-radius: 1;" + "-fx-border-color: black;");
		hbox3.setPrefHeight(235);
		
		hbox4.setStyle("-fx-background-color: #56483C;"
				+ "-fx-border-style: solid inside;"
		        + "-fx-border-width: 1;" + "-fx-border-insets: 5;"
		        + "-fx-border-radius: 1;" + "-fx-border-color: black;");
		hbox4.setPrefHeight(235);
		
		// vbox3 properties
		vbox3.setAlignment(Pos.TOP_CENTER);
		vbox3.setPadding(new Insets(20, 20, 20, 20));
		viewMap.setStyle("-fx-focus-color: brown;");
		viewMap.setMinWidth(300);
		
		hitPoints.setTextFill(Color.WHITE);
		attackPower.setTextFill(Color.WHITE);
		defense.setTextFill(Color.WHITE);
		
		equipWeapon.getItems().addAll("Sample Text");
		equipWeapon.setStyle("-fx-focus-color: brown;");
		equipWeapon.setValue("Sample Default Weapon");
		equipWeapon.setMinWidth(200);
		
		equipArmor.getItems().addAll("Sample Text");
		equipArmor.setStyle("-fx-focus-color: brown;");
		equipArmor.setValue("Sample Default Armor");
		equipArmor.setMinWidth(200);
	
		
	}
}
