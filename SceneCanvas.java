import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class SceneCanvas extends JComponent{
    private ArrayList<DrawingObject> elements;

    public SceneCanvas() {
        this.setPreferredSize(new Dimension(800,600));
        elements = new ArrayList<>();
        elements.add(new Headphones(331.8, 219.1, Color.decode("#cb6ce6")));
        elements.add(new Hair(335.8, 216.7, Color.BLACK));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        for (DrawingObject obj : elements) {
            obj.draw(g2d);
        }
    }
}
