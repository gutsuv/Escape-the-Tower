import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MainMenu extends TestStage
{
	public static void mainMenu()
	{
		VBox vbox2 = new VBox(10);
		HBox hbox1 = new HBox();
		Label title = new Label("Text Based Adventure Game");

		Button newGame = new Button("New Game");
		Button loadgame = new Button("Load Game");
		Button helpMenu = new Button("Help Menu");
		Button exitGame = new Button("Exit Game");
		
		vbox1.getChildren().addAll(hbox1, vbox2);
		vbox2.getChildren().addAll(newGame, loadgame, helpMenu, exitGame);
		hbox1.getChildren().addAll(title);
		
		VBox.setMargin(hbox1, new Insets(30, 0, 60, 0));
		hbox1.setAlignment(Pos.CENTER);
		title.setFont(new Font("Times New Roman", 30));
		
		vbox2.setAlignment(Pos.CENTER);
	}
}
