package visualiser.axes;

import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

public class AxesLine extends Rectangle {

    int velocity;
    int speed = 10;


    AxesLine(int x, int y, int width, int height){
        super(x, y, width, height);
        int xCoord = x;
        int yCoord = y;
    }
    
    public void draw(Graphics g){
        g.setColor(Color.black);
        g.drawLine(x, y, width, height);
    }

    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_W) {
            setDirection(speed);
            move();
        }
        else if(e.getKeyCode() == KeyEvent.VK_S) {
            setDirection(-speed);
            move();
        }
    }

    public void keyReleased(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_W) {
            setDirection(0);
            move();
        }
        else if(e.getKeyCode() == KeyEvent.VK_S) {
            setDirection(0);
            move();
        }
    }

    public void setDirection(int yDirection) {
        velocity = yDirection;
    }

    public void move(){
        //System.out.println("parent move");
        
    }
    
}
