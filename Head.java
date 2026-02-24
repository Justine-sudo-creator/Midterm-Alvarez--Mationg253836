import java.awt.*;

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

        headphones = new Headphones(x-16.6, y-26, headphonesColor);
        hair = new Hair(x-12.6, y-28.4, hairColor);
        face = new Face(x, y, skinColor);
    }
    
    public void draw(Graphics2D g2d){
        face.draw(g2d);
        headphones.draw(g2d);
        hair.draw(g2d);
    }

    public void adjust(double distance){

    }

    public double getX(){
        return x;
    }
}
