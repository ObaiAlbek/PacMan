package Übungen.Pac_Man;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;

public class GameContainer extends JPanel implements Runnable {
	final static int WIDTH_WINDOW = 1000;
	final static int HEIGH_WINDOW = 700;
	Dimension fensterSize = new Dimension(WIDTH_WINDOW,HEIGH_WINDOW);
	PacMan pacman;
	
	Geist[] geists = new Geist[3];
	
	ArrayList<SpielKarte> waende;
	int[] x_pos = {116,95,230,230,650,755,650,755,230,230,878,720,107,107,878,731};
	int[] y_pos = {62,62,150,150,150,150,450,340,350,455,66,66,372,527,372,527};
	int[] width = {169,22,120,15,120,15,120,15,15,120,22,169,22,169,22,169};
	int[] height = {22,169,15,120,15,120,15,120,120,15,169,22,169,22,169,22};


			
	Thread game;
	
	
	GameContainer(){
		this.waende = new ArrayList<>();
		draw_waende();
		draw_pacman();
		this.setFocusable(true);
		this.setPreferredSize(fensterSize);
		this.addKeyListener(new Steuern());
		game = new Thread(this);
		game.start();
		
	}
	
	public void draw_pacman() {
		pacman = new PacMan(WIDTH_WINDOW/2,HEIGH_WINDOW/2);
	}
	
	public void draw_Geist() {
		
	}
	
	public void draw_waende() {
		
		for (int i = 0; i < 16; i++)
			waende.add(new SpielKarte(x_pos[i],y_pos[i],width[i],height[i]));

		
	}
	
	public void draw_Essen() {
		
	}
	
	public void paint(Graphics g) {
		// Screen
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH_WINDOW, HEIGH_WINDOW);
		
		// Zeichne die Wände
		for (SpielKarte w:waende )
			w.draw(g);
		
		pacman.draw(g);
	
	
	}
	
	public void move() {
		pacman.move();
	}
	
	public void checkKollision() {
		for (SpielKarte w:waende) {
			if (pacman.intersects(w)) {
				pacman.set_x_bewegung(0);
				pacman.set_y_bewegung(0);
			}
				
		}
		
		if (pacman.y <= 5 ) {
			pacman.set_y_bewegung(0);
		}
		
		if (pacman.x < 0)
			pacman.x = WIDTH_WINDOW ;
		
		if (pacman.x < 0)
			pacman.x = WIDTH_WINDOW ;
		
	
		
	}

	@Override
	public void run() {
		
		while (true) {
			try {
				move();
				checkKollision();
				repaint();
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public class Steuern extends KeyAdapter{
		
		 public void keyPressed(KeyEvent e) {
			 pacman.keyPressed(e);
		 }
	}
}
