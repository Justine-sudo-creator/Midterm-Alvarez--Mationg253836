import java.awt.*;
import java.awt.geom.*;

public class Triangle implements DrawingObject {
    private double x;
    private double y;
    private double width;
    private double tip;
    private Color color;
    private boolean hasOutline;

    public Triangle(double x, double y, double width, double tip, Color color, boolean hasOutline) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.tip = tip;
        this.color = color;
        this.hasOutline = hasOutline;
    }

    @Override
    public void draw(Graphics2D g2d) {
        Path2D.Double triangle = new Path2D.Double();
        triangle.moveTo(x, y);
        triangle.lineTo(x+(width/2), y+tip);
        triangle.lineTo(x+width, y);
        triangle.closePath();

        g2d.setColor(color);
        g2d.fill(triangle);

        if (hasOutline) {
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2));
            g2d.draw(triangle);
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
