import java.awt.*;
class Square extends Figure {
    private int sideLenght;
    public Square(int px, int py, Color c) {
        super(c, new Point(px, py));
        this.width = 0;
        this.length = 0;
        this.sideLenght = 0;
        setBoundingBox(0,0);
    }
    public int getLength(){
        return this.length;
    }
    public int getWidth(){
        return this.width;
    }

    public int getSideLenght(){
        return sideLenght;
    }
    @Override
    public void setBoundingBox(int width, int length) {
        if(width != length){
            System.out.println("Les 2 arguments doivent être les mêmes");
            return;
        }
        this.width = width;
        this.length = width;
    }

    @Override
    public void draw(Graphics g, int startX,int startY,int endX,int endY) {
        setSideLenght(Math.max(Math.abs(endX - startX),Math.abs(endY - startY)));

        // locate the left hand corner
        int x = Math.min(startX, endX);
        int y = Math.min(startY, endY);

        g.drawRect(x, y, getSideLenght(), getSideLenght());
    }

    @Override
    public int getSurface() {
        return sideLenght^2;
    }

    @Override
    public int getPerimeter() {
        return 4*sideLenght;
    }
    @Override
    public String toString() {
        return "Rectangle{" + "color=" + c + ", origin=" + "(" + origin.X + ", " + origin.Y + ")" + ", width=" + width + ", length=" + length + '}';
    }
    public void setSideLenght(int s){
        this.sideLenght = s;
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

