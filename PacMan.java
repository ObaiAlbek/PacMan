package Übungen.Pac_Man;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class PacMan extends Rectangle {

    private static int pacMan_width = 30;
    private static int pacMan_height = 30;
    private int ybewegung;
    private int xbewegung;
    private int speed = 8;
    
    Image[] pacmanImagesRight;
    Image[] pacmanImagesLeft;  
    Image[] pacmanImagesUp;    
    Image[] pacmanImagesDown;  

    Image currentImage;
    int animationIndex = 0;
    long lastTime = System.nanoTime(); 
    
    PacMan(int x, int y) {
        super(x, y, pacMan_width, pacMan_height);
        
        pacmanImagesRight = new Image[]{
        	    new ImageIcon("C:\\Users\\obaya\\git\\Programmierung2\\Programmierung2\\src\\Übungen\\Pac_Man\\Pacman\\pacmanright.png").getImage(),
        	    new ImageIcon("C:\\Users\\obaya\\git\\Programmierung2\\Programmierung2\\src\\Übungen\\Pac_Man\\Pacman\\pacmanopenright.png").getImage()
        	};
        	pacmanImagesLeft = new Image[]{
        	    new ImageIcon("C:\\Users\\obaya\\git\\Programmierung2\\Programmierung2\\src\\Übungen\\Pac_Man\\Pacman\\pacmanleft.png").getImage(),
        	    new ImageIcon("C:\\Users\\obaya\\git\\Programmierung2\\Programmierung2\\src\\Übungen\\Pac_Man\\Pacman\\pacmanopenleft.png").getImage()
        	};
        	pacmanImagesUp = new Image[]{
        	    new ImageIcon("C:\\Users\\obaya\\git\\Programmierung2\\Programmierung2\\src\\Übungen\\Pac_Man\\Pacman\\pacmanup.png").getImage(),
        	    new ImageIcon("C:\\Users\\obaya\\git\\Programmierung2\\Programmierung2\\src\\Übungen\\Pac_Man\\Pacman\\pacmanopenup.png").getImage()
        	};
        	pacmanImagesDown = new Image[]{
        	    new ImageIcon("C:\\Users\\obaya\\git\\Programmierung2\\Programmierung2\\src\\Übungen\\Pac_Man\\Pacman\\pacmandown.png").getImage(),
        	    new ImageIcon("C:\\Users\\obaya\\git\\Programmierung2\\Programmierung2\\src\\Übungen\\Pac_Man\\Pacman\\pacmanopendown.png").getImage()
        	};

        // Standardmäßig das rechte Bild anzeigen
        currentImage = pacmanImagesRight[0];
    }

    public void draw(Graphics g) {
        long currentTime = System.nanoTime();
        // Alle 200ms zwischen den zwei Animation-Bildern wechseln
        if ((currentTime - lastTime) > 200_000_000) {
            animationIndex = (animationIndex + 1) % 2; // 0 -> 1 -> 0 wechseln
            lastTime = currentTime;
        }
        
        // Je nach Bewegung das passende Bild setzen
        if (xbewegung > 0) 
            currentImage = pacmanImagesRight[animationIndex];
         else if (xbewegung < 0) 
            currentImage = pacmanImagesLeft[animationIndex];
         else if (ybewegung > 0) 
            currentImage = pacmanImagesDown[animationIndex];
        else if (ybewegung < 0)
            currentImage = pacmanImagesUp[animationIndex];
        
        
        g.drawImage(currentImage, x, y, pacMan_width, pacMan_height, null);
    }


    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            currentImage = pacmanImagesUp[animationIndex];
            set_y_bewegung(-speed);
            set_x_bewegung(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            currentImage = pacmanImagesDown[animationIndex];
            set_y_bewegung(speed);
            set_x_bewegung(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_D) { 
            currentImage = pacmanImagesRight[animationIndex];
            set_y_bewegung(0);
            set_x_bewegung(speed);
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            currentImage = pacmanImagesLeft[animationIndex];
            set_y_bewegung(0);
            set_x_bewegung(-speed);
        }
    }

    public void set_y_bewegung(int y) {
        this.ybewegung = y;
    }
    
    public void set_x_bewegung(int x) {
        this.xbewegung = x;
    }

    // Bewegung updaten
    public void move() {
        y += ybewegung;
        x += xbewegung;
    }

    public void check_kollision(int windowWidth, int windowHeight) {
        if (x < 0) x = 0;
        if (y < 0) y = 0;
        if (x + pacMan_width > windowWidth) x = windowWidth - pacMan_width;
        if (y + pacMan_height > windowHeight) y = windowHeight - pacMan_height;
    }

}
