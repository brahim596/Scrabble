package View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Accueil extends Application{

	Button button;
	
	@Override
	public void start(Stage accueil) throws Exception {
		
		accueil.setTitle("Accueil");
		button = new Button();
		button.setText("Test");
		
		StackPane layout=new StackPane();
		layout.getChildren().add(button);
		
		Scene scene=new Scene(layout);
		accueil.setScene(scene);
		accueil.setMaximized(true);
		accueil.setFullScreen(true);
		accueil.show();
		
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
