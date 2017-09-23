package Model;

//Cette classe représente une case sur le plateau du Scrabble


public class Case {
	
	private Pion p;
	private String type;
	
	public Case(String t)
	{
		type=t;
	}

	public Pion getP() {
		return p;
	}

	public void setP(Pion p) {
		this.p = p;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
