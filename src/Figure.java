import java.awt.*;
abstract class Figure {
    protected Color c;
    protected Point origin;
    protected int width;
    protected int length;

    public abstract int getSurface();

    public abstract int getPerimeter();

    public Figure(Color c, Point origin) {
        this.c = c;
        this.origin = origin;
    }

    public Color getColor() {
        return c;
    }

    public Point getOrigin() {
        return origin;
    }

    public abstract void setBoundingBox(int width, int length);

    public abstract void draw(Graphics g);

    @Override
    public String toString() {
        return "Figure{" + "color=" + c + ", origin=" + "(" + origin.X + ", " + origin.Y + ")" + ", width=" + width + ", length=" + length + '}';
    }

}
