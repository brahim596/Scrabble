package View;

import java.awt.Dimension;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FenetreJeuP extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		Parent root=FXMLLoader.load(this.getClass().getResource("/TestFX.fxml"));
		
		
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width  = (int)dimension.getWidth();

	
		Scene scene=new Scene(root);
		stage.setScene(scene);
		stage.setHeight(height);
		stage.setWidth(width);
		stage.setFullScreen(true);
		stage.setMaximized(true);
		stage.show();
	}
	
	public static void main(String[] args)
	{
		launch(FenetreJeuP.class);
	}

}
