import java.awt.*;
public class Circle extends Ellipse {

    public Circle(int px, int py, Color c) {
        super(px, py, c);
    }
    // Override setBoundingBox method to ensure equal width and length for a circle
    @Override
    public void setBoundingBox(int sizeBB, int sizeBB2) {
        super.setBoundingBox(sizeBB, sizeBB);
    }

    @Override
    public void setSemiAxisX(int semiAxisX) {
        super.setSemiAxisX(semiAxisX);
    }

    @Override
    public void setSemiAxisY(int semiAxisY) {
        super.setSemiAxisY(semiAxisY);
    }
}
