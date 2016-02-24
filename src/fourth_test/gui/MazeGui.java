package fourth_test.gui;

//import third_test.maze_cells.PathButtonListener;

import fourth_test.constants.MazeConstants;
import fourth_test.maze_cells.Wall;
import fourth_test.maze_tree.MazeTree;

import javax.swing.*;
import java.awt.*;

/**
 * Created by bender on 30.01.16.
 */
public class MazeGui {
    JFrame mainFrame;
    JPanel mainMazePanel, buttonPanel;
    CellPanel[][] panels;

    public MazeGui(int rows, int cols) {
        mainFrame = new JFrame("Maze");
        mainFrame.setSize(500, 500);
        mainFrame.setResizable(false);
        mainMazePanel = new JPanel(new GridLayout(rows, cols));
        mainMazePanel.setBackground(MazeConstants.WALL_COLOR);
        buttonPanel = new JPanel(new FlowLayout());

        addMazeCells(rows, cols);

        mainFrame.add(mainMazePanel, BorderLayout.CENTER);

        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        mainFrame.pack();
    }

    private void addMazeCells(int rows, int cols) {
        panels = new CellPanel[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                CellPanel element = new CellPanel();
                element.setBackground(MazeConstants.WALL_COLOR);
                panels[row][col] = element;
                element.setPreferredSize(new Dimension(10, 25));
                element.setLayout(new BorderLayout());
                element.setTypeOfCell(MazeConstants.ELSE_TYPE_OF_CELL);
                mainMazePanel.add(element);
                if (row == 0 || col == 0 || row == rows - 1 || col == cols - 1) {
                    element.setUsed(true);
                    element.setLayout(new BorderLayout());
                    element.add(new Wall("*"), BorderLayout.CENTER);
                    element.setTypeOfCell(MazeConstants.ELSE_TYPE_OF_CELL);
                }
            }
        }
    }

    public MazeTree setMaze (MazeTree tree) throws InterruptedException {
        tree.setGui(this);
        tree = tree.createMaze(tree, 50, MazeConstants.UP);
//        tree.printMaze(tree);
        this.fillWalls();
        this.mainMazePanel.updateUI();
        return tree;
    }

    public CellPanel[][] getPanels() {
        return panels;
    }

    public JPanel getMainMazePanel() {
        return mainMazePanel;
    }

    public void fillWalls() {
        int border1 = this.panels.length;
        int border2 = this.panels[0].length;
        for (int i = 0; i<border1; i++) {
            for (int j = 0; j<border2; j++) {
                if (!this.panels[i][j].isUsed()) {
                    this.panels[i][j].setUsed(true);
                    Wall wall = new Wall("");
                    this.panels[i][j].add(wall, BorderLayout.CENTER);
                }
            }
        }
    }

}
