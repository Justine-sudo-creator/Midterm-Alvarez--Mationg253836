/**
 * The Arm class represents a composite drawing object consisting of a sleeve, 
 * arm, and hand. It utilizes AffineTransform to manage complex rotations 
 * and positioning relative to the character's body.
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

public class Arm implements DrawingObject {
    private Rectangle arm;
    private Rectangle sleeve;
    private Oval hand;

    private double x;
    private double y;
    private double rotation;
    private Color skinColor;
    private Color hoodieColor;

    /**
     * Constructs an Arm object and initializes its sub-components 
     * including the sleeve, arm rectangle, and hand oval.
     * * @param x The x-coordinate for the arm's pivot point.
     * @param y The y-coordinate for the arm's pivot point.
     * @param skinColor The color used for the hand component.
     * @param hoodieColor The color used for the sleeve and arm components.
     * @param rotation The initial rotation angle in degrees.
     */
    public Arm(double x, double y, Color skinColor, Color hoodieColor, double rotation) {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        this.skinColor = skinColor;
        this.hoodieColor = hoodieColor;

        arm = new Rectangle(0, 0, 46.8, 107, hoodieColor, false);
        sleeve = new Rectangle(3.5, 103.4, 39.9, 20.4, hoodieColor, false);
        hand = new Oval(3.5, 119.6, 39.5, 39.5, skinColor, true);
    }
    
    /**
     * Renders the arm and its components to the screen. 
     * It applies a translation and rotation transformation to ensure 
     * the arm swings correctly from its pivot.
     * * Sources:
     * - AffineTransform (Oracle Java Docs): Used for rotation and translation.
     * - Math.toRadians (Oracle Java Docs): Used to convert degrees to radians.
     * * @param g2d The Graphics2D context used for drawing.
     */
    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();

        g2d.translate(x, y); 
        g2d.rotate(Math.toRadians(rotation)); 

        arm.draw(g2d);
        hand.draw(g2d);
        sleeve.draw(g2d);

        g2d.setTransform(reset);
    }

    /**
     * Updates the rotation angle of the arm for animation purposes.
     * * @param degrees The new rotation angle in degrees.
     */
    public void setRotation(double degrees) {
        this.rotation = degrees;
    }

    /**
     * Adjusts the state of the arm. Required by the DrawingObject interface.
     * * @param distance The value used to increment the arm's state.
     */
    @Override
    public void adjust(double distance) {
        // Implementation left empty if handled by parent class
    }

    /**
     * Sets a new x-coordinate for the arm.
     * * @param newX The new horizontal position.
     */
    public void setX(double newX) {
        this.x = newX;
    }

    /**
     * Retrieves the current x-coordinate of the arm.
     * * @return The x-coordinate as a double.
     */
    @Override
    public double getX() {
        return x;
    }
}