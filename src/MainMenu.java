import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MainMenu extends TestStage
{
	static VBox vbox2 = new VBox();
	
	public static void mainMenu()
	{
		vbox2 = new VBox(10);
		HBox hbox1 = new HBox();
		Label title = new Label("Escape the Tower");

		Button newGameButton = new Button("New Game");
		Button loadGameButton = new Button("Load Game");
		Button helpMenuButton = new Button("Help Menu");
		Button exitGameButton = new Button("Exit Game");
		
		vbox1.getChildren().addAll(hbox1, vbox2);
		vbox2.getChildren().addAll(newGameButton, loadGameButton, helpMenuButton, exitGameButton);
		hbox1.getChildren().addAll(title);
		
		VBox.setMargin(hbox1, new Insets(30, 0, 60, 0));
		hbox1.setAlignment(Pos.CENTER);
		title.setFont(new Font("Times New Roman", 30));
		
		vbox2.setAlignment(Pos.CENTER);
		
		newGameButton.setOnAction(e -> {MainMenu.newGame(); });
		loadGameButton.setOnAction(e -> {MainMenu.loadGame(); });
		helpMenuButton.setOnAction(e -> {MainMenu.helpMenu(); });
		exitGameButton.setOnAction(e -> {MainMenu.exitGame(); });
	}
	
	public static void newGame()
	{
		MainMenu.vbox1 = new VBox();
		
		HBox hbox1 = new HBox();
		HBox hbox2 = new HBox();
		VBox vbox2 = new VBox();
		VBox vbox3 = new VBox();
		
		
		
		
		
	}
	
	public static void loadGame()
	{
		
	}
	
	public static void helpMenu()
	{
		
	}
	
	public static void exitGame()
	{
		System.exit(0);
	}
	
	
}
