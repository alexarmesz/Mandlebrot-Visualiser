package visualiser;
import java.awt.event.*;

public class CoordsHandler {
    int pixelCenterX;
    int pixelCenterY;
    int worldCenterX;
    int worldCenterY;

    int yVelocity;
    int xVelocity;
    int speed = 10;
    CoordsHandler(){

    }

    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_W) {
            setDirection(speed, "y");
            move();
        }
        else if(e.getKeyCode() == KeyEvent.VK_S) {
            setDirection(-speed, "y");
            move();
        }
    }

    public void keyReleased(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_W) {
            setDirection(0, "y");
            move();
        }
        else if(e.getKeyCode() == KeyEvent.VK_S) {
            setDirection(0, "y");
            move();
        }
    }
    public void setDirection(int speed, String axis) {
        if (axis == "y") { 
            yVelocity += speed;
        }
    }

    public void move(){
        pixelCenterY += yVelocity;
        System.out.println(pixelCenterY);
    }
    
}
