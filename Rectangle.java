/**
 * The Rectangle class represents a basic rectangular drawing object.
 * It implements the DrawingObject interface and provides functionality 
 * to render a filled rectangle with an optional black outline.
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

public class Rectangle implements DrawingObject {
    private double x;
    private double y;
    private double height;
    private double width;
    private Color color;
    private boolean hasOutline;

    /**
     * Constructs a Rectangle with specified position, dimensions, color, 
     * and outline preference.
     *
     * @param x The horizontal coordinate of the upper-left corner.
     * @param y The vertical coordinate of the upper-left corner.
     * @param width The width of the rectangle.
     * @param height The height of the rectangle.
     * @param color The fill color of the rectangle.
     * @param hasOutline Determines if a black border is drawn around the shape.
     */
    public Rectangle(double x, double y, double width, double height, Color color, boolean hasOutline) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.color = color;
        this.hasOutline = hasOutline;
    }

    /**
     * Renders the rectangle onto the Graphics2D context using Rectangle2D.Double.
     * It fills the shape and optionally draws a stroke for the outline.
     *
     * @param g2d The Graphics2D context used for drawing.
     */
    @Override
    public void draw(Graphics2D g2d) {
        Rectangle2D.Double rect = new Rectangle2D.Double(x, y, width, height);
        g2d.setColor(color);
        g2d.fill(rect);

        if (hasOutline) {
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2));
            g2d.draw(rect);
        }
    }

    /**
     * Adjusts the state of the rectangle. Required by the DrawingObject interface.
     *
     * @param distance The value used to shift the state or position.
     */
    @Override
    public void adjust(double distance) {
        // Implementation for movement can be added here if needed.
    }

    /**
     * Updates the fill color of the rectangle to a new specified color.
     *
     * @param newColor The new color to be applied to the rectangle.
     */
    public void setColor(Color newColor) {
        this.color = newColor;
    }

    /**
     * Retrieves the current horizontal position of the rectangle.
     *
     * @return The x-coordinate as a double.
     */
    @Override
    public double getX() {
        return x;
    }
}