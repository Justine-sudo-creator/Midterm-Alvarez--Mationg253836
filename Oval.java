/**
 * The Oval class represents an elliptical drawing object within the scene.
 * It implements the DrawingObject interface, allowing for custom dimensions,
 * colors, and an optional outline to be rendered on the canvas.
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

public class Oval implements DrawingObject {
    private double x;
    private double y;
    private double width;
    private double height;
    private Color color;
    private boolean hasOutline;

    /**
     * Constructs an Oval object with specific coordinates, dimensions, 
     * color, and outline preference.
     *
     * @param x The horizontal coordinate of the upper-left corner of the bounding box.
     * @param y The vertical coordinate of the upper-left corner of the bounding box.
     * @param width The width of the oval.
     * @param height The height of the oval.
     * @param color The fill color of the oval.
     * @param hasOutline Determines if a black border is drawn around the shape.
     */
    public Oval(double x, double y, double width, double height, Color color, boolean hasOutline) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.hasOutline = hasOutline;
    }

    /**
     * Renders the oval onto the Graphics2D context. It fills the shape with
     * the assigned color and optionally draws a black stroke outline.
     *
     * @param g2d The Graphics2D context used for rendering.
     */
    @Override
    public void draw(Graphics2D g2d) {
        Ellipse2D.Double oval = new Ellipse2D.Double(x, y, width, height);
        g2d.setColor(color);
        g2d.fill(oval);

        if (hasOutline){
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2));
            g2d.draw(oval);
        }
    }

    /**
     * Adjusts the state of the oval. Required by the DrawingObject interface.
     *
     * @param distance The value used to shift the state or position.
     */
    @Override
    public void adjust(double distance) {
        // Implementation for movement can be added here if needed.
    }

    /**
     * Retrieves the current horizontal position of the oval.
     *
     * @return The x-coordinate as a double.
     */
    @Override
    public double getX() {
        return x;
    }
}