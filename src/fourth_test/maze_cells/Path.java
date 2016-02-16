package fourth_test.maze_cells;

import fourth_test.constants.MazeConstants;
import fourth_test.maze_tree.MazeTree;
import fourth_test.gui.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by bender on 31.01.16.
 */
public class Path extends JButton {

    static PathButtonListener listener = new PathButtonListener();
    MazeGui mazeGui = MazeTree.getMazeGui();
    MazeTree associatedMazeTreeCell;

    public Path(String name) {
        super(name);
    }

    public Path(String name, int x, int y, MazeTree treeCell) {
//        super(name);
        associatedMazeTreeCell = treeCell;
        JPanel tempPanel = mazeGui.getPanels()[x][y];
//        tempPanel.setLayout(new BorderLayout());
        tempPanel.add(this, BorderLayout.CENTER);
        this.setBackground(Color.CYAN);
        tempPanel.setBackground(MazeConstants.PATH_COLOR);
        this.addActionListener(listener);
    }

    public MazeTree getAssociatedMazeTreeCell() {
        return associatedMazeTreeCell;
    }
}
