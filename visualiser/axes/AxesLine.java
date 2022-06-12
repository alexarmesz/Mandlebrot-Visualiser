package visualiser.axes;

import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

public class AxesLine extends Rectangle {

    int velocity;
    int speed = 10;


    AxesLine(int x, int y, int width, int height){
        super(x, y, width, height);
    }
    
    public void draw(Graphics g){
        g.setColor(Color.black);
        g.drawLine(x, y, width, height);
    }
}

