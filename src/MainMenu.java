import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MainMenu extends TestStage
{
	static VBox vbox2 = new VBox();
<<<<<<< HEAD
	
	static int saveSlot;
	
=======
>>>>>>> 287824579ccf74025ccbb3362ceee70c7598b514
	public void mainMenu() 
	{
		vbox2 = new VBox(10);
		HBox hbox1 = new HBox();

		Label title = new Label();
		
		Image image = new Image("file:mainmenubackground.png");
		BackgroundImage bgImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		vbox1.setBackground(new Background(bgImage));
		
		try
		{
			Image image2 = new Image(new FileInputStream("title.png"));
			title.setGraphic(new ImageView(image2));
		} 
		catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}

		Button newGameButton = new Button("New Game");
		Button loadGameButton = new Button("Load Game");
		Button helpMenuButton = new Button("Help Menu");
		Button exitGameButton = new Button("Exit Game");
		
		newGameButton.setMaxWidth(200);
		newGameButton.setStyle("-fx-focus-color: brown;");
		loadGameButton.setMaxWidth(200);
		loadGameButton.setStyle("-fx-focus-color: brown;");
		helpMenuButton.setMaxWidth(200);
		helpMenuButton.setStyle("-fx-focus-color: brown;");
		exitGameButton.setMaxWidth(200);
		exitGameButton.setStyle("-fx-focus-color: brown;");
		
		vbox1.getChildren().addAll(hbox1, vbox2);
		vbox2.getChildren().addAll(newGameButton, loadGameButton, helpMenuButton, exitGameButton);
		hbox1.getChildren().addAll(title);
		
		VBox.setMargin(hbox1, new Insets(30, 0, 60, 0));
		hbox1.setAlignment(Pos.CENTER);
		title.setFont(new Font("Times New Roman", 30));
		
		vbox2.setAlignment(Pos.CENTER);
		
		newGameButton.setOnAction(e -> {NewGame.newGame(); });
		loadGameButton.setOnAction(e -> {LoadGame.loadGame(); });
		helpMenuButton.setOnAction(e -> {HelpMenu.helpMenu(); });
		exitGameButton.setOnAction(e -> {ExitGame.exitGame(); });
	}
}