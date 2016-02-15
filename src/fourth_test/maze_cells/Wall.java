package fourth_test.maze_cells;

import fourth_test.constants.MazeConstants;
import fourth_test.gui.MazeGui;
import fourth_test.maze_tree.MazeTree;

import javax.swing.*;
import java.awt.*;

/**
 * Created by bender on 31.01.16.
 */
public class Wall extends JButton {

    MazeGui mazeGui = MazeTree.getMazeGui();

    public Wall(String name) {
        super(name);
        this.setEnabled(false);
        this.setBorderPainted(false);
        if (name.equals("*")) this.setBackground(MazeConstants.BORDER_COLOR);
        else this.setBackground(MazeConstants.WALL_COLOR);
    }

    public Wall(int x, int y) {
        this.setEnabled(false);
        this.setBorderPainted(false);
        this.setBackground(MazeConstants.WALL_COLOR);
        JPanel tempPanel = mazeGui.getPanels()[x][y];
        tempPanel.add(this, BorderLayout.CENTER);
        tempPanel.setBackground(MazeConstants.WALL_COLOR);
    }
}
