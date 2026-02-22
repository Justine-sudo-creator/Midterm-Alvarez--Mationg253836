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

        this.pieces.add(new SemiCircle(x, y, 126.0, 53.0, 0.0, color, false, 0.0));
        
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