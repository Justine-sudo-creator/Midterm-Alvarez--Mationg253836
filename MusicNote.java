import java.awt.*;

public class MusicNote implements DrawingObject{
    private Circle noteHead1;
    private Circle noteHead2;
    private Line stem1in, stem1out;
    private Line stem2in, stem2out;
    private Line handlein, handleout;
    private double x;
    private double y;
    private double size;
    private Color color;
    private int thickness;

    public MusicNote(double x, double y, double size, int thickness, Color color){
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;

        double spacing = size*1.5;

        double center = size / 2.0;
        double headCenterX1 = x + center;
        double headCenterY1 = y + center;
        double headCenterX2 = (x + spacing) + center;
        double headCenterY2 = y + center;

        double height = size*2;

        noteHead1 = new Circle(x, y, size, color, false);
        noteHead2 = new Circle(x+spacing, y, size, color, false);
        stem1out = new Line(headCenterX1, headCenterY1, headCenterX1, headCenterY1-height, thickness+6, Color.BLACK);
        stem1in = new Line(headCenterX1, headCenterY1, headCenterX1, headCenterY1-height, thickness, color);

        stem2out = new Line(headCenterX2, headCenterY2, headCenterX2, headCenterY2-height, thickness+6, Color.BLACK);
        stem2in = new Line(headCenterX2, headCenterY2, headCenterX2, headCenterY2-height, thickness, color);

        handleout = new Line(headCenterX1, headCenterY1-height, headCenterX2, headCenterY2-height, thickness+6, Color.BLACK);
        handlein = new Line(headCenterX1, headCenterY1-height, headCenterX2, headCenterY2-height, thickness, color);
    }
    
    public void draw(Graphics2D g2d){
        handleout.draw(g2d);
        stem1out.draw(g2d);
        stem2out.draw(g2d);

        stem1in.draw(g2d);
        stem2in.draw(g2d);
        handlein.draw(g2d);

        noteHead1.draw(g2d);
        noteHead2.draw(g2d);
    }

    public void adjust(double distance){

    }
    
    public double getX(){
        return x;
    }
}
