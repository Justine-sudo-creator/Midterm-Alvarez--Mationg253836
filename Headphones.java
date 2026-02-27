/**
 * The Headphones class represents a composite drawing object consisting of 
 * earcups, stems, and a headband. It coordinates several Rectangle and 
 * Square objects to create a detailed accessory for the character.
 * @author Justine T. Mationg (253836)
 * @author Adrian Adam Alvarez (250266)
 * @version February 26, 2026
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

public class Headphones implements DrawingObject {
    private Rectangle phone1;
    private Square sidePhone1;
    private Rectangle phone2;
    private Square sidePhone2;

    private Rectangle stem1;
    private Rectangle stem2;
    private Rectangle handleOut;
    private Rectangle handleIn;

    private double x;
    private double y;
    private Color color;

    /**
     * Constructs a Headphones object and initializes all internal components 
     * including the ear muffs, stems, and the connecting headband.
     *
     * @param x The base x-coordinate for the headphones.
     * @param y The base y-coordinate for the headphones.
     * @param color The primary color for the earcups.
     */
    public Headphones(double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;

        Color grey = Color.decode("#a8acb3");

        stem1 = new Rectangle(x, y, 16, 79.7, grey, true);
        stem2 = new Rectangle(x+116.2, y, 16, 79.7, grey, true);

        phone1 = new Rectangle(x-15, y+69.6, 31, 42.7, color, true);
        phone2 = new Rectangle(x+116.2, y+69.6, 31, 42.7, color, true);

        sidePhone1 = new Square(x-21.8, y+79, 27, grey, true);
        sidePhone2 = new Square(x+128.9, y+79, 27, grey, true);

        handleOut = new Rectangle(x, y, 116.2, 10.1, Color.BLACK, false);
        handleIn = new Rectangle(x+3.9, y+2, 124.4, 6.4, grey, false);
    }
    
    /**
     * Renders all components of the headphones in the correct layering order.
     *
     * @param g2d The Graphics2D context used for drawing.
     */
    @Override
    public void draw(Graphics2D g2d) {
        handleOut.draw(g2d);
        stem1.draw(g2d);
        stem2.draw(g2d);
        handleIn.draw(g2d);
        phone1.draw(g2d);
        phone2.draw(g2d);
        sidePhone1.draw(g2d);
        sidePhone2.draw(g2d);
    }

    /**
     * Adjusts the state of the headphones. Required by the DrawingObject interface.
     *
     * @param distance The value used to shift the state or position.
     */
    @Override
    public void adjust(double distance) {
        // Implementation for movement can be added here if needed.
    }

    /**
     * Retrieves the current horizontal position of the headphones.
     *
     * @return The x-coordinate as a double.
     */
    @Override
    public double getX() {
        return x;
    }
}