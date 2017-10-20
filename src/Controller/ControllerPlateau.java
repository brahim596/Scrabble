package Controller;

import java.util.ArrayList;

import Model.Jeton;
import Model.Joueur;
import Model.Partie;
import Model.Plateau;
import Model.Sac;
import View.FenetreJeu;
import View.JetonV;
import View.PlateauV;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerPlateau implements EventHandler<MouseEvent>{

	private Plateau plateau;
	private PlateauV plateauView;
	private Partie partie;
	
	private JetonV jetonv;
	
	public ControllerPlateau(Plateau p,Partie partie)
	{
		plateau=p;
		this.partie=partie;
	}
	
	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	public static void main(String[] args) throws Exception 
	{
		

		Joueur j1=new Joueur(1,"Cr7",0);
		Joueur j2=new Joueur(2,"Messi",0);
	
		ArrayList<Joueur> joueurs=new ArrayList<Joueur>();
		
		Plateau plateau =new Plateau();
		
		Sac sac=new Sac();
		
		j1.getJetons().add(new Jeton('A'));j1.getJetons().add(new Jeton('A'));
		Partie partie=new Partie(joueurs,sac,plateau);
		ControllerPlateau controllerP=new ControllerPlateau(plateau,partie);
		
		
		FenetreJeu fen=new FenetreJeu();
		fen.main(args);
		
		System.out.println("test");
		fen.afficheNomJoueur(j1.getPseudo());
		fen.setInFoJoueur(controllerP.genereJetonV(j1.getJetons()));
		
	}
	

	public ArrayList<JetonV> genereJetonV(ArrayList<Jeton> jetons)
	{
		ArrayList<JetonV> jetonv=new ArrayList<JetonV>();
		for(Jeton jt: jetons)
		{
			jetonv.add(new JetonV(jt.getLettre()));
		}
		
		return jetonv;
	}

	@Override
	public void handle(MouseEvent e) {
	
		
		if(e.getSource().equals(jetonv))
		{
			System.out.println("oooook");
			if(partie.isJoueurJoueTour())
			{
				//System.out.print("OK");
				jetonv.setVisible(false);
			}
		}
		
	}
}
