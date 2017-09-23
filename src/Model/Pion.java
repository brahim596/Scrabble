package Model;

//Cette classe représente une lettre 

public class Pion {
	
	private char lettre;
	private int point;  // Le nombre de point que rapporte la lettre
	
	public Pion(char l)
	{
		lettre=l;
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
