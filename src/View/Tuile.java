package View;

import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tuile extends StackPane {
	
	private double x,y;
	
	
	public Tuile(double xx,double yy,double largeur)
	{
		this.x=xx;
		this.y=yy;
		
		this.setHeight(largeur);
		this.setWidth(largeur);
		
		this.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
		setTranslateX(x);
		setTranslateY(y);
	}
	
	public void setCouleur(Color c)
	{
		this.setBackground(Color.BEIGE);
	}

	private void setBackground(Color beige) {
		// TODO Auto-generated method stub
		
	}
	
}
