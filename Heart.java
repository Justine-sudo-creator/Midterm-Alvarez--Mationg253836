import java.awt.*;
import java.awt.geom.*;

public class Heart implements DrawingObject {
    private double x; 
    private double y;
    private double size;
    private Color color;

    public Heart(double x, double y, double size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    public Heart() {
    }

    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();
        g2d.translate(x, y);

        g2d.setColor(color);

        double circleDiam = size * 0.6;
        
        Ellipse2D leftCircle = new Ellipse2D.Double(0, 0, circleDiam, circleDiam);
        Ellipse2D rightCircle = new Ellipse2D.Double(size - circleDiam, 0, circleDiam, circleDiam);
        
        Path2D bottomPoint = new Path2D.Double();
        bottomPoint.moveTo(0, circleDiam / 2.0);
        bottomPoint.lineTo(size / 2.0, size);
        bottomPoint.lineTo(size, circleDiam / 2.0);
        bottomPoint.closePath();

        g2d.fill(leftCircle);
        g2d.fill(rightCircle);
        g2d.fill(bottomPoint);

        g2d.setTransform(reset);
    }

    @Override
    public void adjust(double distance) {

    }

    @Override
    public double getX() {
        return x;
    }
}