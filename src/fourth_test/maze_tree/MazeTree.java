package fourth_test.maze_tree;

import fourth_test.constants.MazeConstants;
import fourth_test.maze_cells.Wall;
import fourth_test.gui.MazeGui;
import fourth_test.maze_cells.Path;

import java.util.Random;

/**
 * Created by bender on 31.01.16.
 */
public class MazeTree {

    MazeTree parentCell;
    MazeTree leftCell;
    MazeTree centralCell;
    MazeTree rightCell;

    int positionX, positionY;

    static MazeGui mazeGui;

    Path cell;
    Wall wall;

    public MazeTree(MazeTree parentCell, MazeTree leftCell, MazeTree centralCell, MazeTree rightCell, int positionX, int positionY) {
        this.parentCell = parentCell;
        this.leftCell = leftCell;
        this.centralCell = centralCell;
        this.rightCell = rightCell;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public MazeTree createMaze (MazeTree enter, int longestPath, String orientation) throws InterruptedException {

        int x = enter.positionX;
        int y = enter.positionY;
        if (longestPath >= 0) {
            Thread.sleep(20);
            MazeTree newCell = new MazeTree(enter, null, null, null, 0, 0);

            x = newCell.positionX = modifyX(orientation, x);
            y = newCell.positionY = modifyY(orientation, y);
//                    условие смежных коридоров defineAdjacentPassages(x, y, MazeConstants.HORIZONTAL_PLUS);
            if (!isPanelUsed(x, y) & defineAdjacentPassages(x, y, orientation)) {
                newCell.cell = new Path(x + " " + y, x, y, newCell);
                setPanelUsed(x, y);
                generateNext(newCell, orientation, longestPath);
            } else {
                newCell = null;
            }
//            mazeGui.getMainMazePanel().repaint();
//            here insert method to check for connections
            connectCells(newCell, orientation, x, y);
            return newCell;
        }
        return null;
    }

    private void connectCells(MazeTree newCell, String orientation, int x, int y) {
        x = modifyX(orientation, x);
        y = modifyY(orientation, y);


    }

    private void generateNext(MazeTree baseCell, String orientation, int longestPath) throws InterruptedException {

        Random random = new Random();
//        boolean generate = random.nextBoolean();
        boolean generateLeft = random.nextBoolean();
//        boolean generateCenter = random.nextBoolean();
        boolean generateRight = random.nextBoolean();
//        boolean generateLeft = true;
//        boolean generateCenter = true;
//        boolean generateRight = true;

        int x = baseCell.positionX;
        int y = baseCell.positionY;

        String left, right;
        left = right = "";

        switch (orientation) {
            case MazeConstants.HORIZONTAL_PLUS:
                left += MazeConstants.UP;
                right += MazeConstants.DOWN;
                break;
            case MazeConstants.HORIZONTAL_MINUS:
                left += MazeConstants.DOWN;
                right += MazeConstants.UP;
                break;
            case MazeConstants.UP:
                left += MazeConstants.HORIZONTAL_MINUS;
                right += MazeConstants.HORIZONTAL_PLUS;
                break;
            case MazeConstants.DOWN:
                left += MazeConstants.HORIZONTAL_PLUS;
                right += MazeConstants.HORIZONTAL_MINUS;
                break;
        }

        if (!generateLeft) {
            createWall(baseCell, orientation, left);
        } else if (!generateRight) {
            createWall(baseCell, orientation, right);
        }

        baseCell.leftCell = createBranch(generateLeft, baseCell, left, longestPath, x, y);
        baseCell.centralCell = createBranch(true, baseCell, orientation, longestPath, x, y);
        baseCell.rightCell = createBranch(generateRight, baseCell, right, longestPath, x, y);
    }

    private MazeTree createBranch(boolean generate, MazeTree baseCell, String branch, int longestPath, int x, int y) throws InterruptedException {
//                    create path if it is possible
        x = modifyX(branch, x);
        y = modifyY(branch, y);
        if (generate & !isPanelUsed(x, y)) {
            return createMaze(baseCell, longestPath - 1, branch);
        }
        return null;
    }

    private void createWall(MazeTree baseCell, String direction, String cell) {
        int x = modifyX(cell, baseCell.positionX);
        int y = modifyY(cell, baseCell.positionY);

        switch (direction) {
            case "horizontal+":
                switch (cell) {
                    case "up":
                        baseCell.leftCell = null;
                        wall = new Wall(x, y);
                        setPanelUsed(x, y);
                        break;
                    case "horizontal+":
                        baseCell.centralCell = null;
                        wall = new Wall(x, y);
                        setPanelUsed(x, y);
                        break;
                    case "down":
                        baseCell.rightCell = null;
                        wall = new Wall(x, y);
                        setPanelUsed(x, y);
                        break;
                }
                break;
            case "horizontal-":
                switch (cell) {
                    case "down":
                        baseCell.leftCell = null;
                        wall = new Wall(x, y);
                        setPanelUsed(x, y);
                        break;
                    case "horizontal-":
                        baseCell.centralCell = null;
                        wall = new Wall(x, y);
                        setPanelUsed(x, y);
                        break;
                    case "up":
                        baseCell.rightCell = null;
                        wall = new Wall(x, y);
                        setPanelUsed(x, y);
                        break;
                }
                break;
            case "up":
                switch (cell) {
                    case "horizontal-":
                        baseCell.leftCell = null;
                        wall = new Wall(x, y);
                        setPanelUsed(x, y);
                        break;
                    case "up":
                        baseCell.centralCell = null;
                        wall = new Wall(x, y);
                        setPanelUsed(x, y);
                        break;
                    case "horizontal+":
                        baseCell.rightCell = null;
                        wall = new Wall(x, y);
                        setPanelUsed(x, y);
                        break;
                }
                break;
            case "down":
                switch (cell) {
                    case "horizontal+":
                        baseCell.leftCell = null;
                        wall = new Wall(x, y);
                        setPanelUsed(x, y);
                        break;
                    case "down":
                        baseCell.centralCell = null;
                        wall = new Wall(x, y);
                        setPanelUsed(x, y);
                        break;
                    case "horizontal-":
                        baseCell.rightCell = null;
                        wall = new Wall(x, y);
                        setPanelUsed(x, y);
                        break;
                }
                break;
        }
    }

    private int modifyX(String orientation, int x) {
        switch (orientation) {
            case MazeConstants.HORIZONTAL_PLUS:
                x++;
                break;
            case MazeConstants.HORIZONTAL_MINUS:
                x--;
                break;
        }
        return x;
    }

    private int modifyY(String orientation, int y) {
        switch (orientation) {
            case MazeConstants.UP:
                y++;
                break;
            case MazeConstants.DOWN:
                y--;
                break;
        }
        return y;
    }

    public String printMaze (MazeTree maze) {
        return maze != null ? "maze cell x = " + maze.positionX
                                        + " y = " + maze.positionY + "\n -->>left " + printMaze(maze.leftCell)
                                        + "\n -->>center " + printMaze(maze.centralCell)
                                        + "\n -->>right " + printMaze(maze.rightCell): "wall";
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public static MazeGui getMazeGui() {
        return mazeGui;
    }

    public MazeTree getParentCell() {
        return parentCell;
    }

    public MazeTree getLeftCell() {
        return leftCell;
    }

    public MazeTree getCentralCell() {
        return centralCell;
    }

    public MazeTree getRightCell() {
        return rightCell;
    }

    private void setPanelUsed(int x, int y) {
        mazeGui.getPanels()[x][y].setUsed(true);
        mazeGui.getPanels()[x][y].repaint();
        mazeGui.getMainMazePanel().repaint();
    }

    private boolean isPanelUsed(int x, int y) {
        return mazeGui.getPanels()[x][y].isUsed();
    }

    private boolean defineAdjacentPassages(int x, int y, String direction) {
        switch (direction) {
            case MazeConstants.HORIZONTAL_PLUS:
                return  !mazeGui.getPanels()[x][y + 1].isUsed()
                        & !mazeGui.getPanels()[x][y - 1].isUsed();
            case MazeConstants.HORIZONTAL_MINUS:
                return  !mazeGui.getPanels()[x][y + 1].isUsed()
                        & !mazeGui.getPanels()[x][y - 1].isUsed();
            case MazeConstants.UP:
                return  !mazeGui.getPanels()[x + 1][y].isUsed()
                        & !mazeGui.getPanels()[x - 1][y].isUsed();
            case MazeConstants.DOWN:
                return  !mazeGui.getPanels()[x + 1][y].isUsed()
                        & !mazeGui.getPanels()[x - 1][y].isUsed();
        }
        return false;
    }

    public void setGui(MazeGui gui) {
        mazeGui = gui;
    }
}
