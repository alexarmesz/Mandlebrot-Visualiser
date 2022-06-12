package visualiser.axes;

public class XLine extends AxesLine {
    public XLine(int x, int y, int width, int height){
        super(x, y, width, height);

    }

    @Override
    public void move(){
        x += (velocity);
        width += (velocity);
    }
}
