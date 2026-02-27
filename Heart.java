/**
 * The Heart class represents a heart-shaped drawing object used for UI interaction.
 * It is constructed using a combination of two ellipses and a path for the bottom
 * point, and it includes logic to toggle its color between red and white.
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

public class Heart implements DrawingObject {
    private double x; 
    private double y;
    private double size;
    private Color color;
    
    private boolean isLiked = false;

    /**
     * Constructs a Heart object with a specific position, size, and color.
     *
     * @param x The x-coordinate of the heart.
     * @param y The y-coordinate of the heart.
     * @param size The overall width and height of the heart.
     * @param color The initial color of the heart.
     */
    public Heart(double x, double y, double size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    /**
     * Default constructor for the Heart class.
     */
    public Heart() {
    }

    /**
     * Renders the heart onto the screen by combining two circles and a 
     * triangular point at the bottom.
     *
     * @param g2d The Graphics2D context used for drawing.
     */
    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();
        g2d.translate(x, y);

        g2d.setColor(color);

        double circleDiam = size * 0.6;
        
        Ellipse2D leftCircle = new Ellipse2D.Double(0, 0, circleDiam, circleDiam);
        Ellipse2D rightCircle = new Ellipse2D.Double(size - circleDiam, 0, circleDiam, circleDiam);
        
        Path2D bottomPoint = new Path2D.Double();
        bottomPoint.moveTo(0, circleDiam / 2.0);
        bottomPoint.lineTo(size / 2.0, size);
        bottomPoint.lineTo(size, circleDiam / 2.0);
        bottomPoint.closePath();

        g2d.fill(leftCircle);
        g2d.fill(rightCircle);
        g2d.fill(bottomPoint);

        g2d.setTransform(reset);
    }

    /**
     * Toggles the heart's "liked" state and changes its color 
     * between Red (liked) and White (unliked).
     */
    public void setColor() {
        isLiked = !isLiked;
        if (isLiked) {
            this.color = Color.RED;
        } else {
            this.color = Color.WHITE;
        }
    }

    /**
     * Adjusts the state of the heart. Required by the DrawingObject interface.
     *
     * @param distance The value used to shift the state or position.
     */
    @Override
    public void adjust(double distance) {
        // Implementation for movement can be added here if needed.
    }

    /**
     * Retrieves the current horizontal position of the heart.
     *
     * @return The x-coordinate as a double.
     */
    @Override
    public double getX() {
        return x;
    }
}