/**
 * The TopPanel class represents the user interface overlay for the animation. 
 * It coordinates multiple UI components such as a Spotify logo, playback 
 * controls (play, pause, next, back), a progress bar, and a heart icon.
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

public class TopPanel implements DrawingObject {
    private Spotify logo;
    private Heart heart;
    private Rectangle pause1;
    private Rectangle pause2;
    private Triangle nextOut;
    private Triangle nextIn;
    private Triangle backOut;
    private Triangle backIn;
    private Circle circle1, circle2, circle3;
    private Triangle playback;

    private Circle progressCircle;
    private Line playProgress;
    private Line playProgressBack;

    private double x;
    private double y;
    private Color color;

    private boolean isPaused = true;

    /**
     * Constructs a TopPanel object and initializes all UI elements 
     * including playback buttons, progress bars, and the logo.
     *
     * @param x The horizontal coordinate of the panel.
     * @param y The vertical coordinate of the panel.
     * @param color The background color of the panel.
     */
    public TopPanel(double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;

        logo = new Spotify(x + 25, y + 20);
        
        playProgressBack = new Line(x + 200, y + 45, x + 600, y + 45, 4, Color.GRAY);
        playProgress = new Line(x + 200, y + 45, x + 450, y + 45, 4, Color.WHITE);
        progressCircle = new Circle(x + 450, y + 41, 10, Color.WHITE, false);

        heart = new Heart(x + 200, y + 90, 25, Color.WHITE);

        backOut = new Triangle(x + 320, y + 90, -25, 25, 90, Color.WHITE, true);
        backIn = new Triangle(x + 340, y + 90, -25, 25, 90, Color.WHITE, true);

        pause1 = new Rectangle(x + 392, y + 78, 6, 30, Color.WHITE, true);
        pause2 = new Rectangle(x + 407, y + 78, 6, 30, Color.WHITE, true);

        nextIn = new Triangle(x + 460, y + 90, 25, 25, 270, Color.WHITE, true);
        nextOut = new Triangle(x + 480, y + 90, 25, 25, 270, Color.WHITE, true);

        circle1 = new Circle(x + 580, y + 80, 8, Color.WHITE, false);
        circle2 = new Circle(x + 580, y + 95, 8, Color.WHITE, false);
        circle3 = new Circle(x + 580, y + 110, 8, Color.WHITE, false);

        playback = new Triangle(x + 405, y + 93, 25, 25, 270, Color.WHITE, true);
    }

    /**
     * Renders the background panel and all sub-components. 
     * Switches between play and pause icons based on current state.
     *
     * @param g2d The Graphics2D context used for drawing.
     */
    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillRect((int)x, (int)y, 800, 150);

        logo.draw(g2d);

        if (isPaused) {
            playback.draw(g2d);
        } else {
            pause1.draw(g2d);
            pause2.draw(g2d);
        }
        
        nextIn.draw(g2d);
        nextOut.draw(g2d);
        backIn.draw(g2d);
        backOut.draw(g2d);

        circle1.draw(g2d);
        circle2.draw(g2d);
        circle3.draw(g2d);

        playProgressBack.draw(g2d);
        playProgress.draw(g2d);
        progressCircle.draw(g2d);

        heart.draw(g2d);
    }

    /**
     * Adjusts the panel state. This is a required implementation of DrawingObject.
     *
     * @param distance The value used to adjust the state.
     */
    @Override
    public void adjust(double distance) {}

    /**
     * Retrieves the current horizontal coordinate of the panel.
     *
     * @return The x-coordinate as a double.
     */
    @Override
    public double getX() { return x; }

    /**
     * Toggles the playback state between paused and playing.
     */
    public void togglePause() {
        isPaused = !isPaused;
    }

    /**
     * Checks if the player is currently in a paused state.
     *
     * @return True if paused, false otherwise.
     */
    public boolean isPaused() {
        return isPaused;
    }

    /**
     * Triggers the heart icon to change its color state.
     */
    public void toggleHeart() {
        heart.setColor();
    }
}