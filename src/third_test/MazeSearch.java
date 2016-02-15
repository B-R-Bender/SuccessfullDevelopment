package third_test;

import third_test.constants.MazeConstants;
import third_test.maze_tree.MazeTree;

import java.util.Stack;

/**
 * Created by user_tb on 04.02.2016.
 */
public class MazeSearch <T extends MazeTree> {

    T pathStart;
    T pathEnd;
    boolean found;
    Stack <T> path;
    Stack <T> pathCopy = new Stack<>();

    public MazeSearch(T pathStart, T pathEnd) {
        this.pathStart = pathStart;
        this.pathEnd = pathEnd;
        path = new Stack<>();
    }

    public boolean searchPath (T step, T previousStep) {
        path.push(step);
//        if path end was found
        if (found) {
            return true;
        }
        if (path.peek() == pathEnd) {
//            add method to draw path in GUI
            pathCopy.addAll(path);
            drawPath(path);
            found = true;
            return found;
        }
//        if start cell is dead end seach from the top
        if (step.getLeftCell() == null & step.getCentralCell() == null
                & step.getRightCell() == null & pathStart == step) {
            searchPath((T) step.getParentCell(), step);
        } else {
//            check all cell's brances
            boolean left, center, right;
            if (step.getLeftCell() != null & step.getLeftCell() != previousStep) {
                left = searchPath((T) step.getLeftCell(), step);
            } else { left = false; }
            if (step.getCentralCell() != null & step.getCentralCell() != previousStep) {
                center = searchPath((T) step.getCentralCell(), step);
            } else { center = false; }
            if (step.getRightCell() != null & step.getRightCell() != previousStep) {
                right = searchPath((T) step.getRightCell(), step);
            } else { right = false; }
            if (step.getParentCell() != null & step.getParentCell() != previousStep) searchPath((T) step.getParentCell(), step);
//        if start cell is dead end pop it from result stack
            if (!left & !center & !right & !path.isEmpty()) {
                path.pop();
                found = false;
            }
            else found = true;
        }
        return found;
    }

    private void drawPath(Stack<T> path) {
        int x, y;
        while (!path.empty()) {
            x = path.peek().getPositionX();
            y = path.peek().getPositionY();
            MazeTree.getMazeGui().getPanels()[x][y].getComponent(0).setBackground(MazeConstants.SEARCH_PATH_COLOR);
            path.pop();
        }
    }

    public void pathDrawBack() {
        int x, y;
        found = false;
        while (!pathCopy.empty()) {
            x = pathCopy.peek().getPositionX();
            y = pathCopy.peek().getPositionY();
            MazeTree.getMazeGui().getPanels()[x][y].getComponent(0).setBackground(MazeConstants.PATH_COLOR);
            pathCopy.pop();
        }
    }

    public T getPathStart() {
        return pathStart;
    }

    public void setPathStart(T pathStart) {
        this.pathStart = pathStart;
    }

    public T getPathEnd() {
        return pathEnd;
    }

    public void setPathEnd(T pathEnd) {
        this.pathEnd = pathEnd;
    }
}
