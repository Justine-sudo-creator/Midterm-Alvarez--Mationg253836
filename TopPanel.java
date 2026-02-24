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

        pause1 = new Rectangle(x + 392, y + 78, 6, 40, Color.WHITE, false);
        pause2 = new Rectangle(x + 407, y + 78, 6, 40, Color.WHITE, false);

        nextIn = new Triangle(x + 460, y + 90, 25, 25, 270, Color.WHITE, true);
        nextOut = new Triangle(x + 480, y + 90, 25, 25, 270, Color.WHITE, true);

        circle1 = new Circle(x + 580, y + 80, 8, Color.WHITE, false);
        circle2 = new Circle(x + 580, y + 95, 8, Color.WHITE, false);
        circle3 = new Circle(x + 580, y + 110, 8, Color.WHITE, false);

        playback = new Triangle(x + 400, y + 90, 20, 20, 90, color, false);
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillRect((int)x, (int)y, 800, 150);

        logo.draw(g2d);
        heart.draw(g2d);
        
        pause1.draw(g2d);
        pause2.draw(g2d);
        
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
    }

    public void adjust(double distance) {
    }

    public double getX() { 
        return x; 
    }
}