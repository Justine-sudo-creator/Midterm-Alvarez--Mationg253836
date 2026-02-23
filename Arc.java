import java.awt.*;
import java.awt.geom.*;

public class Arc implements DrawingObject {
    private double x;
    private double y;
    private double width;
    private double height;
    private int thickness;
    private Color color;
    private double rotation;

    public Arc(double x, double y, double width, double height, int thickness, Color color, double rotation) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.thickness = thickness;
        this.color = color;
        this.rotation = rotation;
    }

    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();

        g2d.translate(x + width / 2, y + height / 2);
        g2d.rotate(Math.toRadians(rotation));

        Path2D.Double arc = new Path2D.Double();
        arc.moveTo(-width / 2, height / 2); 
        arc.quadTo(0, -height / 2, width / 2, height / 2);

        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.draw(arc);

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