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

        if (code == KeyEvent.VK_W){
            wPressed = true;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W){
            wPressed = false;
        }
        
    }
    
}
