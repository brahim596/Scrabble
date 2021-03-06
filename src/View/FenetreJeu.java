package View;

import java.awt.Dimension;
import java.util.ArrayList;

import Controller.ControllerPlateau;
import Model.Jeton;
import Model.Joueur;
import Model.Partie;
import Model.Plateau;
import Model.Sac;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FenetreJeu extends Application{

	private int largeur,hauteur;
	private TextField motjoue;
	private InfoJoueur ij;
	private PlateauV p;
	private ControllerPlateau cp;
	

	public PlateauV getP() {
		return p;
	}

	public void setP(PlateauV p) {
		this.p = p;
	}
	
	@Override
	public void start(Stage fenetre) throws Exception {
		
		// On r�cup�re la r�solution de l'�cran
		
		
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width  = (int)dimension.getWidth();
		largeur=width;
		hauteur=height;
		
		
		p=new PlateauV(largeur*0.41);
		p.setTranslateX(largeur*0.08);
		p.setTranslateY(-hauteur*0.05);
		
		
		motjoue=new TextField("");
		motjoue.setMaxWidth(largeur*0.35);
		motjoue.setMaxHeight(hauteur*0.05);
		motjoue.setTranslateY(hauteur*0.43);
		motjoue.setFocusTraversable(false);
		motjoue.setPromptText("Entr�e un mot");
		motjoue.autosize();
		
		
		MenuCommande mc=new MenuCommande(height,width);
		mc.setTranslateY(height*0.2);
		mc.setTranslateX(-width*0.4);
		
		StackPane layout=new StackPane();
		
		ij=new InfoJoueur();
		ij.setAlignment(Pos.TOP_LEFT);
		//ij.afficheInfoJetons();
		ij.afficheNom("Killua");
		layout.getChildren().addAll(p,motjoue,mc,ij);
		
		Joueur j1=new Joueur(1,"Cr7",0);
		Joueur j2=new Joueur(2,"Messi",0);
		
		ArrayList<Joueur> joueurs=new ArrayList<Joueur>();
		
		Plateau plateau =new Plateau();
		
		Sac sac=new Sac();
		
		j1.getJetons().add(new Jeton('A'));j1.getJetons().add(new Jeton('A'));
		Partie partie=new Partie(joueurs,sac,plateau);
		
		ControllerPlateau controllerP=new ControllerPlateau(plateau,partie);
		ij.afficheInfoJetons(controllerP.genereJetonV(j1.getJetons()));
		ij.setControllerJetonV(controllerP);
		
		Scene scene=new Scene(layout);
		
		fenetre.setScene(scene);
		fenetre.setMaximized(true);
		fenetre.setFullScreen(true);
		fenetre.show();
		
		
	
	}
	
	public InfoJoueur getIj() {
		return ij;
	}

	public void setIj(InfoJoueur ij) {
		this.ij = ij;
	}

	public void setInFoJoueur(ArrayList<JetonV> jv)
	{
		ij.afficheInfoJetons(jv);
	}
	
	public void afficheNomJoueur(String n)
	{
		ij.afficheNom(n);
	}
	
	public static void main(String[] args)
	{
		
		launch(args);
		
	}

}
