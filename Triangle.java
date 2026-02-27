/**
 * The Triangle class represents a three-sided polygon drawing object.
 * It utilizes Path2D to define vertices relative to a center point and 
 * applies AffineTransform for translation and rotation within the scene.
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

public class Triangle implements DrawingObject {
    private double x;
    private double y;
    private double width;
    private double tip;
    private double rotation;
    private Color color;
    private boolean hasOutline;

    /**
     * Constructs a Triangle with specific position, dimensions, rotation, and color.
     *
     * @param x The horizontal coordinate for the triangle's center.
     * @param y The vertical coordinate for the triangle's center.
     * @param width The width of the triangle base.
     * @param tip The height from the base to the tip.
     * @param rotation The rotation angle in degrees.
     * @param color The fill color of the triangle.
     * @param hasOutline Determines if a black border is drawn around the shape.
     */
    public Triangle(double x, double y, double width, double tip, double rotation, Color color, boolean hasOutline) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.tip = tip;
        this.rotation = rotation;
        this.color = color;
        this.hasOutline = hasOutline;
    }

    /**
     * Renders the triangle onto the Graphics2D context. It defines the path
     * of the vertices and applies rotation and translation transforms.
     *
     * @param g2d The Graphics2D context used for drawing.
     */
    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform old = g2d.getTransform();
        
        g2d.translate(x, y);
        g2d.rotate(Math.toRadians(rotation));

        Path2D.Double triangle = new Path2D.Double();
        triangle.moveTo(-width / 2, -tip / 2);
        triangle.lineTo(0, tip / 2);
        triangle.lineTo(width / 2, -tip / 2);
        triangle.closePath();

        g2d.setColor(color);
        g2d.fill(triangle);

        if (hasOutline) {
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2));
            g2d.draw(triangle);
        }

        g2d.setTransform(old);
    }

    /**
     * Adjusts the state of the triangle. Required by the DrawingObject interface.
     *
     * @param distance The value used to shift the state or position.
     */
    @Override
    public void adjust(double distance) {
        // Implementation for movement can be added here if needed.
    }

    /**
     * Retrieves the current horizontal position of the triangle.
     *
     * @return The x-coordinate as a double.
     */
    @Override
    public double getX() {
        return x;
    }
    
    /**
     * Updates the rotation angle of the triangle.
     *
     * @param rotation The new rotation angle in degrees.
     */
    public void setRotation(double rotation) {
        this.rotation = rotation;
    }
}