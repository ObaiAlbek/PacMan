package Übungen.Pac_Man;
import java.awt.*;

public class SpielKarte extends Rectangle {
	
	SpielKarte(int x, int y, int width, int height){
		super(x,y,width,height);
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	
	

	
	
	
}
