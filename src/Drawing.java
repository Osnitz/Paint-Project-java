import javax.swing.*;
import java.awt.*;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.util.List;


public class Drawing extends JPanel implements MouseListener {
    private Color currentColor;
    private Figure currentFigure;
    private List<Figure> listFigures;
    private int startX,startY,endX,endY;
    private Figure tempFig;
    public List<Figure> loadedFigures;

    public Drawing() {
        this.setBackground(Color.white);
        this.currentColor = Color.black;
        this.currentFigure = new Rectangle(0, 0, currentColor);
        this.listFigures = new ArrayList<>();
        this.loadedFigures = null;

        // Add mouse click listener to create new listFigure
        this.addMouseListener(this);
    }

    public List<Figure> getListFigures() {
        return listFigures;
    }

    private void createNewFigure(Point clickPoint) {

        //tempFig is used in order to dodge the problem of disappearing of th first figure drawn after  using the clearPanel function or ctrl+z function
        if (tempFig != null){
            currentFigure = tempFig;
            tempFig =null;
        }
        // Maintain all the figures on the drawing panel while we draw a new one
        // clickPoint is the end point of the figure
        if (currentFigure != null) {
            currentFigure.setColor(currentColor);
            currentFigure.setCoordinates(startX, startY, clickPoint.x, clickPoint.y);
            listFigures.add(currentFigure);
            repaint();
        }
        // open the saved figures on request
        if (loadedFigures != null) {
            listFigures.clear();
            listFigures.addAll(loadedFigures);
            loadedFigures = null;
            repaint();
        }

        // Create a new figure of a chosen type
        switch (currentFigure) {
            case Rectangle rectangle -> currentFigure = new Rectangle(startX, startY, currentColor);
            case Ellipse ellipse -> currentFigure = new Ellipse(startX, startY, currentColor);
            case Square square -> currentFigure = new Square(startX, startY, currentColor);
            case Circle circle -> currentFigure = new Circle(startX, startY, currentColor);

                // Default to Rectangle if the type is unknown
            case null, default -> currentFigure = new Rectangle(startX, startY, currentColor);

        }
    }

    public void setCurrentColor(Color color) {
        currentColor = color;
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
// draw all figures each time, so they do not disappear
        for (Figure figure : listFigures) {
            g.setColor(figure.getColor());
            figure.draw(g, figure.getStartX(), figure.getStartY(), figure.getEndX(), figure.getEndY());
        }
        // Drawn current figure
        if (currentFigure != null){
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

    public static void save(List<Figure> list){
        try{
            FileOutputStream fos = new FileOutputStream("SaveFig");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeInt(list.size());
            for(Figure f : list){
                oos.writeObject(f);
            }
            oos.close();
            showMessageDialogSave();
            }
        catch (Exception e){
         System.out.println("Problemos !");
         }
         }


    public static List<Figure> load(String file) {
        List<Figure> loadedFigures = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            int figureCount = ois.readInt();
            for (int i = 0; i < figureCount; i++) {
                Figure loadedFigure = (Figure) ois.readObject();
                loadedFigures.add(loadedFigure);
            }
            System.out.println("Figures Loaded");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Problem !");
        }
        return loadedFigures;
    }

    // Dialog window when we save figures
    private static void showMessageDialogSave() {
        JOptionPane.showMessageDialog(
                null,
                "Figures successfully saved",
                "Save",
                JOptionPane.INFORMATION_MESSAGE
        );
    }


// Go back
    public void ctrlZ() {
        if (!listFigures.isEmpty()) {
            tempFig = listFigures.get(listFigures.size() - 1); // avoid the disappearing of first figure drawn after   pushing ctrl + Z
            listFigures.remove(listFigures.size() - 1);
            currentFigure= null;
            repaint();
        }
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

