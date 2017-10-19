import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestStage extends Application
{
	static VBox vbox1 = new VBox();
	
	public VBox getVbox1()
	{
		return vbox1;
	}

	public void setVbox1(VBox vbox1)
	{
		TestStage.vbox1 = vbox1;
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		MainMenu.mainMenu();
		
		Scene scene = new Scene(vbox1, 600, 400);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Text Based Adventure Game");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		Application.launch(args);
	}
}
