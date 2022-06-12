package visualiser;

import visualiser.CoordsHandler;
import visualiser.axes.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;

public class Panel extends JPanel implements Runnable{

    static final int WIDTH = 1024;
    static final int HEIGHT = (int)(WIDTH * (0.555));
    static final Dimension SCREEN_SIZE = new Dimension(WIDTH, HEIGHT);
 
    int[] cameraCenter;
    CoordsHandler coordsHandler;
    Thread mainThread;
    Graphics graphics;
    Image image;
    XLine xLine;
    YLine yLine;
    TestSquare sqr;

    Panel() {
        createGrid();
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        mainThread = new Thread(this);
        mainThread.start();
    }

    public void createGrid(){

        coordsHandler = new CoordsHandler();
        cameraCenter = new int[2];
        cameraCenter[0] =+ 200;
        cameraCenter[1] =- 200;
        System.out.println(Arrays.toString(cameraCenter));

        xLine = new XLine(0, (HEIGHT/2), WIDTH, (HEIGHT/2));
        yLine = new YLine((WIDTH/2), 0, (WIDTH/2), HEIGHT);
        sqr = new TestSquare(0, 0, 100, 100);

    }


    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void draw(Graphics g) {
        xLine.draw(g);
        yLine.draw(g);
        sqr.draw(g);
    }

    public void move(){
        xLine.move();
        yLine.move();
        coordsHandler.move();
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
            if(delta >= 1){
                move();
                repaint();
                delta--;
            }
        
        }
    }

    public class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            coordsHandler.keyPressed(e);
        }
        public void keyReleased(KeyEvent e) {
            coordsHandler.keyReleased(e);
        }
    }
    
}
