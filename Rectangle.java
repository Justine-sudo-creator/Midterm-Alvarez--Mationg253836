import java.awt.*;
import java.awt.geom.*;

public class Rectangle implements DrawingObject{
    private double x;
    private double y;
    private double height;
    private double width;
    private Color color;
    private boolean hasOutline;

    public Rectangle(double x, double y, double width, double height, Color color, boolean hasOutline){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.color = color;
        this.hasOutline = hasOutline;
    }

    @Override
    public void draw(Graphics2D g2d){
        Rectangle2D.Double rect = new Rectangle2D.Double(x, y, width, height);
        g2d.setColor(color);
        g2d.fill(rect);

        if (hasOutline) {
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2));
            g2d.draw(rect);
        }
    }

    public void adjust(double distance){

    }

    public double getX(){
        return x;
    }
}
