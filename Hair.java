import java.awt.*;
import java.util.ArrayList;

public class Hair implements DrawingObject {
    private ArrayList<DrawingObject> pieces;
    private double x, y;
    private Color color;

    public Hair(double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.pieces = new ArrayList<DrawingObject>();

        this.pieces.add(new SemiCircle(x, y, 100.0, 100.0, color, 0.0));

        this.pieces.add(new Pentagon(x + 50, y + 10, 39.1, 39.1, 30, color, 145.4));
        
        this.pieces.add(new QuarterCircle(x + 20, y + 5, 45, 90, color, false, 20.0));
        
    }

    @Override
    public void draw(Graphics2D g2d) {
        for (DrawingObject piece : pieces) {
            piece.draw(g2d);
        }
    }

    @Override
    public void adjust(double distance) {
        this.x += distance;
        for (DrawingObject piece : pieces) {
            piece.adjust(distance);
        }
    }

    @Override
    public double getX() {
        return x;
    }
}