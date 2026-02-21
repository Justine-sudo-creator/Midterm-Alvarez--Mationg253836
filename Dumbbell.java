import java.awt.*;

public class Dumbbell implements DrawingObject {
    private Circle leftWeight;
    private Circle rightWeight;
    private Line bar;
    private double x;
    private double y;
    private double size;
    private Color color;

    private int thickness;

    public Dumbbell(double x, double y, double size, Color color){
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;

        this.thickness = 5;

        leftWeight = new Circle(x, y, size, color);
        rightWeight = new Circle(x+100, y, size, color);
        
        // Assuming 'size' is the diameter
        double radius = size / 2.0;
        double centerX1 = x + radius;
        double centerY1 = y + radius;
        double centerX2 = (x + 100) + radius;
        double centerY2 = y + radius;

        // Now initialize the bar using these center points
        bar = new Line(centerX1, centerY1, centerX2, centerY2, thickness, color);
    }

    public void draw(Graphics2D g2d){
        leftWeight.draw(g2d);
        rightWeight.draw(g2d);
        bar.draw(g2d);
    }

    public void adjust(double distance){
        x += distance; // Update the composite's anchor
        leftWeight.adjust(distance); // Tell circle 1 to move
        rightWeight.adjust(distance); // Tell circle 2 to move
        bar.adjust(distance); // Tell the line to move
    }

    public double getX(){
        return x;
    }
}