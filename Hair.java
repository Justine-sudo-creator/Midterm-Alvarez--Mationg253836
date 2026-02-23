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
        this.pieces.add(new QuarterCircle(x-7.4, y+28, 78.2, 90.0, color, false, -54.4));
        this.pieces.add(new QuarterCircle(x+50.9, y+28, 78.2, 90.0, color, false, 145.4));
        this.pieces.add(new Pentagon(x+12.6, y+34.9, 40.5, 44.1, 19.845, color, 180.0));
        this.pieces.add(new Pentagon(x+36.1, y+30.4, 40.5, 44.1, 19.845, color, 165.0));
        this.pieces.add(new Pentagon(x+70.2, y+40.9, 27.7, 44.1, 19.845, color, 217.3));
        this.pieces.add(new Pentagon(x+12, y+4, 40.5, 44.1, 19.845, color, -30.0));
        this.pieces.add(new Pentagon(x+35, y-8, 40.5, 44.1, 19.845, color, -25.0));
        this.pieces.add(new Pentagon(x+70, y-3, 40.5, 44.1, 19.845, color, 20.0));
        this.pieces.add(new Pentagon(x+100.3, y+39.5, 40.5, 44.1, 19.845, color, 80.3));
        
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