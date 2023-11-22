import java.awt.*;

public class Square extends Rectangle {
    public Square(int px, int py, Color c) {
        super(px, py, c);
    }

    // Override setBoundingBox method to ensure equal width and length for a square
    @Override
    public void setBoundingBox(int sizeBB, int sizeBB2) {
        super.setBoundingBox(sizeBB, sizeBB);
    }

    @Override
    public void setLength(int length) {
        super.setLength(length);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
    }
}

