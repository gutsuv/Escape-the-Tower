import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class NewGame extends MainMenu
{
	static Stage primaryStage2 = new Stage();
	static boolean registration = false;
	
	static MainMenu main = new MainMenu();
	
	public static void newGame()
	{
		vbox1.getChildren().clear();
		
		if(registration == false)
		{
			NewGame.selectFile();
		}
		
		if(registration == true)
		{
			InGame.beginNewGame();
		}
	}
	
	public static void selectFile() 
	{
		VBox vbox3 = new VBox(20);
		
		Button saveOne = new Button("Save File 1 - Save new game");
		Button saveTwo = new Button("Save File 2 - Save new game");
		Button saveThree = new Button("Save File 3 - Save new game");
		
		saveOne.setMaxWidth(200);
		saveOne.setStyle("-fx-focus-color: brown;");
		saveTwo.setMaxWidth(200);
		saveTwo.setStyle("-fx-focus-color: brown;");
		saveThree.setMaxWidth(200);
		saveThree.setStyle("-fx-focus-color: brown;");
		
		vbox3.getChildren().addAll(saveOne, saveTwo, saveThree);
		vbox3.setAlignment(Pos.CENTER);
		vbox3.setStyle("-fx-border-style: solid inside;"
		        + "-fx-border-width: 1;" + "-fx-border-insets: 0;"
		        + "-fx-border-radius: 1;" + "-fx-border-color: black;");
		
		saveOne.setOnAction(e -> fileSelected(1));
		saveTwo.setOnAction(e -> fileSelected(2));
		saveThree.setOnAction(e -> fileSelected(3));

		Scene dialogScene = new Scene(vbox3, 350, 300);
		primaryStage2.setTitle("Escape the Tower");
		primaryStage2.setScene(dialogScene);
		primaryStage2.setResizable(false);
		primaryStage2.show();

		primaryStage2.getIcons().add(new Image("file:skullicon.png"));	

		Image image = new Image("file:mainmenubackground.png");
		BackgroundImage bgImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		vbox3.setBackground(new Background(bgImage));
		
		primaryStage2.setOnCloseRequest(new EventHandler<WindowEvent>() 
		{
			public void handle(WindowEvent we) 
			{
				main.mainMenu();
			}
		}); 
	}
	
	public static void fileSelected(int saveSlotSelected) 
	{
		saveSlot = saveSlotSelected;
		primaryStage2.close();
		registration = true;
		NewGame.newGame();
	}
}
