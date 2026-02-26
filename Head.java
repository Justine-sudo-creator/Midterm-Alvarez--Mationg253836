import java.awt.*;
import java.awt.geom.*;

public class Head implements DrawingObject{
    private Headphones headphones;
    private Hair hair;
    private Face face;

    private double x;
    private double y;
    private Color skinColor;
    private Color headphonesColor;
    private Color hairColor;

    public Head(double x, double y, Color skinColor, Color headphonesColor, Color hairColor){
        this.x = x;
        this.y = y;
        this.skinColor = skinColor;
        this.headphonesColor = headphonesColor;
        this.hairColor = hairColor;

        headphones = new Headphones(-16.6, -26, headphonesColor);
        hair = new Hair(-12.6, -28.4, hairColor);
        face = new Face(0, 0, skinColor);
    }
    
    public void draw(Graphics2D g2d){
        AffineTransform old = g2d.getTransform();
        
        g2d.translate(x, y);

        face.draw(g2d);
        headphones.draw(g2d);
        hair.draw(g2d);

        g2d.setTransform(old);
    }

    public void adjust(double distance){

    }

    public void setX(double newX) {
        this.x = newX;
    }

    public double getX(){
        return x;
    }
}
