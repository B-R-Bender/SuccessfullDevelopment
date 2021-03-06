package third_test.maze_cells;

import third_test.MazeSearch;
import third_test.maze_tree.MazeTree;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bender on 05.02.16.
 */
class PathButtonListener implements ActionListener {

    private static MazeSearch<MazeTree> search = new MazeSearch<>(null, null);
    private static int count;

    @Override
    public void actionPerformed(ActionEvent e) {
        Path temp = (Path)e.getSource();
        temp.setBackground(Color.ORANGE);
//        skip 1 & 2 action, then use every 2 times button pressed
//        erase previous shown path, create new instance for path search
        if (count >= 2 & count % 2 == 0) {
            search.pathDrawBack();
            search = new MazeSearch<>(null, null);
        }
//        set start maze cell
        if (search.getPathStart() == null) {
            search.setPathStart(temp.associatedMazeTreeCell);
            count++;
//            set end maze cell and calculate path
        } else {
            search.setPathEnd(temp.associatedMazeTreeCell);
            search.searchPath(search.getPathStart(), null);
            MazeTree.getMazeGui().getMainMazePanel().updateUI();
            count++;
        }
    }
}

