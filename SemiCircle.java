/**
 * The SemiCircle class represents a 180-degree arc drawing object.
 * It utilizes the Arc2D class and AffineTransform to render a rotatable 
 * half-ellipse that can be used as a component for more complex shapes.
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

public class SemiCircle implements DrawingObject {
    private double x; 
    private double y;
    private double width;
    private double height;
    private double startAngle;
    private double rotation;
    private Color color;
    private boolean hasOutline;

    /**
     * Constructs a SemiCircle with specified position, dimensions, angles, and styling.
     *
     * @param x The horizontal coordinate of the shape's origin.
     * @param y The vertical coordinate of the shape's origin.
     * @param width The width of the semi-circle.
     * @param height The height of the semi-circle.
     * @param startAngle The starting angle of the arc in degrees.
     * @param color The fill color of the arc.
     * @param hasOutline Determines if a black border is drawn.
     * @param rotation The rotation angle of the entire object in degrees.
     */
    public SemiCircle(double x, double y, double width, double height, double startAngle, Color color, boolean hasOutline, double rotation) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.startAngle = startAngle;
        this.color = color;
        this.hasOutline = hasOutline;
        this.rotation = rotation;
    }

    /**
     * Renders the semi-circle onto the Graphics2D context. It applies
     * a translation and rotation transform before filling the Arc2D shape.
     *
     * @param g2d The Graphics2D context used for drawing.
     */
    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();

        g2d.translate(x + width / 2, y + height);
        g2d.rotate(Math.toRadians(rotation));

        Arc2D.Double semi = new Arc2D.Double(-width / 2, -height, width, height*2, startAngle, 180, Arc2D.PIE);

        g2d.setColor(color);
        g2d.fill(semi);

        if (hasOutline) {
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2));
            g2d.draw(semi);
        }

        g2d.setTransform(reset);
    }

    /**
     * Adjusts the horizontal position of the semi-circle.
     *
     * @param distance The amount to shift the shape along the x-axis.
     */
    @Override
    public void adjust(double distance) {
        this.x += distance;
    }

    /**
     * Retrieves the current horizontal position of the semi-circle.
     *
     * @return The x-coordinate as a double.
     */
    @Override
    public double getX() { 
        return x; 
    }
}