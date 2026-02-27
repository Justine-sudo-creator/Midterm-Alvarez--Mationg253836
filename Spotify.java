/**
 * The Spotify class represents a graphical icon resembling a music streaming logo.
 * It is a composite DrawingObject that utilizes a Circle for the background 
 * and several Arc objects to create the signature sound-wave effect.
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

public class Spotify implements DrawingObject {
    private Circle back;
    private Arc arc1;
    private Arc arc2;
    private Arc arc3;

    private double x;
    private double y;

    /**
     * Constructs a Spotify icon at the specified coordinates, initializing
     * the background circle and the three internal arcs.
     *
     * @param x The horizontal coordinate of the icon.
     * @param y The vertical coordinate of the icon.
     */
    public Spotify(double x, double y) {
        this.x = x;
        this.y = y;

        back = new Circle(x, y, 64.9, Color.WHITE, true);
        arc1 = new Arc(x+9.7, y+18.4, 46.1, 10.6, 4, Color.BLACK, 0);
        arc2 = new Arc(x+11.7, y+27, 42.1, 10.6, 3, Color.BLACK, 0);
        arc3 = new Arc(x+11.7, y+35.6, 38.1, 10.6, 3, Color.BLACK, 0);
    }
    
    /**
     * Renders the Spotify icon by drawing the background followed by 
     * the sound-wave arcs in sequence.
     *
     * @param g2d The Graphics2D context used for drawing.
     */
    @Override
    public void draw(Graphics2D g2d) {
        back.draw(g2d);
        arc1.draw(g2d);
        arc2.draw(g2d);
        arc3.draw(g2d);
    }

    /**
     * Adjusts the state of the Spotify icon. Required by the DrawingObject interface.
     *
     * @param distance The value used to shift the state or position.
     */
    @Override
    public void adjust(double distance) {
        // Implementation for movement or state change can be added here.
    }

    /**
     * Retrieves the current horizontal position of the Spotify icon.
     *
     * @return The x-coordinate as a double.
     */
    @Override
    public double getX() {
        return x;
    }
}