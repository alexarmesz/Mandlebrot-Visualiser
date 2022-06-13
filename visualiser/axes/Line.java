package visualiser.axes;
import java.awt.*;

public class Line {

    public int displaceX = 0;
    public int displaceY = 0;
    int x;
    int y;
    int x2;
    int y2;

    public Line(int x, int y, int x2, int y2){
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void draw(Graphics g){
        g.setColor(Color.black);
        g.drawLine(x+displaceX, y-displaceY, x2+displaceX, y2-displaceY);
    }
}