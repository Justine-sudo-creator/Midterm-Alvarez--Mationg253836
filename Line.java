import java.awt.*;
import java.awt.geom.*;

public class Line implements DrawingObject {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private int thickness;
    private Color color;

    public Line(double x1, double y1, double x2, double y2, int thickness, Color color) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.thickness = thickness;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d) {
        Line2D.Double line = new Line2D.Double(x1, y1, x2, y2);
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(thickness));
        g2d.draw(line);
    }

    @Override
    public void adjust(double distance) {

    }

    @Override
    public double getX() {
        return x1;
    }
}
