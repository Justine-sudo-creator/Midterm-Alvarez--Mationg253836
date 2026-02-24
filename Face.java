import java.awt.*;
import java.awt.geom.*;

public class Face implements DrawingObject{
    private Oval head;
    private Arc eyebrow1;
    private Arc eye1;
    private Arc eyebrow2;
    private Arc eye2;
    private Arc smile;

    private double x;
    private double y;
    private Color skinColor;

    public Face(double x, double y, Color skinColor){
        this.x = x;
        this.y = y;
        this.skinColor = skinColor;

        head = new Oval(x, y, 100.3, 136.9, skinColor, true);
        eyebrow1 = new Arc(x+15.3, y+55.7, 18.5, 9.8, 4, Color.BLACK, 330);
        eye1 = new Arc(x+28.3, y+73.7, 10.6, 9.8, 3, Color.BLACK, 180);
        eyebrow2 = new Arc(x+68.7, y+55.7, 18.5, 9.8, 4, Color.BLACK, 30);
        eye2 = new Arc(x+64.7, y+73.7, 10.6, 9.8, 3, Color.BLACK, 180);
        smile = new Arc(x+28.6, y+106.2, 43, 13.3, 2, Color.BLACK, 180);
    }
    
    public void draw(Graphics2D g2d){
        head.draw(g2d);
        eyebrow1.draw(g2d);
        eye1.draw(g2d);
        eyebrow2.draw(g2d);
        eye2.draw(g2d);
        smile.draw(g2d);

        Path2D.Double nose = new Path2D.Double();
        
        double startX = x + 48.7; 
        double startY = y + 74.7;
        nose.moveTo(startX, startY);
        nose.curveTo(startX + 10, startY + 4, startX - 12, startY + 14, startX + 5, startY + 18);

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.draw(nose);
    }

    public void adjust(double distance){

    }

    public double getX(){
        return x;
    }
}
