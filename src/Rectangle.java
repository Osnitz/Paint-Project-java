import java.awt.*;

class Rectangle extends Figure {
    public Rectangle(int px, int py, Color c) {
        super(c, new Point(px, py));
        this.width = 0;
        this.length = 0;
        setBoundingBox(0,0);
    }
    public int getLength(){
        return this.length;
    }
    public int getWidth(){
        return this.width;
    }
    @Override
    public void setBoundingBox(int width, int length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public void draw(Graphics g, int startX,int startY,int endX,int endY) {
        setLength(Math.abs(endX - startX));
        setWidth(Math.abs(endY - startY));

        // locate the left hand corner
        int x = Math.min(startX, endX);
        int y = Math.min(startY, endY);

        g.drawRect(x, y, length, width);
    }

    @Override
    public int getSurface() {
        return this.getLength()*this.getWidth();
    }

    @Override
    public int getPerimeter() {
        return 2*getLength()+2*getWidth();
    }
    @Override
    public String toString() {
        return "Rectangle{" + "color=" + c + ", origin=" + "(" + origin.X + ", " + origin.Y + ")" + ", width=" + width + ", length=" + length + '}';
    }

    public void setLength(int length){
        this.length = length;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public void setCoordinates(int startX, int startY, int endX, int endY) {
        super.setCoordinates(startX, startY, endX, endY);
    }
}
