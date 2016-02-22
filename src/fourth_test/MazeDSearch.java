package fourth_test;

import fourth_test.maze_tree.MazeTree;

/**
 * Created by user_tb on 20.02.2016.
 */
public class MazeDSearch {
    MazeTree tree;

    public MazeDSearch(MazeTree tree) {
        this.tree = tree;
        tree.setLabel(0);
        dijkstraAlgorithmModified(tree);
    }

    private void dijkstraAlgorithmModified (MazeTree node) {
        if (node == null || node.isVisited()) {
            return;
        }
        MazeTree parentCell = node.getParentCell();
        MazeTree leftCell = node.getLeftCell();
        MazeTree centralCell = node.getCentralCell();
        MazeTree rightCell = node.getRightCell();
        if ((parentCell == null || parentCell.isVisited())
                && (leftCell == null || leftCell.isVisited())
                && (centralCell == null || centralCell.isVisited())
                && (rightCell == null || rightCell.isVisited())) {
            node.setVisited(true);
        } else {
            int newLabel = node.getLabel() + 1;
            setNodeLabel(parentCell, newLabel);
            setNodeLabel(leftCell, newLabel);
            setNodeLabel(centralCell, newLabel);
            setNodeLabel(rightCell, newLabel);
            node.setVisited(true);
            if (parentCell != null && parentCell.getLabel() > node.getLabel() && parentCell.getLabel() != Integer.MAX_VALUE) {
                dijkstraAlgorithmModified(parentCell);
            }
            dijkstraAlgorithmModified(leftCell);
            dijkstraAlgorithmModified(centralCell);
            dijkstraAlgorithmModified(rightCell);
        }
    }

    private void setNodeLabel(MazeTree cell, int newLabel) {
        if (cell != null /*&& !cell.isVisited()*/ && newLabel < cell.getLabel())
        cell.setLabel(newLabel);
    }
}
