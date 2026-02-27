/**
 * The QuarterCircle class represents a 90-degree arc drawing object.
 * It utilizes the Arc2D class to render a pie-shaped wedge that can be 
 * rotated and translated as part of a more complex composite shape.
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

public class QuarterCircle implements DrawingObject {
    private double x; 
    private double y;
    private double size;
    private double startAngle;
    private double rotation;
    private Color color;
    private boolean hasOutline;

    /**
     * Constructs a QuarterCircle with specified position, size, angles, and styling.
     *
     * @param x The horizontal coordinate of the shape's origin.
     * @param y The vertical coordinate of the shape's origin.
     * @param size The diameter of the full circle the arc belongs to.
     * @param startAngle The starting angle of the arc in degrees.
     * @param color The fill color of the arc.
     * @param hasOutline Determines if a black border is drawn.
     * @param rotation The rotation angle of the entire object in degrees.
     */
    public QuarterCircle(double x, double y, double size, double startAngle, Color color, boolean hasOutline, double rotation) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.startAngle = startAngle;
        this.color = color;
        this.hasOutline = hasOutline;
        this.rotation = rotation;
    }

    /**
     * Renders the quarter circle onto the Graphics2D context. It applies
     * a translation and rotation transform before filling the Arc2D shape.
     *
     * @param g2d The Graphics2D context used for drawing.
     */
    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();

        g2d.translate(x + size / 2, y + size / 2);
        g2d.rotate(Math.toRadians(rotation));

        Arc2D.Double quarter = new Arc2D.Double(-size / 2, -size / 2, size, size, startAngle, 90, Arc2D.PIE);

        g2d.setColor(color);
        g2d.fill(quarter);

        if (hasOutline) {
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2));
            g2d.draw(quarter);
        }

        g2d.setTransform(reset);
    }

    /**
     * Adjusts the horizontal position of the quarter circle.
     *
     * @param distance The amount to shift the shape along the x-axis.
     */
    @Override
    public void adjust(double distance) {
        this.x += distance;
    }

    /**
     * Retrieves the current horizontal position of the quarter circle.
     *
     * @return The x-coordinate as a double.
     */
    @Override
    public double getX() { 
        return x; 
    }
}