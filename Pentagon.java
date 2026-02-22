import java.awt.*;
import java.awt.geom.*;

public class Pentagon implements DrawingObject {
    private double x; 
    private double y;
    private double width;
    private double height;
    private double sideHeight;
    private Color color;
    private double rotation;

    public Pentagon(double x, double y, double w, double h, double sh, Color c, double rotation) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.sideHeight = sh;
        this.color = c;
        this.rotation = rotation;
    }

    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform old = g2d.getTransform();
        
        g2d.translate(x + width / 2, y + height / 2);
        g2d.rotate(Math.toRadians(rotation));

        Path2D.Double pentagon = new Path2D.Double();
        double hw = width / 2;
        double hh = height / 2;

        pentagon.moveTo(0, -hh);
        pentagon.lineTo(hw, sideHeight - height + hh);
        pentagon.lineTo(hw, hh);
        pentagon.lineTo(-hw, hh);
        pentagon.lineTo(-hw, sideHeight - height + hh);
        pentagon.closePath();

        g2d.setColor(color);
        g2d.fill(pentagon);
        g2d.setColor(Color.BLACK);
        g2d.draw(pentagon);

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