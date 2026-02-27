/**
 * The Face class represents the detailed facial features of the character. 
 * It assembles multiple Arc and Oval objects to create eyes, eyebrows, 
 * and a mouth, while using Path2D to render a custom nose shape.
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

public class Face implements DrawingObject {
    private Oval head;
    private Arc eyebrow1;
    private Arc eye1;
    private Arc eyebrow2;
    private Arc eye2;
    private Arc smile;

    private double x;
    private double y;
    private Color skinColor;

    /**
     * Constructs a Face object by initializing the positions and colors 
     * of the head, eyes, eyebrows, and smile components.
     * * @param x The base x-coordinate for the face.
     * @param y The base y-coordinate for the face.
     * @param skinColor The color used for the head component.
     */
    public Face(double x, double y, Color skinColor) {
        this.x = x;
        this.y = y;
        this.skinColor = skinColor;

        head = new Oval(x, y, 100.3, 136.9, skinColor, true);
        eyebrow1 = new Arc(x+15.3, y+55.7, 18.5, 9.8, 4, Color.BLACK, 330);
        eye1 = new Arc(x+28.3, y+73.7, 10.6, 9.8, 3, Color.BLACK, 180);
        eyebrow2 = new Arc(x+68.7, y+55.7, 18.5, 9.8, 4, Color.BLACK, 30);
        eye2 = new Arc(x+64.7, y+73.7, 10.6, 9.8, 3, Color.BLACK, 180);
        smile = new Arc(x+28.6, y+106.2, 43, 13.3, 2, Color.BLACK, 180);
    }
    
    /**
     * Draws the face and all its facial features onto the screen.
     * This method also defines and renders a custom nose using a Bezier curve.
     * * @param g2d The Graphics2D context used for drawing.
     */
    @Override
    public void draw(Graphics2D g2d) {
        head.draw(g2d);
        eyebrow1.draw(g2d);
        eye1.draw(g2d);
        eyebrow2.draw(g2d);
        eye2.draw(g2d);
        smile.draw(g2d);

        Path2D.Double nose = new Path2D.Double();
        
        double startX = x + 48.7; 
        double startY = y + 74.7;
        nose.moveTo(startX, startY);
        nose.curveTo(startX + 10, startY + 4, startX - 12, startY + 14, startX + 5, startY + 18);

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.draw(nose);
    }

    /**
     * Adjusts the state of the face. Required by the DrawingObject interface.
     * * @param distance The value used to shift the state of the object.
     */
    @Override
    public void adjust(double distance) {
        // Implementation for facial movement can be added here.
    }

    /**
     * Retrieves the current horizontal position of the face.
     * * @return The x-coordinate as a double.
     */
    @Override
    public double getX() {
        return x;
    }
}