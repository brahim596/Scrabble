package Model;

public class Plateau {

	private Case[][] plateau;
	
	public Plateau()
	{
		
		
	}
	
	public void Construire_Tableau(){
		
		setPlateau(new Case[15][15]);
		
		for(int i=0;i<15;i++)
		{
			for(int y=0;y<15;y++)
			{
				
				if(i==0)
				{
					switch (y){
					
					case 0: plateau[i][y]=new Case("MT");break;
					case 3: plateau[i][y]=new Case("LD");break;
					case 7: plateau[i][y]=new Case("MT");break;
					case 11: plateau[i][y]=new Case("LD");break;
					case 14: plateau[i][y]=new Case("MT");break;
					default:plateau[i][y]=new Case("");break;
					
					}
					
				}
				else if(i==1)
				{
					switch (y){
					
					case 1: plateau[i][y]=new Case("MD");break;
					case 5: plateau[i][y]=new Case("LT");break;
					case 9: plateau[i][y]=new Case("LT");break;
					case 13: plateau[i][y]=new Case("MD");break;
					default:plateau[i][y]=new Case("");break;
					
					}
				}
				else if(i==2)
				{
					switch (y){
					
					case 2: plateau[i][y]=new Case("MD");break;
					case 6: plateau[i][y]=new Case("LD");break;
					case 8: plateau[i][y]=new Case("LD");break;
					case 12: plateau[i][y]=new Case("MD");break;
					default:plateau[i][y]=new Case("");break;
					
					}
				}
				else if(i==3)
				{
					switch (y){
					case 0: plateau[i][y]=new Case("LD");break;
					case 3: plateau[i][y]=new Case("MD");break;
					case 7: plateau[i][y]=new Case("LD");break;
					case 11: plateau[i][y]=new Case("MD");break;
					case 14: plateau[i][y]=new Case("LD");break;
					default:plateau[i][y]=new Case("");break;
					
					}
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
