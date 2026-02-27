/**
 * The Arc class represents a quadratic curve drawing object. 
 * it utilizes Path2D and AffineTransform to render a rotatable arc 
 * that can be adjusted within the scene.
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

public class Arc implements DrawingObject {
    private double x;
    private double y;
    private double width;
    private double height;
    private int thickness;
    private Color color;
    private double rotation;

    /**
     * Constructs an Arc with specific coordinates, dimensions, and styling.
     * * @param x The x-coordinate of the arc.
     * @param y The y-coordinate of the arc.
     * @param width The width of the bounding area.
     * @param height The height/depth of the curve.
     * @param thickness The stroke width of the line.
     * @param color The color of the arc.
     * @param rotation The rotation angle in degrees.
     */
    public Arc(double x, double y, double width, double height, int thickness, Color color, double rotation) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.thickness = thickness;
        this.color = color;
        this.rotation = rotation;
    }

    /**
     * Draws the quadratic arc onto the canvas. 
     * It uses AffineTransform for rotation and Path2D for the curve logic.
     * * Sources: 
     * - AffineTransform (Oracle Java Docs): Used for rotation and translation.
     * - Path2D.Double (Oracle Java Docs): Used to create the quadratic curve.
     * * @param g2d The Graphics2D context used for drawing.
     */
    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();

        g2d.translate(x + width / 2, y + height / 2);
        g2d.rotate(Math.toRadians(rotation));

        Path2D.Double arc = new Path2D.Double();
        arc.moveTo(-width / 2, height / 2); 
        arc.quadTo(0, -height / 2, width / 2, height / 2);

        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.draw(arc);

        g2d.setTransform(reset);
    }

    /**
     * Adjusts the horizontal position of the arc.
     * * @param distance The amount to move the arc along the x-axis.
     */
    @Override
    public void adjust(double distance) {
        this.x += distance;
    }

    /**
     * Returns the current x-coordinate of the arc.
     * * @return The x-coordinate as a double.
     */
    @Override
    public double getX() {
        return x;
    }
}