package visualiser.axes;

import java.awt.*;

public class TestSquare extends Rectangle{
    public TestSquare(int x, int y, int width, int height){
        super(x, y, width, height);
    }
    public void draw(Graphics g){
        g.setColor(Color.black);
        g.fillRect(x, y, width, height);
    }
}