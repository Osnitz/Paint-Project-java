import java.awt.*;

class Ellipse extends Figure {
    protected int semiAxisX;
    protected int semiAxisY;

    public Ellipse(int px, int py, Color c) {
        super(c, new Point(px, py));
        this.semiAxisX = 0;
        this.semiAxisY = 0;
        this.width = 2*semiAxisY;
        this.length = 2*semiAxisX;
    }

    public int getSemiAxisX() {
        return semiAxisX;
    }

    public int getSemiAxisY() {
        return semiAxisY;
    }

    public void setSemiAxisX(int semiAxisX) {
        this.semiAxisX = semiAxisX;
    }

    public void setSemiAxisY(int semiAxisY) {
        this.semiAxisY = semiAxisY;
    }

    @Override
    public int getSurface() {
        int a = this.semiAxisX;
        int b = this.semiAxisY;
        double r = Math.PI*a*b;
        return (int) r;
    }

    @Override
    public int getPerimeter() {
        int a = this.semiAxisX;
        int b = this.semiAxisY;
        double r = Math.PI*(3*(a+b)-Math.sqrt((3*a+b)*(a+3*b)));
        return (int) r;
    }

    @Override
    public void setBoundingBox(int semiAxisX, int semiAxisY) {
        this.length = 2*semiAxisX;
        this.width = 2*semiAxisY;
    }

    @Override
    public void draw(Graphics g, int startX,int startY,int endX,int endY) {
        setSemiAxisX(Math.abs(endX - startX));
        setSemiAxisY(Math.abs(endY - startY));
        int x = Math.min(startX, endX);
        int y = Math.min(startY, endY);
        g.drawOval(x, y, semiAxisX, semiAxisY);
    }

    @Override
    public String toString() {
        return "Ellipse{" + "color=" + c + ", origin=" + "(" + origin.X + ", " + origin.Y + ")" + ", semiAxisX=" + semiAxisX + ", semiAxisY=" + semiAxisY + '}';
    }
}
