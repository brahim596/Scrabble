package Model;

import java.io.Serializable;

//Cette classe représente une case sur le plateau du Scrabble

public class Case implements Serializable {

	private Jeton j;
	private String type;

	public Case(String t) {
		type = t;
	}

	public Case(Jeton j, String type) {
		super();
		this.j = j;
		this.type = type;
	}

	public Jeton getJeton() {
		return j;
	}

	public void setJeton(Jeton j) {
		this.j = j;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
