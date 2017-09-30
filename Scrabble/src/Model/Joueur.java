package Model;

import java.io.Serializable;

public class Joueur implements Serializable {

	private int id;
	private String pseudo;
	private int score;

	public Joueur(int id, String pseudo, int score) {
		this.id = id;
		this.pseudo = pseudo;
		this.score = score;
	}

	public String getPseudo() {
		return pseudo;
	}

	public int getId() {
		return id;
	}

	public int getScore() {
		return score;
	}

}
