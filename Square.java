import java.awt.*;
import java.awt.geom.*;

public class Square implements DrawingObject {
    private double x;
    private double y;
    private double size;
    private Color color;
    private boolean hasOutline;

    public Square(double x, double y, double size, Color color, boolean hasOutline) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.hasOutline = hasOutline;
    }

    @Override
    public void draw(Graphics2D g2d) {
        Rectangle2D.Double square = new Rectangle2D.Double(x, y, size, size);
        g2d.setColor(color);
        g2d.fill(square);

        if (hasOutline) {
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2));
            g2d.draw(square);
        }
    }

    @Override
    public void adjust(double distance) {

    }

    @Override
    public double getX() {
        return x;
    }
}
