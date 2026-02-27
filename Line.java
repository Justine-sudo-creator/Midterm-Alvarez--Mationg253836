/**
 * The Line class represents a straight-line drawing object in the scene. 
 * It implements the DrawingObject interface and allows for customization 
 * of start and end points, thickness, and color using the Line2D geometry.
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

public class Line implements DrawingObject {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private int thickness;
    private Color color;

    /**
     * Constructs a Line object with specified start and end coordinates, 
     * stroke thickness, and color.
     *
     * @param x1 The x-coordinate of the start point.
     * @param y1 The y-coordinate of the start point.
     * @param x2 The x-coordinate of the end point.
     * @param y2 The y-coordinate of the end point.
     * @param thickness The stroke width of the line.
     * @param color The color used to render the line.
     */
    public Line(double x1, double y1, double x2, double y2, int thickness, Color color) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.thickness = thickness;
        this.color = color;
    }

    /**
     * Renders the line onto the Graphics2D context using Line2D.Double.
     * Sets the specified color and stroke thickness before drawing.
     *
     * @param g2d The Graphics2D context used for rendering.
     */
    @Override
    public void draw(Graphics2D g2d) {
        Line2D.Double line = new Line2D.Double(x1, y1, x2, y2);
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(thickness));
        g2d.draw(line);
    }

    /**
     * Adjusts the state of the line. Required by the DrawingObject interface.
     *
     * @param distance The value used to shift the state or position.
     */
    @Override
    public void adjust(double distance) {
        // Implementation for movement can be added here if needed.
    }

    /**
     * Retrieves the current horizontal starting position of the line.
     *
     * @return The x1 coordinate as a double.
     */
    @Override
    public double getX() {
        return x1;
    }
}