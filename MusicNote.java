/**
 * The MusicNote class represents a musical notation symbol (beamed eighth notes). 
 * It combines multiple Circle and Line objects to create a composite shape 
 * that can be rendered and positioned dynamically on the canvas.
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

public class MusicNote implements DrawingObject {
    private Circle noteHead1;
    private Circle noteHead2;
    private Line stem1in, stem1out;
    private Line stem2in, stem2out;
    private Line handlein, handleout;
    private double x;
    private double y;
    private double size;
    private Color color;
    private int thickness;

    /**
     * Constructs a MusicNote object by calculating the positions of heads, 
     * stems, and the connecting beam based on the provided size and coordinates.
     *
     * @param x The horizontal coordinate of the note.
     * @param y The vertical coordinate of the note.
     * @param size The diameter of the note heads.
     * @param thickness The width of the stems and beam.
     * @param color The fill color for the note.
     */
    public MusicNote(double x, double y, double size, int thickness, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;

        double spacing = size * 1.5;

        double center = size / 2.0;
        double headCenterX1 = x + center;
        double headCenterY1 = y + center;
        double headCenterX2 = (x + spacing) + center;
        double headCenterY2 = y + center;

        double height = size * 2;

        noteHead1 = new Circle(x, y, size, color, false);
        noteHead2 = new Circle(x + spacing, y, size, color, false);
        stem1out = new Line(headCenterX1, headCenterY1, headCenterX1, headCenterY1 - height, thickness + 6, Color.BLACK);
        stem1in = new Line(headCenterX1, headCenterY1, headCenterX1, headCenterY1 - height, thickness, color);

        stem2out = new Line(headCenterX2, headCenterY2, headCenterX2, headCenterY2 - height, thickness + 6, Color.BLACK);
        stem2in = new Line(headCenterX2, headCenterY2, headCenterX2, headCenterY2 - height, thickness, color);

        handleout = new Line(headCenterX1, headCenterY1 - height, headCenterX2, headCenterY2 - height, thickness + 6, Color.BLACK);
        handlein = new Line(headCenterX1, headCenterY1 - height, headCenterX2, headCenterY2 - height, thickness, color);
    }
    
    /**
     * Renders the music note components including the heads, stems, and beams.
     * It uses layered line drawing to create an outlined effect.
     *
     * @param g2d The Graphics2D context used for drawing.
     */
    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform old = g2d.getTransform();
        
        g2d.translate(x, y);

        handleout.draw(g2d);
        stem1out.draw(g2d);
        stem2out.draw(g2d);

        stem1in.draw(g2d);
        stem2in.draw(g2d);
        handlein.draw(g2d);

        noteHead1.draw(g2d);
        noteHead2.draw(g2d);

        g2d.setTransform(old);
    }

    /**
     * Adjusts the horizontal position of the music note.
     *
     * @param distance The new x-coordinate value for the note.
     */
    @Override
    public void adjust(double distance) {
        this.x = distance;
    }
    
    /**
     * Retrieves the current horizontal position of the note.
     *
     * @return The x-coordinate as a double.
     */
    @Override
    public double getX() {
        return x;
    }
}