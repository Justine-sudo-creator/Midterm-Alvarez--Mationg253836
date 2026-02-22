import java.awt.*;
import java.awt.geom.*;

public class SemiCircle implements DrawingObject {
    private double x; 
    private double y;
    private double width;
    private double height;
    private double startAngle;
    private double rotation;
    private Color color;
    private boolean hasOutline;

    public SemiCircle(double x, double y, double width, double height, double startAngle, Color color, boolean hasOutline, double rotation) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.startAngle = startAngle;
        this.color = color;
        this.hasOutline = hasOutline;
        this.rotation = rotation;
    }

    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();

        g2d.translate(x + width / 2, y + height);
        g2d.rotate(Math.toRadians(rotation));

        Arc2D.Double semi = new Arc2D.Double(-width / 2, -height, width, height*2, startAngle, 180, Arc2D.PIE);

        g2d.setColor(color);
        g2d.fill(semi);

        if (hasOutline) {
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2));
            g2d.draw(semi);
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