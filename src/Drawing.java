import javax.swing.*;
import java.awt.*;
import java.awt.Point;
import java.awt.event.MouseAdapter;
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

        // Dessinez vos figures existantes
        /*for (Figure figure : listFigures) {
            figure.draw(g);
        }*/

        // Dessinez le rectangle en cours si la souris est pressée et déplacée
        if (currentFigure instanceof Rectangle ) {
            g.setColor(currentColor);
            int width = Math.abs(endX - startX);
            int height = Math.abs(endY - startY);
            int x = Math.min(startX, endX);
            int y = Math.min(startY, endY);
            g.setColor(currentColor);
            g.drawRect(x, y, width, height);
        }
        if (currentFigure instanceof Ellipse) {
            g.setColor(currentColor);
            int width = Math.abs(endX - startX);
            int height = Math.abs(endY - startY);
            int x = Math.min(startX, endX);
            int y = Math.min(startY, endY);
            g.drawOval(x, y, width, height);
        }
        if (currentFigure instanceof Square){
            g.setColor(currentColor);
            int width = Math.abs(endX - startX);
            int height = width;
            int x = Math.min(startX, endX);
            int y = Math.min(startY, endY);
            g.setColor(currentColor);
            g.drawRect(x, y, width, height);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        createNewFigure(e.getPoint());
    }

    // Other methods from the MouseListener interface
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
    public void mouseDragged(MouseEvent e) {
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

