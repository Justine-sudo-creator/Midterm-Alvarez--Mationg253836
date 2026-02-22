import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class SceneCanvas extends JComponent{
    private ArrayList<DrawingObject> elements;

    public SceneCanvas() {
        this.setPreferredSize(new Dimension(800,600));
        elements = new ArrayList<DrawingObject>();
        elements.add(new MusicNote(200, 200, 50,5, Color.BLUE));

        elements.add(new MusicNote(400, 400, 100,5, Color.RED));
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
