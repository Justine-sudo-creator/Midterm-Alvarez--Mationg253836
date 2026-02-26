import java.awt.*;

public class Character implements DrawingObject {
    private double x, y;
    private Head head;
    private Torso torso;
    private Arm leftArm;
    private Arm rightArm;
    private double armAngle = 0;

    public Character(double x, double y, Color skin, Color hoodie, Color headphoneColor) {
        this.x = x;
        this.y = y;

        head = new Head(x, y, skin, headphoneColor, Color.BLACK);
        torso = new Torso(x - 34.8, y + 112.6, skin, hoodie);
        leftArm = new Arm(x - 24.9, y + 153.5, skin, hoodie, 34.6);
        rightArm = new Arm(x + 87.7, y + 178.5, skin, hoodie, -33);
    }

    @Override
    public void draw(Graphics2D g2d) {
        rightArm.draw(g2d);
        leftArm.draw(g2d);
        torso.draw(g2d);
        head.draw(g2d);
    }

    @Override
    public void adjust(double distance) {
        this.x += distance;

        head.setX(this.x);
        torso.setX(this.x - 34.8);
        leftArm.setX(this.x - 24.9);
        rightArm.setX(this.x + 87.7);

        armAngle += 0.2; 
        double swing = Math.sin(armAngle) * 15;
        leftArm.setRotation(34.6 + swing);
        rightArm.setRotation(-33 - swing);
    }

    @Override
    public double getX() {
        return x;
    }
}