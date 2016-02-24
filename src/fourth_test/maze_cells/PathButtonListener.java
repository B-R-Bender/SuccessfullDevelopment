package fourth_test.maze_cells;

import fourth_test.MazeDSearch;
import fourth_test.MazeSearch;
import fourth_test.constants.MazeConstants;
import fourth_test.gui.MazeGui;
import fourth_test.maze_tree.MazeTree;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bender on 05.02.16.
 */
public class PathButtonListener implements ActionListener {

    private static MazeTree tree;
    MazeDSearch search;
    private static int count;

    @Override
    public void actionPerformed(ActionEvent e) {
        Path temp = (Path)e.getSource();
        temp.setBackground(Color.ORANGE);
        if (search == null) {
            search = new MazeDSearch(temp.getAssociatedMazeTreeCell());
            search.clearFoundPath();
//            set end maze cell and calculate path
        } else {
            search.searchPath(temp.getAssociatedMazeTreeCell());
            tree.setDefaultLabel();
            tree.setDefaultVisited();
            search = null;
        }
    }

    public static void setTree(MazeTree tree) {
        PathButtonListener.tree = tree;
    }

}

