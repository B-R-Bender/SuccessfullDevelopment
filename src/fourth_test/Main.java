package fourth_test;

import fourth_test.gui.MazeGui;
import fourth_test.maze_cells.PathButtonListener;
import fourth_test.maze_tree.MazeTree;

import java.util.Scanner;

/**
 * Created by bender on 30.01.16.
 */
public class Main {
    public static void main(String[] args) {
        try {
            MazeGui gui = new MazeGui(50, 50);
            MazeTree newMaze = new MazeTree(null, null, null, null, 4, 0);
            newMaze = gui.setMaze(newMaze);
            PathButtonListener.setTree(newMaze);
            System.out.println("stop1");
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
