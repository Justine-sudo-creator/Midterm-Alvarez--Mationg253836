/**
 * SceneFrame initializes the main window and UI components for the application.
 * It manages the layout of the drawing canvas and handles the interactions
 * of the control buttons used to modify the scene.
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
import java.awt.event.*;
import javax.swing.*;

public class SceneFrame {
    
    private JFrame frame;
    private JButton button;
    private JButton clrButton;
    private SceneCanvas sceneCanvas;
    
    /**
     * Constructor for SceneFrame that instantiates the window, 
     * drawing canvas, and control buttons.
     */
    public SceneFrame() {
        frame = new JFrame();
        sceneCanvas = new SceneCanvas();
        button = new JButton("ACTIVATE MUSIC NOTE!!");
        clrButton = new JButton("CLEAR");
    }

    /**
     * Sets up the frame's layout, adds the buttons to a panel, 
     * and positions the canvas within the content pane.
     */
    public void setUpFrame() {
        Container contentPane = frame.getContentPane();
        JPanel buttons = new JPanel();
        
        buttons.add(new JLabel());
        buttons.add(button);
        buttons.add(clrButton);
        
        contentPane.add(sceneCanvas, BorderLayout.CENTER);
        contentPane.add(buttons, BorderLayout.SOUTH);

        frame.setTitle("Midterm Project - Alvarez - Mationg");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Creates and attaches an ActionListener to the buttons to handle 
     * user clicks for adding or clearing music notes.
     */
    public void setUpButtonListener() {

        /**
         * Anonymous inner class to handle button action events.
         * [Source: https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html]
         */
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Object o = ae.getSource();
                if(o == button) {
                  sceneCanvas.addMusicNote();
                } else if(o == clrButton) {
                    sceneCanvas.clearMusicNotes();
                }
                sceneCanvas.repaint();
            }
        };

        button.addActionListener(al);
        clrButton.addActionListener(al);
    }
}