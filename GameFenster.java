package Übungen.Pac_Man;

import javax.swing.*;

public class GameFenster extends JFrame {
	
	GameFenster(){
		
		this.add(new GameContainer());
		this.setTitle("SnakeGame");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
