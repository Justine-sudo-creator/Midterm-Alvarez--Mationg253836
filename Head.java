/**
 * The Head class acts as a container for all head-related features. 
 * It manages the relative positioning and rendering of the face, hair, 
 * and headphones, ensuring they move together as a single unit.
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

public class Head implements DrawingObject {
    private Headphones headphones;
    private Hair hair;
    private Face face;

    private double x;
    private double y;
    private Color skinColor;
    private Color headphonesColor;
    private Color hairColor;

    /**
     * Constructs the Head object and initializes the sub-components including 
     * headphones, hair, and face at specific local offsets.
     * * @param x The base x-coordinate for the head.
     * @param y The base y-coordinate for the head.
     * @param skinColor The color used for the face component.
     * @param headphonesColor The color used for the headphones component.
     * @param hairColor The color used for the hair segments.
     */
    public Head(double x, double y, Color skinColor, Color headphonesColor, Color hairColor) {
        this.x = x;
        this.y = y;
        this.skinColor = skinColor;
        this.headphonesColor = headphonesColor;
        this.hairColor = hairColor;

        headphones = new Headphones(-16.6, -26, headphonesColor);
        hair = new Hair(-12.6, -28.4, hairColor);
        face = new Face(0, 0, skinColor);
    }
    
    /**
     * Renders the head and all its constituent parts. It applies a 
     * translation transform to position the face, headphones, and hair 
     * correctly in the global coordinate system.
     * * @param g2d The Graphics2D context used for drawing.
     */
    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform old = g2d.getTransform();
        
        g2d.translate(x, y);

        face.draw(g2d);
        headphones.draw(g2d);
        hair.draw(g2d);

        g2d.setTransform(old);
    }

    /**
     * Adjusts the state of the head. Required by the DrawingObject interface.
     * * @param distance The value used to shift the state or position of the head.
     */
    @Override
    public void adjust(double distance) {
        // Implementation for additional movement can be added here.
    }

    /**
     * Retrieves the current horizontal position of the head.
     * * @return The x-coordinate as a double.
     */
    @Override
    public double getX() {
        return x;
    }
}