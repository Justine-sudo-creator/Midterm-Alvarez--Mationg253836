import java.awt.*;
import java.awt.geom.*;

public class Arc implements DrawingObject {
    private double x;
    private double y;
    private double width;
    private double height;
    private int thickness;
    private Color color;

    public Arc(double x, double y, double width, double height, int thickness, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.thickness = thickness;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d) {
        Path2D.Double arc = new Path2D.Double();
        arc.moveTo(x, y);
        arc.quadTo(x+(width/2), y-height, x+width, y);

        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(thickness));
        g2d.draw(arc);
    }

    @Override
    public void adjust(double distance) {

    }

    @Override
    public double getX() {
        return x;
    }
}
