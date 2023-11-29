import javax.swing.*;
import java.awt.*;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.util.List;

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
        } else if (currentFigure instanceof Ellipse) {
            newFigure = new Ellipse((int)clickPoint.getX(), (int)clickPoint.getY(), currentColor);
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

    public List<Figure> getlistFigures() {
        return listFigures;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw all figures in the list
        for (Figure figure : listFigures) {
            figure.draw(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        createNewFigure(e.getPoint());
    }

    // Other methods from the MouseListener interface
    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}

