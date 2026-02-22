import java.awt.*;
import java.awt.geom.*;

public class SemiCircle implements DrawingObject {
    private double x, y, width, height, rotation;
    private Color color;

    public SemiCircle(double x, double y, double height, double width, Color color, double rotation) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.rotation = rotation;
    }

    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform old = g2d.getTransform();
        g2d.translate(x + width / 2, y);
        g2d.rotate(Math.toRadians(rotation));

        Path2D.Double semiCircle = new Path2D.Double();
        semiCircle.moveTo(-width / 2, 0);
        semiCircle.quadTo(0, -height, width / 2, 0);
        semiCircle.closePath();

        g2d.setColor(color);
        g2d.fill(semiCircle);
        g2d.setColor(Color.BLACK);
        g2d.draw(semiCircle);

        g2d.setTransform(old);
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