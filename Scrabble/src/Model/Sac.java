package Model;

import java.io.Serializable;

// Une pioche contitent toute les lettres au début d'une partie

public class Sac implements Serializable {
	private Jeton j;
	private int nbJetons;

	public Sac(Jeton j, int nbJetons) {
		super();
		this.j = j;
		this.nbJetons = nbJetons;
	}

	public int getNbJetons() {
		return nbJetons;
	}

	public void setNbJetons(int nbJetons) {
		this.nbJetons = nbJetons;
	}

}
