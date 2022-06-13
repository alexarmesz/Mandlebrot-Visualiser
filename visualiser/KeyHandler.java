package visualiser;
import java.awt.event.*;

public class KeyHandler implements KeyListener{

    public boolean wPressed, sPressed, aPressed, dPressed;


    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch(code){
            case (KeyEvent.VK_W):
                wPressed = true;
            case (KeyEvent.VK_S):
                sPressed = true;
            case (KeyEvent.VK_A):
                aPressed = true;
            case (KeyEvent.VK_D):
                dPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch(code){
            case (KeyEvent.VK_W):
                wPressed = false;
            case (KeyEvent.VK_S):
                sPressed = false;
            case (KeyEvent.VK_A):
                aPressed = false;
            case (KeyEvent.VK_D):
                dPressed = false;
        }
    }
    
}
