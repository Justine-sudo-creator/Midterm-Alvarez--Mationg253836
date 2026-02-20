import java.awt.*;

public interface DrawingObject {
    void draw(Graphics2D g2d);
    void adjust(double distance);
    double getX();
}