/**
 * The Torso class represents the upper body of the character, including the 
 * hoodie and neck area. It manages multiple sub-components like Ovals, 
 * Rectangles, and Triangles to create a layered visual effect with shading.
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

public class Torso implements DrawingObject {
    private Oval hood;
    private Rectangle body;
    private Triangle chest;
    private Triangle chestShadow;
    private Rectangle neck;
    private SemiCircle neckShadow;
    private Line neckOutline1;
    private Line neckOutline2;
    private Line lace1;
    private Arc lace2;

    private double x;
    private double y;
    private Color skinColor;
    private Color hoodieColor;

    /**
     * Constructs a Torso object with specific positions and colors, 
     * initializing all structural components and calculating shadow colors.
     *
     * @param x The horizontal coordinate for the torso.
     * @param y The vertical coordinate for the torso.
     * @param skinColor The color used for the neck and chest.
     * @param hoodieColor The primary color for the hoodie.
     */
    public Torso(double x, double y, Color skinColor, Color hoodieColor) {
        this.x = x;
        this.y = y;
        this.skinColor = skinColor;
        this.hoodieColor = hoodieColor;

        Color skinShadow = getShadowColor(skinColor);
        Color hoodieShadow = getShadowColor(hoodieColor);

        hood = new Oval(0, 0, 171.9, 130.8, hoodieShadow, false);
        body = new Rectangle(3, 53, 166.8, 189.3, hoodieColor, false);
        chest = new Triangle(83.3, 69.9, 55.4, 36.7, 0, skinColor, false);
        chestShadow = new Triangle(84.2, 70.9, 68.8, 49.1, 0, skinShadow, true);
        neck = new Rectangle(66, 19.7, 38.6, 35, skinColor, false);
        neckShadow = new SemiCircle(66, -5.7, 36.6, 24.1, 0.0, skinShadow, false, 180.0);
        neckOutline1 = new Line(67, 19.7, 67, 50.9, 2, Color.BLACK);
        neckOutline2 = new Line(103.6, 19.7, 103.6, 50.9, 2, Color.BLACK);
        lace1 = new Line(68.1, 68.4, 68.9, 128.8, 3, Color.WHITE);
        lace2 = new Arc(75, 92.4, 63.4, 15.5, 3, Color.WHITE, 100);
    }
    
    /**
     * Renders the torso and its sub-components using an AffineTransform 
     * for localized positioning.
     *
     * @param g2d The Graphics2D context used for drawing.
     */
    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform old = g2d.getTransform();
        
        g2d.translate(x, y);

        hood.draw(g2d);
        body.draw(g2d);
        chestShadow.draw(g2d);
        chest.draw(g2d);
        lace1.draw(g2d);
        lace2.draw(g2d);
        neck.draw(g2d);
        neckShadow.draw(g2d);
        neckOutline1.draw(g2d);
        neckOutline2.draw(g2d);

        g2d.setTransform(old);
    }

    /**
     * Adjusts the state of the torso. Required by the DrawingObject interface.
     *
     * @param distance The value used to shift the state or position.
     */
    @Override
    public void adjust(double distance) {
        // Implementation for movement can be added here if needed.
    }

    /**
     * Retrieves the current horizontal position of the torso.
     *
     * @return The x-coordinate as a double.
     */
    @Override
    public double getX() {
        return x;
    }

    /**
     * Generates a darker version of a base color to be used for shadows.
     *
     * @param baseColor The original color to be darkened.
     * @return A new Color object representing the shadow.
     */
    private Color getShadowColor(Color baseColor) {
        int r = (int) (baseColor.getRed() * 0.8);
        int g = (int) (baseColor.getGreen() * 0.75);
        int b = (int) (baseColor.getBlue() * 0.7);
        
        return new Color(r, g, b);
    }
}