import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SceneFrame {
    
    private JFrame frame;
    private JButton button;
    private SceneCanvas sceneCanvas;
    
    public SceneFrame() {
        frame = new JFrame();
        sceneCanvas = new SceneCanvas();
        button = new JButton("Listen to music");
        frame.pack();
        frame.setVisible(true);
    }

    public void setUpFrame() {
        Container contentPane = frame.getContentPane();
        JPanel buttons = new JPanel();
        
		buttons.add(new JLabel());
		buttons.add(button);
        
        contentPane.add(sceneCanvas, BorderLayout.CENTER);
        contentPane.add(buttons, BorderLayout.SOUTH);

        frame.setTitle("Midterm Project - Alvarez - Mationg");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void setUpButtonListener() {

        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Object o = ae.getSource();
                if(o == button) {
                  sceneCanvas.moveCharacter(100);

                }
                sceneCanvas.repaint();
            }
        };

        button.addActionListener(al);
    }
}
