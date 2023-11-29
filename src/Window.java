import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Window extends JFrame implements ActionListener {
    final Drawing drawingPanel;

    public Window(String title,int x,int y) {
        setTitle(title);
        setSize(x,y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        drawingPanel = new Drawing();
        add(drawingPanel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);

        // Create buttons
        JButton changeColorButton = new JButton("Change Color");
        JButton rectangleShapeButton = new JButton("Rectangle");
        JButton squareShapeButton = new JButton("Square");
        JButton ellipseShapeButton = new JButton("Ellipse");
        JButton circleShapeButton = new JButton("Circle");

        // Add buttons to a panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(changeColorButton);
        buttonPanel.add(rectangleShapeButton);
        buttonPanel.add(squareShapeButton);
        buttonPanel.add(ellipseShapeButton);
        buttonPanel.add(circleShapeButton);

        // Add the button panel to the frame
        add(buttonPanel, BorderLayout.SOUTH);

        // Register the Window class as an ActionListener for the buttons
        changeColorButton.addActionListener(this);
        rectangleShapeButton.addActionListener(this);
        squareShapeButton.addActionListener(this);
        circleShapeButton.addActionListener(this);
        ellipseShapeButton.addActionListener(this);

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Create a menu
        JMenu fileMenu = new JMenu(("File"));
        JMenu aboutMenu = new JMenu("About");


        // Create our menu items
        JMenuItem authorsMenuItem = new JMenuItem("Authors");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem quitMenuItem = new JMenuItem("Quit");

        // Add the menu items to the menus
        aboutMenu.add(authorsMenuItem);
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(quitMenuItem);

        // Add the menu to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(aboutMenu);

        // Register the Window class as an ActionListener for the menu item
        authorsMenuItem.addActionListener(this);
        newMenuItem.addActionListener(this);
        openMenuItem.addActionListener(this);
        saveMenuItem.addActionListener(this);
        quitMenuItem.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        switch (cmd) {
            case "Change Color":
                // Modify the current Drawing color
                Color newColor = JColorChooser.showDialog(this, "Choose a Color", drawingPanel.getCurrentColor());
                if (newColor != null) {
                    drawingPanel.setCurrentColor(newColor);
                    repaint();
                }
                break;
            case "Rectangle":
                drawingPanel.setCurrentFigure("Rectangle");
                break;
            case "Ellipse":
                drawingPanel.setCurrentFigure("Ellipse");
                break;
            case "Square":
                drawingPanel.setCurrentFigure("Square");
                break;
            case "Circle":
                drawingPanel.setCurrentFigure("Circle");
                break;
            case "Authors":
                // Show information popup with author names
                JOptionPane.showMessageDialog(this, "Authors: Pillot Matthieu", "Paint project", JOptionPane.INFORMATION_MESSAGE);
                break;
            default:
                System.out.println("Button or menu item not handled: " + cmd);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Window window = new Window("Paint",800,600);
        });
    }
}
