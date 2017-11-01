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
	//new comment
	public void mainMenu() 
	{
		vbox2 = new VBox(10);
		HBox hbox1 = new HBox();

		Label title = new Label();
		
		Image image = new Image("file:mainmenubackground.png");
		BackgroundImage bgImage= new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
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
		
		
		
		
		
		
		//Put below stuff in new class? runs if registration is true?
		vbox1.getChildren().clear();
		
		HBox hbox1 = new HBox();
		HBox hbox2 = new HBox();
		VBox vbox2 = new VBox();
		VBox vbox3 = new VBox();
		
		Label hitPoints = new Label();
		Button inGameMenu = new Button("Menu");
		
		vbox1.getChildren().addAll(hbox1, hbox2);
		hbox1.getChildren().addAll(hitPoints, inGameMenu);
		hbox2.getChildren().addAll(vbox2, vbox3);	
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
