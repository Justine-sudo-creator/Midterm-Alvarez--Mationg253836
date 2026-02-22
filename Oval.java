import java.awt.*;
import java.awt.geom.*;

public class Oval implements DrawingObject {
    private double x;
    private double y;
    private double width;
    private double height;
    private Color color;
    private boolean hasOutline;

    public Oval(double x, double y, double width, double height, Color color, boolean hasOutline) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.hasOutline = hasOutline;
    }

    @Override
    public void draw(Graphics2D g2d) {
        Ellipse2D.Double oval = new Ellipse2D.Double(x, y, width, height);
        g2d.setColor(color);
        g2d.fill(oval);

        if (hasOutline){
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2));
            g2d.draw(oval);
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
