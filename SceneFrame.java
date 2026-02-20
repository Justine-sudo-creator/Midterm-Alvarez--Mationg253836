import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SceneFrame {
    
    private int width;
    private int height;
    private JFrame frame;
    private JButton button;
    private SceneCanvas sceneCanvas;

    public SceneFrame(int w, int h) {
        width = w;
        height = h;
        frame = new JFrame();
        sceneCanvas = new SceneCanvas(width, height);
        button = new JButton("CLick me");
    }

    public void setUpFrame() {
        Container contentPane = frame.getContentPane();

        contentPane.add(sceneCanvas, BorderLayout.CENTER);

        frame.setTitle("Midterm Project - Alvarez - Mationg");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void setUpButtonListener() {

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Object o = ae.getSource();

                if(o == button) {

                }
            }
        };

        button.addActionListener(al);
    }
}
