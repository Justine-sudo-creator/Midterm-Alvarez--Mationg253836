import java.awt.*;
import java.awt.geom.*;

public class Triangle implements DrawingObject {
    private double x;
    private double y;
    private double width;
    private double tip;
    private Color color;

    public Triangle(double x, double y, double width, double tip, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.tip = tip;
        this.color = color;
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
    }

    @Override
    public void adjust(double distance) {

    }

    @Override
    public double getX() {
        return x;
    }
}
