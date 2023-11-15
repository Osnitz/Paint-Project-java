public class Point {
    public int X;
    public int Y;
    public Point(){
        this.X = 0;
        this.Y = 0;
    }

    @Override
    public String toString() {
        return ("("+ X + " ; "+ Y+")");
    }

    public int getX(){
        return X;
    }

    public int getY() {
        return Y;
    }

    public void setX(int x){
        X = x;
    }

    public void setY(int y) {
        Y = y;
    }

    public static void main (String[] args){
        Point a = new Point();
        String stringA = a.toString();
        System.out.println("coordonées de a :" +stringA);
        a.setX(2);
        a.setY(3);
        stringA = a.toString();
        System.out.println("coordonées de a :" + stringA);
    }
}
