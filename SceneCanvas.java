/**
 * SceneCanvas represents the main drawing area for the animation. 
 * This class handles the rendering of all graphical components and manages 
 * the interactive mouse events and animation timers.
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
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class SceneCanvas extends JComponent {
    private Character c;
    private ArrayList<MusicNote> mn;
    private TopPanel tp;
    private Rectangle bg;
    private ArrayList<DrawingObject> elements;
    private Random rah;
    private Timer vibeTimer;

    /**
     * Constructs a new SceneCanvas and initializes all drawing objects.
     * It sets up the lists for elements, initializes the random number generator,
     * and starts the Swing Timer for the animation loop.
     * Sources:
     * - Anonymous Inner Classes
     * - Swing Timer
     */
    public SceneCanvas() {
        this.setPreferredSize(new Dimension(800, 600));
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
        elements = new ArrayList<>();
        mn = new ArrayList<>();
        rah = new Random();

        Color skin = Color.decode("#e8ad53");
        Color hoodie = Color.decode("#1800ad");
        Color hp = Color.decode("#cb6ce6");
        Color panel = Color.decode("#1db954");

        bg = new Rectangle(0, 0, 800, 600, Color.WHITE, false);
        c = new Character(348.4, 245.1, skin, hoodie, hp);
        tp = new TopPanel(0, 0, panel);

        elements.add(bg);
        elements.add(c);
        elements.add(tp);

        vibeTimer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tp.isPaused()) {
                    c.adjust(0.15);
                    repaint();
                }
            }
        });
        vibeTimer.start();

        /**
         * Mouse listener for handling button interaction.
         * Sources:
         * - MouseAdapter
         * - 2D Hitbox Detection
         */
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int mx = e.getX();
                int my = e.getY();

                if (mx >= 195 && mx <= 230 && my >= 85 && my <= 120) {
                    tp.toggleHeart();
                } else if ((mx >= 445 && mx <= 500 && my >= 80 && my <= 100) || 
                           (mx >= 305 && mx <= 360 && my >= 80 && my <= 100)) {
                    setRandomBackground();
                } else if (mx >= 380 && mx <= 425 && my >= 75 && my <= 115) {
                    tp.togglePause();
                }
                repaint();
            }
        });
    }

    /**
     * Changes the background to a randomly generated color.
     * Sources:
     * - Math.random()
     * - Random Number Scaling
     * - RGB Color Model
     * - Double to Int Casting
     */
    private void setRandomBackground() {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        changeBackground(new Color(r, g, b));
    }

    /**
     * Renders the graphical components to the screen.
     * Iterates through the elements and music notes lists to call their draw methods.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        for (DrawingObject obj : elements) {
            if (obj != null) obj.draw(g2d);
        }

        for (MusicNote note : mn) {
            if (note != null) note.draw(g2d);
        }
    }

    /**
     * Manually adjusts the character's position or state.
     * @param distance The amount by which to adjust the state.
     */
    public void moveCharacter(double distance) {
        c.adjust(distance);
        repaint();
    }

    /**
     * Updates the color of the background rectangle.
     * @param color The new Color to set.
     */
    public void changeBackground(Color color) {
        bg.setColor(color);
    }

    /**
     * Adds a new Music Note at a random location on the canvas.
     */
    public void addMusicNote() {
        int xRah = rah.nextInt(700);
        int yRah = rah.nextInt(300) + 150; 
        MusicNote newNote = new MusicNote(xRah, yRah, 50, 10, Color.BLACK);
        mn.add(newNote);
        repaint();
    }

    /**
     * Clears all music notes from the screen.
     */
    public void clearMusicNotes() {
        mn.clear();
        repaint();
    }

    /**
     * Returns the character object.
     * @return The current Character instance.
     */
    public Character getCharacter() {
        return c;
    }
}