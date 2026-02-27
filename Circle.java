/**
 * The Circle class represents a circular drawing object within the scene.
 * This class implements the DrawingObject interface and provides functionality
 * to render a colored circle with an optional outline using Java's 2D API.
 * * @author Justine T. Mationg (253836)
 * @author Adrian Adam Alvarez (250266)
 * @version February 26, 2026
 * * I have not discussed the Java language code in my program
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

public class Circle implements DrawingObject {
    private double x;
    private double y;
    private double size;
    private Color color;
    private boolean hasOutline;

    /**
     * Constructs a Circle object with specified position, size, and color.
     * * @param x The horizontal coordinate of the upper-left corner of the circle's bounding box.
     * @param y The vertical coordinate of the upper-left corner of the circle's bounding box.
     * @param size The diameter of the circle.
     * @param color The fill color of the circle.
     * @param hasOutline Determines whether a black border should be drawn around the circle.
     */
    public Circle(double x, double y, double size, Color color, boolean hasOutline) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.hasOutline = hasOutline;
    }

    /**
     * Renders the circle onto the provided Graphics2D context.
     * It uses the Ellipse2D class to define the geometry and fills it with the assigned color.
     * * Source: 
     * - Ellipse2D (Oracle Java Docs): Used for defining the circular geometry.
     * * @param g2d The Graphics2D context used for rendering.
     */
    @Override
    public void draw(Graphics2D g2d) {
        Ellipse2D.Double circle = new Ellipse2D.Double(x, y, size, size);
        g2d.setColor(color);
        g2d.fill(circle);

        if (hasOutline){
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(3));
            g2d.draw(circle);
        }
    }

    /**
     * Adjusts the state of the circle. This is a required implementation of
     * the DrawingObject interface.
     * * @param distance The value used to shift the state of the object.
     */
    @Override
    public void adjust(double distance) {
        // Implementation logic can be added here if movement is required.
    }

    /**
     * Retrieves the current horizontal position of the circle.
     * * @return The x-coordinate as a double.
     */
    @Override
    public double getX() {
        return x;
    }
}