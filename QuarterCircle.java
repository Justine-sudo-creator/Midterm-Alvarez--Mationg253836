import java.awt.*;
import java.awt.geom.*;

public class QuarterCircle implements DrawingObject {
    private double x; 
    private double y;
    private double size;
    private double startAngle;
    private double rotation;
    private Color color;
    private boolean hasOutline;

    public QuarterCircle(double x, double y, double size, double startAngle, Color color, boolean hasOutline, double rotation) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.startAngle = startAngle;
        this.color = color;
        this.hasOutline = hasOutline;
        this.rotation = rotation;
    }

    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();

        g2d.translate(x + size / 2, y + size / 2);

        g2d.rotate(Math.toRadians(rotation));

        Arc2D.Double quarter = new Arc2D.Double(-size / 2, -size / 2, size, size, startAngle, 90, Arc2D.PIE);

        g2d.setColor(color);
        g2d.fill(quarter);

        if (hasOutline) {
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2));
            g2d.draw(quarter);
        }

        g2d.setTransform(reset);
    }

    @Override
    public void adjust(double distance) {
        this.x += distance;
    }

    @Override
    public double getX() { 
        return x; 
    }
}