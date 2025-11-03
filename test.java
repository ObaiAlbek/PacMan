package Übungen.Pac_Man;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class test extends JFrame implements Runnable {
	
	Thread test;
	ArrayList<ImageIcon> pacman;
	JLabel setman;
	int currentImageIndex = 0; // Um den aktuellen Index des Bildes zu verfolgen

	test() {
		setman = new JLabel();
		pacman = new ArrayList<>();

		// Bilder zur Liste hinzufügen
		pacman.add(new ImageIcon("C:\\Users\\obaya\\git\\Programmierung2\\Programmierung2\\src\\Übungen\\Pac_Man\\Pacman\\pacmanright.png"));
		pacman.add(new ImageIcon("C:\\Users\\obaya\\git\\Programmierung2\\Programmierung2\\src\\Übungen\\Pac_Man\\Pacman\\pacmanopenright.png"));
//		pacman.add(new ImageIcon("C:\\Users\\obaya\\git\\Programmierung2\\Programmierung2\\src\\Übungen\\Pac_Man\\Pacman\\pacmandown.png"));

		this.setTitle("Pacman Animation");
		this.setSize(700, 700);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.add(setman);

		// Thread starten
		test = new Thread(this);
		test.start();
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new test();
	}

	public void zeigePacMan() {
		setman.setIcon(pacman.get(currentImageIndex)); 
		// Erhöht den Index und stellt sicher, dass er nicht größer als die Liste wird
		currentImageIndex = (currentImageIndex + 1) % pacman.size(); 
	}

	@Override
	public void run() {
		while (true) {
			try {
				zeigePacMan(); 
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
