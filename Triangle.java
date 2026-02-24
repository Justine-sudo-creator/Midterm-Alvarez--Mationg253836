import java.awt.*;
import java.awt.geom.*;

public class Triangle implements DrawingObject {
    private double x;
    private double y;
    private double width;
    private double tip;
    private double rotation;
    private Color color;
    private boolean hasOutline;

    public Triangle(double x, double y, double width, double tip, double rotation, Color color, boolean hasOutline) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.tip = tip;
        this.rotation = rotation;
        this.color = color;
        this.hasOutline = hasOutline;
    }

    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform old = g2d.getTransform();
        
        g2d.translate(x, y);
        g2d.rotate(Math.toRadians(rotation));

        Path2D.Double triangle = new Path2D.Double();
        triangle.moveTo(-width / 2, -tip / 2);
        triangle.lineTo(0, tip / 2);
        triangle.lineTo(width / 2, -tip / 2);
        triangle.closePath();

        g2d.setColor(color);
        g2d.fill(triangle);

        if (hasOutline) {
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2));
            g2d.draw(triangle);
        }

        g2d.setTransform(old);
    }

    @Override
    public void adjust(double distance) {
    }

    @Override
    public double getX() {
        return x;
    }
    
    public void setRotation(double rotation) {
        this.rotation = rotation;
    }
}