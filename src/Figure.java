import java.awt.*;
import java.io.Serializable;

abstract class Figure implements Serializable {
    protected Color c;
    protected Point origin;
    protected int width;
    protected int length;
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }


    public abstract int getSurface();

    public abstract int getPerimeter();

    public Figure(Color c, Point origin) {
        this.c = c;
        this.origin = origin;
    }

    public Color getColor() {
        return c;
    }

    public abstract void setBoundingBox(int width, int length);

    public abstract void draw(Graphics g, int startX,int startY,int endX,int endY);

    @Override
    public String toString() {
        return "Figure{" + "color=" + c + ", origin=" + "(" + origin.X + ", " + origin.Y + ")" + ", width=" + width + ", length=" + length + '}';
    }
    public void setCoordinates(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }
}
