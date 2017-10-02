package View;

import java.awt.Dimension;

import javafx.application.Application;
import javafx.geometry.Dimension2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FenetreJeu extends Application{

	private int largeur,hauteur;
	
	@Override
	public void start(Stage fenetre) throws Exception {
		
		// On récupère la résolution de l'écran
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width  = (int)dimension.getWidth();
		largeur=width;
		hauteur=height;
		
		StackPane layout=new StackPane();
		Plateau p=new Plateau(largeur*0.51);
		p.setAlignment(Pos.CENTER);
		
		
		layout.getChildren().add(p);
		Scene scene=new Scene(layout);
		
		
		fenetre.setScene(scene);
		fenetre.setMaximized(true);
		fenetre.setFullScreen(true);
		fenetre.show();
		
	
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}

}
