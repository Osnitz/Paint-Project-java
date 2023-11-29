import java.awt.*;

class Circle extends Figure {
    protected  int radius;

    public Circle(int px, int py, Color c) {
        super(c, new Point(px, py));
        this.radius = 0;
        this.width = 2*this.radius;
        this.length = this.width;
    }

    public int getRadius() {
        return radius;
    }


    public void setRadius(int r) {
        this.radius = r;
    }


    @Override
    public int getSurface() {
        return (int) (Math.PI*(radius^2));
    }

    @Override
    public int getPerimeter() {
        return (int) (2*Math.PI*radius);
    }

    @Override
    public void setBoundingBox(int r1, int r2) {
        if(r1 != r2){
            System.out.println("Les 2 arguments doivent être les mêmes");
            return;
        }
        this.length = 2*radius;
        this.width = 2*radius;
    }

    @Override
    public void draw(Graphics g, int startX,int startY,int endX,int endY) {
        setRadius(Math.max(Math.abs(endX - startX),Math.abs(endY - startY)));

        // locate the left hand corner
        int x = Math.min(startX, endX);
        int y = Math.min(startY, endY);
        g.drawOval(x, y, radius, radius);
    }

    @Override
    public String toString() {
        return "Circle{" + "color=" + c + ", origin=" + "(" + origin.X + ", " + origin.Y + ")" + ", radius =" + radius + "}";
    }
}
