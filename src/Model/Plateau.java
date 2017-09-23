package Model;

public class Plateau {

	private Case[][] plateau;
	
	public Plateau()
	{
		
		setPlateau(new Case[15][15]);
		
		for(int i=0;i<15;i++)
		{
			for(int y=0;y<15;y++)
			{
				
				if(i==0)
				{
					
					
				}
				
				
				
				
			}
		}
	}

	public Case[][] getPlateau() {
		return plateau;
	}

	public void setPlateau(Case[][] plateau) {
		this.plateau = plateau;
	}
}
