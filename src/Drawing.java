import javax.swing.*;
import java.awt.*;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.util.List;

@SuppressWarnings("FieldMayBeFinal")
public class Drawing extends JPanel implements MouseListener {
    private Color currentColor;
    private Figure currentFigure;
    private List<Figure> listFigures;
    private int startX,startY,endX,endY;

    public Drawing() {
        this.setBackground(Color.white);
        this.currentColor = Color.black;
        this.currentFigure = new Rectangle(0, 0, currentColor);
        this.listFigures = new ArrayList<>();

        // Add mouse click listener to create new listFigure
        this.addMouseListener(this);
    }

    private void createNewFigure(Point clickPoint) {
        Figure newFigure;
        if (currentFigure instanceof Rectangle) {
            newFigure = new Rectangle((int)clickPoint.getX(),(int) clickPoint.getY(), currentColor);
        }
        else if (currentFigure instanceof Ellipse) {
            newFigure = new Ellipse((int)clickPoint.getX(), (int)clickPoint.getY(), currentColor);
        }
        else if (currentFigure instanceof Square){
            newFigure = new Square((int)clickPoint.getX(), (int)clickPoint.getY(), currentColor);
        } else if (currentFigure instanceof Circle) {
            newFigure = new Circle((int)clickPoint.getX(), (int)clickPoint.getY(), currentColor);

        } else {
            // Default to Rectangle if the type is unknown
            newFigure = new Rectangle((int)clickPoint.getX(), (int)clickPoint.getY(), currentColor);
        }

        listFigures.add(newFigure);
        repaint();
    }

    public void setCurrentColor(Color color) {
        this.currentColor = color;
    }

    public Color getCurrentColor(){
        return currentColor;
    }
    public void setCurrentFigure(String figure) {
        if (figure.equals("Rectangle")){
            this.currentFigure = new Rectangle(0,0, currentColor);
        }
        if(figure.equals("Ellipse")){
            this.currentFigure = new Ellipse(0,0, currentColor);
        }
        if(figure.equals("Square")){
            this.currentFigure = new Square(0,0, currentColor);
        }
        if(figure.equals("Circle")){
            this.currentFigure = new Circle(0,0, currentColor);
        }
    }

    private List<Figure> getlistFigures() {
        return listFigures;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw all of 4 figures wanted
        if (currentFigure instanceof Rectangle ) {
            g.setColor(currentColor);
            currentFigure.draw(g,startX,startY,endX,endY);

        }

        if (currentFigure instanceof Square){
            g.setColor(currentColor);
            currentFigure.draw(g,startX,startY,endX,endY);
        }

        if (currentFigure instanceof Ellipse) {
            g.setColor(currentColor);
            currentFigure.draw(g,startX,startY,endX,endY);
        }

        if(currentFigure instanceof Circle){
            g.setColor(currentColor);
            currentFigure.draw(g,startX,startY,endX,endY);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        createNewFigure(e.getPoint());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endX = e.getX();
        endY = e.getY();
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}

