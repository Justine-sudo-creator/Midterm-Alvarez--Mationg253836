import java.awt.*;
import javax.swing.*;

public class SceneCanvas extends JComponent{
    private int width;
    private int height;

    public SceneCanvas(int w, int h) {
        width = w;
        height = h;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);
    }
}
