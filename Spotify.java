import java.awt.*;

public class Spotify implements DrawingObject{
    private Circle back;
    private Arc arc1;
    private Arc arc2;
    private Arc arc3;

    private double x;
    private double y;

    public Spotify(double x, double y){
        this.x = x;
        this.y = y;

        back = new Circle(x, y, 64.9, Color.WHITE, true);
        arc1 = new Arc(x+9.7, y+18.4, 46.1, 10.6, 4, Color.BLACK, 0);
        arc2 = new Arc(x+11.7, y+27, 42.1, 10.6, 3, Color.BLACK, 0);
        arc3 = new Arc(x+11.7, y+35.6, 38.1, 10.6, 3, Color.BLACK, 0);
    }
    
    public void draw(Graphics2D g2d){
        back.draw(g2d);
        arc1.draw(g2d);
        arc2.draw(g2d);
        arc3.draw(g2d);
    }

    public void adjust(double distance){

    }

    public double getX(){
        return x;
    }
}
