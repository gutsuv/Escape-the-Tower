import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.ColumnConstraintsBuilder;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestStage extends Application
{
	static VBox vbox1 = new VBox();

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		MainMenu main = new MainMenu();
		
		main.mainMenu();
		
		Scene scene = new Scene(vbox1, 600, 400);
		primaryStage.getIcons().add(new Image("file:skullicon.png"));
		primaryStage.setResizable(false);
		primaryStage.setTitle("Escape the Tower");
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		Application.launch(args);
	}
}
