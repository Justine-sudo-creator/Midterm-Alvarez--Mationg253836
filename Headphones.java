import java.awt.*;

public class Headphones implements DrawingObject{
    private Rectangle phone1;
    private Square sidePhone1;
    private Rectangle phone2;
    private Square sidePhone2;

    private Rectangle stem1;
    private Rectangle stem2;
    private Rectangle handleOut;
    private Rectangle handleIn;

    private double x;
    private double y;
    private Color color;

    public Headphones(double x, double y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;

        Color grey = Color.decode("#a8acb3");

        stem1 = new Rectangle(x, y, 16, 79.7, grey, true);
        stem2 = new Rectangle(x+116.2, y, 16, 79.7, grey, true);

        phone1 = new Rectangle(x-15, y+69.6, 31, 42.7, color, true);
        phone2 = new Rectangle(x+116.2, y+69.6, 31, 42.7, color, true);

        sidePhone1 = new Square(x-21.8, y+79, 27, grey);
        sidePhone2 = new Square(x+128.9, y+79, 27, grey);

        handleOut = new Rectangle(x, y, 116.2, 10.1, Color.BLACK, false);
        handleIn = new Rectangle(x+3.9, y+2, 124.4, 6.4, grey, false);
    }
    
    public void draw(Graphics2D g2d){
        handleOut.draw(g2d);
        stem1.draw(g2d);
        stem2.draw(g2d);
        handleIn.draw(g2d);
        phone1.draw(g2d);
        phone2.draw(g2d);
        sidePhone1.draw(g2d);
        sidePhone2.draw(g2d);
    }

    public void adjust(double distance){

    }

    public double getX(){
        return x;
    }
}
