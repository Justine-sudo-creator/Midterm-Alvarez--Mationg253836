import java.awt.*;

public class MusicNote implements DrawingObject{
    private Circle noteHead1;
    private Circle noteHead2;
    private Line stem1;
    private Line stem2;
    private Line handle;
    private double x;
    private double y;
    private double size;
    private Color color;
    
    public void draw(Graphics2D g2d){
        noteHead1 = new Circle(x, y, size, color);
        noteHead2 = new Circle(x, y, size, color);

    }

    public void adjust(double distance){

    }
    
    public double getX(){
        return x;
    }
}
