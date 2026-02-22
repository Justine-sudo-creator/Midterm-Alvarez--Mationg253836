import java.awt.*;
import java.awt.geom.*;

public class Circle implements DrawingObject {
    private double x;
    private double y;
    private double size;
    private Color color;

    public Circle(double x, double y, double size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d) {
        Ellipse2D.Double circle = new Ellipse2D.Double(x, y, size, size);
        g2d.setColor(color);
        g2d.fill(circle);

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3));
        g2d.draw(circle);
    }

    @Override
    public void adjust(double distance) {
        
    }

    @Override
    public double getX() {
        return x;
    }
}
