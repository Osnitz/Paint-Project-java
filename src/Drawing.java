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
    private final List<Figure> listFigures;
    private int startX,startY,endX,endY;
    private Figure tempFig;

    public Drawing() {
        this.setBackground(Color.white);
        this.currentColor = Color.black;
        this.currentFigure = new Rectangle(0, 0, currentColor);
        this.listFigures = new ArrayList<>();

        // Add mouse click listener to create new listFigure
        this.addMouseListener(this);
    }

    private void createNewFigure(Point clickPoint) {

        //tempFig is used in order to dodge the problem of disappearing of th first figure drawn after  using the clearPanel function
        if (tempFig != null){
            currentFigure = tempFig;
            tempFig =null;
        }
        // Maintain all the figures on the drawing panel while we draw a new one
        // clickPoint is the end point of the figure
        if (currentFigure != null) {
            currentFigure.setCoordinates(startX, startY, clickPoint.x, clickPoint.y);
            listFigures.add(currentFigure);
            repaint();
        }

        // Create a new figure of a chosen type
        switch (currentFigure) {
            case Rectangle rectangle -> currentFigure = new Rectangle(startX, startY, currentColor);
            case Ellipse ellipse -> currentFigure = new Ellipse(startX, startY, currentColor);
            case Square square -> currentFigure = new Square(startX, startY, currentColor);
            case Circle circle -> currentFigure = new Circle(startX, startY, currentColor);
            case null, default ->
                // Default to Rectangle if the type is unknown
                    currentFigure = new Rectangle(startX, startY, currentColor);
        }
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Figure figure : listFigures) {
            g.setColor(figure.getColor());
            figure.draw(g, figure.getStartX(), figure.getStartY(), figure.getEndX(), figure.getEndY());
        }

        // Draw all of 4 figures wanted
        if (currentFigure != null) {
            g.setColor(currentColor);
            currentFigure.draw(g,startX,startY,endX,endY);
        }
    }

    public void clearDrawingPanel() {
        listFigures.clear();
        tempFig = currentFigure;
        currentFigure = null;
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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
        createNewFigure(e.getPoint());
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}

