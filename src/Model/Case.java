package Model;

//Cette classe représente une case sur le plateau du Scrabble


public class Case {
	
	private Jeton p; // Une case peut contenir un jeton 
	private String type; // Il existe plusieurs type : MT (mot compte triple) MD (mot compte double) LT (lettre compte triple) LD (lettre double) 
	
	public Case(String t)
	{
		type=t;
	}

	public Jeton getP() {
		return p;
	}

	public void setP(Jeton p) {
		this.p = p;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
