/**
 * The DrawingObject interface defines the essential behaviors for all graphical 
 * elements within the animation. It ensures that every implementing class 
 * provides logic for rendering, state adjustment, and coordinate retrieval.
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

public interface DrawingObject {
    
    /**
     * Renders the object onto the screen using the Graphics2D context.
     * * @param g2d The graphics context used for drawing.
     */
    void draw(Graphics2D g2d);

    /**
     * Adjusts the internal state or position of the object for animation.
     * * @param distance The value used to increment the animation or position.
     */
    void adjust(double distance);

    /**
     * Retrieves the current horizontal position of the object.
     * * @return The x-coordinate as a double.
     */
    double getX();
}