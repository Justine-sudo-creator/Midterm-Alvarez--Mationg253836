/**
 * The Square class represents a four-sided drawing object with equal dimensions.
 * It implements the DrawingObject interface, utilizing Rectangle2D.Double to 
 * render a filled square with an optional stroke outline.
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

public class Square implements DrawingObject {
    private double x;
    private double y;
    private double size;
    private Color color;
    private boolean hasOutline;

    /**
     * Constructs a Square object with specified position, size, and color.
     *
     * @param x The horizontal coordinate of the square's origin.
     * @param y The vertical coordinate of the square's origin.
     * @param size The length of each side of the square.
     * @param color The fill color of the square.
     * @param hasOutline Determines if a black border is drawn.
     */
    public Square(double x, double y, double size, Color color, boolean hasOutline) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.hasOutline = hasOutline;
    }

    /**
     * Renders the square onto the Graphics2D context. It fills the shape 
     * with the assigned color and applies a stroke if hasOutline is true.
     *
     * @param g2d The Graphics2D context used for drawing.
     */
    @Override
    public void draw(Graphics2D g2d) {
        Rectangle2D.Double square = new Rectangle2D.Double(x, y, size, size);
        g2d.setColor(color);
        g2d.fill(square);

        if (hasOutline) {
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2));
            g2d.draw(square);
        }
    }

    /**
     * Adjusts the state of the square. Required by the DrawingObject interface.
     *
     * @param distance The value used to shift the state or position.
     */
    @Override
    public void adjust(double distance) {
        // Implementation for movement or state change can be added here.
    }

    /**
     * Retrieves the current horizontal position of the square.
     *
     * @return The x-coordinate as a double.
     */
    @Override
    public double getX() {
        return x;
    }
}