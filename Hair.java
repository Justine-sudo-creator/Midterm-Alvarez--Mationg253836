/**
 * The Hair class represents a composite drawing object that simulates the 
 * character's hairstyle. It aggregates various geometric shapes such as 
 * SemiCircles, QuarterCircles, and Pentagons into an ArrayList to render 
 * complex hair structures.
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
import java.util.ArrayList;

public class Hair implements DrawingObject {
    private ArrayList<DrawingObject> pieces;
    private double x, y;
    private Color color;

    /**
     * Constructs a Hair object by initializing a collection of geometric shapes
     * positioned relative to the base coordinates to form a complete hairstyle.
     * * @param x The base x-coordinate for the hair placement.
     * @param y The base y-coordinate for the hair placement.
     * @param color The color used for all hair segments.
     */
    public Hair(double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.pieces = new ArrayList<DrawingObject>();

        this.pieces.add(new SemiCircle(x, y, 126.0, 53.0, 0.0, color, false, 0.0));
        this.pieces.add(new QuarterCircle(x-7.4, y+28, 78.2, 90.0, color, false, -54.4));
        this.pieces.add(new QuarterCircle(x+50.9, y+28, 78.2, 90.0, color, false, 145.4));
        this.pieces.add(new Pentagon(x+12.6, y+34.9, 40.5, 44.1, 19.845, color, 180.0));
        this.pieces.add(new Pentagon(x+36.1, y+30.4, 40.5, 44.1, 19.845, color, 165.0));
        this.pieces.add(new Pentagon(x+70.2, y+40.9, 27.7, 44.1, 19.845, color, 217.3));
        this.pieces.add(new Pentagon(x+12, y+4, 40.5, 44.1, 19.845, color, -30.0));
        this.pieces.add(new Pentagon(x+35, y-8, 40.5, 44.1, 19.845, color, -25.0));
        this.pieces.add(new Pentagon(x+70, y-3, 40.5, 44.1, 19.845, color, 20.0));
        this.pieces.add(new Pentagon(x+100.3, y+39.5, 40.5, 44.1, 19.845, color, 80.3));
    }

    /**
     * Renders all geometric pieces that make up the hair.
     * * @param g2d The Graphics2D context used for drawing.
     */
    @Override
    public void draw(Graphics2D g2d) {
        for (DrawingObject piece : pieces) {
            piece.draw(g2d);
        }
    }

    /**
     * Adjusts the horizontal position of the hair and all its individual segments.
     * * @param distance The amount to shift the hair along the x-axis.
     */
    @Override
    public void adjust(double distance) {
        this.x += distance;
        for (DrawingObject piece : pieces) {
            piece.adjust(distance);
        }
    }

    /**
     * Retrieves the current horizontal position of the hair.
     * * @return The x-coordinate as a double.
     */
    @Override
    public double getX() {
        return x;
    }
}