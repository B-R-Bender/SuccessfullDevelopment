package fourth_test;

import fourth_test.constants.MazeConstants;
import fourth_test.maze_tree.MazeTree;

import java.util.Stack;

/**
 * Created by user_tb on 20.02.2016.
 */
public class MazeDSearch {
    MazeTree tree;
    Stack<MazeTree> trace;
    Stack<MazeTree> temp;

    public MazeDSearch(MazeTree tree) {
        this.tree = tree;
        trace = new Stack<MazeTree>();
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
            trace.push(node);
        } else {
            int newLabel = node.getLabel() + 1;
            setNodeLabel(parentCell, newLabel);
            setNodeLabel(leftCell, newLabel);
            setNodeLabel(centralCell, newLabel);
            setNodeLabel(rightCell, newLabel);
            node.setVisited(true);
            trace.push(node);
//            if (parentCell != null && parentCell.getLabel() > node.getLabel() && parentCell.getLabel() != Integer.MAX_VALUE) {
            dijkstraAlgorithmModified(parentCell);
            clearTrace(trace, node);
            dijkstraAlgorithmModified(leftCell);
            clearTrace(trace, node);
            dijkstraAlgorithmModified(centralCell);
            clearTrace(trace, node);
            dijkstraAlgorithmModified(rightCell);
            clearTrace(trace, node);
        }
    }

    private void clearTrace(Stack<MazeTree> trace, MazeTree node) {
        if (node.getLabel() == 0) {
            while (!trace.empty()) {
                trace.pop().setVisited(false);
            }
            node.setVisited(true);
        }
    }

    private void setNodeLabel(MazeTree cell, int newLabel) {
        if (cell != null /*&& !cell.isVisited()*/ && newLabel < cell.getLabel())
        cell.setLabel(newLabel);
    }

    public void searchPath(MazeTree endNode) {
        int label = endNode.getLabel();
        if (label != 0) {
            trace.push(endNode);
            chooseNext(label, endNode.getParentCell());
            chooseNext(label, endNode.getLeftCell());
            chooseNext(label, endNode.getCentralCell());
            chooseNext(label, endNode.getRightCell());
        } else {
            temp = ((Stack<MazeTree>) trace.clone());
            while (!trace.empty()) {
                trace.pop().getCell().setBackground(MazeConstants.SEARCH_PATH_COLOR);
            }
        }
    }

    private void chooseNext(int label, MazeTree cell) {
        if (cell != null && cell.getLabel() == label - 1) {
            searchPath(cell);
        }
    }

    public void clearTrace () {
//        Stack<MazeTree> temp = trace;
        while (!temp.empty()) {
            temp.pop().getCell().setBackground(MazeConstants.PATH_COLOR);
        }
    }

    public void setDefaultLabel (MazeTree node) {
        node.setVisited(true);
        node.setLabel(Integer.MAX_VALUE);
        if (node.getParentCell() != null && !node.isVisited()) setDefaultLabel(node.getParentCell());
        if (node.getCentralCell() != null && !node.isVisited()) setDefaultLabel(node.getCentralCell());
        if (node.getLeftCell() != null && !node.isVisited()) setDefaultLabel(node.getLeftCell());
        if (node.getRightCell() != null && !node.isVisited()) setDefaultLabel(node.getRightCell());
    }
}
