package third_test;

import third_test.gui.MazeGui;
import third_test.maze_tree.MazeTree;

/**
 * Created by bender on 30.01.16.
 */
public class Main {
    public static void main(String[] args) {
        try {
            MazeGui gui = new MazeGui(50, 50);
            MazeTree newMaze = new MazeTree(null, null, null, null, 24, 0);
            gui.setMaze(newMaze);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
/*
        try {
            MazeTree newMaze = new MazeTree(null, null, null, null, 4, 0);
            newMaze = newMaze.createMaze(newMaze, 150, MazeConstants.UP);
            newMaze.fillWalls();
            MazeTree.getMazeGui().getMainMazePanel().updateUI();
            System.out.println(newMaze.printMaze(newMaze));
        } catch (Exception e) {
            System.out.println("Unpredicteble exeption" + e.getMessage());
        }
*/
    }
}
