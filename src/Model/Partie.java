package Model;

import java.util.ArrayList;

public class Partie {

	private ArrayList<Joueur> joueurs;
	private Sac sac;
	private Plateau plateau;
	private Dictionnaire dico;
	
	public Partie(ArrayList<Joueur> joueurs,Sac sac,Plateau plateau)
	{
		this.joueurs=joueurs;
		this.sac=sac;
		this.plateau=plateau;
		
	}
	
	public void designePremierJoueur()
	{
		
	}
	
	public static void main(String[] args)
	{
		Sac sac=new Sac();
		Joueur j1=new Joueur(1,"Cr7",0);
		Joueur j2=new Joueur(2,"Messi",0);
		
		ArrayList<Joueur> joueurs=new ArrayList<Joueur>();
		joueurs.add(j1);
		joueurs.add(j2);
		
		Plateau plateau=new Plateau();
		
		Partie p=new Partie(joueurs,sac,plateau);
	}
}
