package visualiser;

import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame{
    
    Panel panel;
    Image icon = Toolkit.getDefaultToolkit().getImage("visualiser/icons/mandlebrot.png");

    public Frame(){
        panel = new Panel();
        this.add(panel);
        this.setTitle("Mandlebrot Set");
        this.setResizable(false);
        this.setBackground(Color.white);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(icon);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
