import java.awt.*;

public class Torso implements DrawingObject{
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

    public Torso(double x, double y, Color skinColor, Color hoodieColor){
        this.x = x;
        this.y = y;
        this.skinColor = skinColor;
        this.hoodieColor = hoodieColor;

        Color skinShadow = getShadowColor(skinColor);
        Color hoodieShadow = getShadowColor(hoodieColor);

        hood = new Oval(x, y, 171.9, 130.8, hoodieShadow, false);
        body = new Rectangle(x+3, y+53, 166.8, 189.3, hoodieColor, false);
        chest = new Triangle(x+58.3, y+49.9, 55.4, 36.7, skinColor, false);
        chestShadow = new Triangle(x+52.2, y+46.9, 68.8, 49.1, skinShadow, true);
        neck = new Rectangle(x+66, y+19.7, 38.6, 35, skinColor, false);
        neckShadow = new SemiCircle(x+66, y-8.7, 36.6, 24.1, 0.0, skinShadow, false, 180.0);
        neckOutline1 = new Line(x+67, y+19.7, x+67, y+50.9, 2, Color.BLACK);
        neckOutline2 = new Line(x+103.6, y+19.7, x+103.6, y+50.9, 2, Color.BLACK);
        lace1 = new Line(x+68.1, y+68.4, x+68.9, y+128.8, 3, Color.WHITE);
        lace2 = new Arc(x+75, y+92.4, 63.4, 15.5, 3, Color.WHITE, 100);
    }
    
    public void draw(Graphics2D g2d){
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
    }

    public void adjust(double distance){

    }

    public double getX(){
        return x;
    }

    private Color getShadowColor(Color baseColor) {
        int r = (int) (baseColor.getRed() * 0.8);
        int g = (int) (baseColor.getGreen() * 0.75);
        int b = (int) (baseColor.getBlue() * 0.7);
        
        return new Color(r, g, b);
    }
}
