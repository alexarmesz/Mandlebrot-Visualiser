package visualiser;

import visualiser.axes.*;
import java.awt.*;
import javax.swing.*;
//import java.awt.image.BufferedImage;

public class Panel extends JPanel implements Runnable{

    static final int WIDTH = 1024;
    static final int HEIGHT = (int)(WIDTH * (0.555));
    static final Dimension SCREEN_SIZE = new Dimension(WIDTH, HEIGHT);
 
    KeyHandler keyHandler = new KeyHandler();
    Thread mainThread;
    Graphics graphics;

    Image image;
    Line xLine;
    Line yLine;

    Panel() {
        createAxes();
        this.setFocusable(true);
        this.addKeyListener(keyHandler);
        this.setPreferredSize(SCREEN_SIZE);

        mainThread = new Thread(this);
        mainThread.start();
    }

    public void createAxes(){
        yLine = new Line((WIDTH/2), 0, (WIDTH/2), HEIGHT);
        xLine = new Line(0, (HEIGHT/2), WIDTH, (HEIGHT/2));
    }
    

    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void colour(Graphics g){
        g.setColor(Color.red);
        for (int y = 0 - xLine.displaceY; y < HEIGHT - xLine.displaceY; y++){
            for (int x = 0 + yLine.displaceX; x < WIDTH + yLine.displaceX; x++){
                if (y == x){
                    g.fillRect(x-yLine.displaceX, y+xLine.displaceY, 2, 2);
                }
            }
        }
    }

    public void draw(Graphics g) {
        colour(g);
        xLine.draw(g);
        yLine.draw(g);
        
        
        //sqr.draw(g);
    }

    public void keyEvents(){
        if (keyHandler.wPressed){
            xLine.displaceY += 5;
        }
        else if (keyHandler.sPressed){
            xLine.displaceY -= 5;
        }
        else if (keyHandler.aPressed){
            yLine.displaceX -= 5;
        }
        else if (keyHandler.dPressed){
            yLine.displaceX += 5;
        }
        else if (keyHandler.rPressed){
            xLine.displaceX = 0;
            xLine.displaceY = 0;
            yLine.displaceX = 0;
            xLine.displaceY = 0;
        }
    }

    public void run(){
        long lastTime = System.nanoTime();
        double ticks = 60.0;
        double ns = 1000000000 / ticks;
        double delta = 0;

        while(true){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            
            if(delta >= 0.25){
                keyEvents();
                repaint();
                delta-=0.25;
            }
        
        }
    }

}