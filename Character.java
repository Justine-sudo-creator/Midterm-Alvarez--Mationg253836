/**
 * The Character class serves as the central figure of the animation, assembling 
 * various body parts into a single entity. It manages the procedural animation 
 * logic that causes the character to "vibe" through arm swings and head bobbing.
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

public class Character implements DrawingObject {
    private double x, y;
    private Head head;
    private Torso torso;
    private Arm leftArm;
    private Arm rightArm;
    private double headYOffset = 0;
    private double vibeStep = 0;

    /**
     * Constructs the character by initializing its body parts at relative 
     * positions to the main anchor point.
     * * @param x The base x-coordinate for the character.
     * @param y The base y-coordinate for the character.
     * @param skin The color for skin-exposed parts.
     * @param hoodie The primary color for the torso and sleeves.
     * @param headphoneColor The color for the accessory equipment.
     */
    public Character(double x, double y, Color skin, Color hoodie, Color headphoneColor) {
        this.x = x;
        this.y = y;

        head = new Head(x, y, skin, headphoneColor, Color.BLACK);
        torso = new Torso(x - 34.8, y + 112.6, skin, hoodie);
        leftArm = new Arm(x - 24.9, y + 153.5, skin, hoodie, 34.6);
        rightArm = new Arm(x + 87.7, y + 178.5, skin, hoodie, -33);
    }

    /**
     * Renders the character by drawing each body part in a specific order.
     * It uses an AffineTransform to apply vertical displacement to the head.
     * * @param g2d The Graphics2D context used for drawing.
     */
    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform old = g2d.getTransform();
        
        rightArm.draw(g2d);
        leftArm.draw(g2d);
        torso.draw(g2d);
        
        // Apply vertical bobbing only to the head
        g2d.translate(0, headYOffset);
        head.draw(g2d);
        
        g2d.setTransform(old);
    }

    /**
     * Updates the animation state using sine waves to create periodic motion.
     * * Sources:
     * - Math.sin() (Oracle Java Docs): Used for calculating wave values.
     * - Oscillation Theory (Nature of Code): Used to simulate natural movement.
     * * @param distance The increment value applied to the current vibe cycle.
     */
    @Override
    public void adjust(double distance) {
        vibeStep += distance;
        
        // Calculate oscillation for arms
        double armSwing = Math.sin(vibeStep) * 20;
        leftArm.setRotation(34.6 + armSwing);
        rightArm.setRotation(-33 - armSwing);
        
        // Calculate head bobbing at double frequency
        headYOffset = Math.sin(vibeStep * 2) * 5;
    }

    /**
     * Retrieves the current anchor x-coordinate of the character.
     * * @return The horizontal position as a double.
     */
    @Override
    public double getX() {
        return x;
    }
}