import java.awt.*;
import java.awt.geom.*;

public class Arm implements DrawingObject {
    private Rectangle arm;
    private Rectangle sleeve;
    private Oval hand;

    private double x;
    private double y;
    private double rotation;
    private Color skinColor;
    private Color hoodieColor;

    public Arm(double x, double y, Color skinColor, Color hoodieColor, double rotation) {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        this.skinColor = skinColor;
        this.hoodieColor = hoodieColor;

        arm = new Rectangle(0, 0, 46.8, 107, hoodieColor, false);
        sleeve = new Rectangle(3.5, 103.4, 39.9, 20.4, hoodieColor, false);
        hand = new Oval(3.5, 119.6, 39.5, 39.5, skinColor, true);
    }
    
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();

        g2d.translate(x, y); 

        g2d.rotate(Math.toRadians(rotation)); 

        arm.draw(g2d);
        hand.draw(g2d);
        sleeve.draw(g2d);

        g2d.setTransform(reset);
    }

    public void setRotation(double degrees) {
        this.rotation = degrees;
    }

    public void adjust(double distance) {
    }

    public double getX() {
        return x;
    }
}