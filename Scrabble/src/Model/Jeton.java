package Model;

import java.io.Serializable;

//Cette classe représente une lettre 

public class Jeton implements Serializable {

	private char lettre;
	private int point; // Le nombre de point que rapporte la lettre

	public Jeton(char lettre, int point) {
		super();
		this.lettre = lettre;
		this.point = point;
	}

	public char getLettre() {
		return lettre;
	}

	public void setLettre(char lettre) {
		this.lettre = lettre;
	}

	public int getPoint() {
		return point;
	}

}
