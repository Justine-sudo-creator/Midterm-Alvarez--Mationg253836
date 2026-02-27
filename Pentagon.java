/**
 * The Pentagon class represents a custom five-sided polygon drawing object.
 * It uses Path2D to define the vertex coordinates and AffineTransform to
 * handle rotation and translation within the scene.
 *
 * @author Justine T. Mationg (253836)
 * @author Adrian Adam Alvarez (250266)
 * @version February 26, 2026
 *
 * I have not discussed the Java language code in my program
 * with anyone other than my instructor or the teaching assistants
 * assigned to this course.
 * I have not used Java language code obtained from another student,
 * or any other unauthorized source, either modified or unmodified.
 * If any Java language code or documentation used in my program
 * was obtained from another source, such as a textbook or website,
 * that has been clearly noted with a proper citation in the comments
 * of my program.
 */

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

    /**
     * Constructs a Pentagon with specified dimensions, position, and orientation.
     *
     * @param x The horizontal coordinate of the shape's origin.
     * @param y The vertical coordinate of the shape's origin.
     * @param w The total width of the pentagon.
     * @param h The total height of the pentagon.
     * @param sh The height of the vertical side segments.
     * @param c The fill color of the pentagon.
     * @param rotation The rotation angle in degrees.
     */
    public Pentagon(double x, double y, double w, double h, double sh, Color c, double rotation) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.sideHeight = sh;
        this.color = c;
        this.rotation = rotation;
    }

    /**
     * Renders the pentagon onto the Graphics2D context. This method uses Path2D
     * to trace the five vertices and applies rotation around the shape's center.
     *
     * @param g2d The Graphics2D context used for drawing.
     */
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

    /**
     * Adjusts the horizontal position of the pentagon.
     *
     * @param distance The amount to shift the pentagon along the x-axis.
     */
    @Override
    public void adjust(double distance) {
        this.x += distance;
    }

    /**
     * Retrieves the current horizontal position of the pentagon.
     *
     * @return The x-coordinate as a double.
     */
    @Override
    public double getX() {
        return x;
    }
}