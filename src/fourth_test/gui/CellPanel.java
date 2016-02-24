package fourth_test.gui;

import fourth_test.constants.MazeConstants;

import javax.swing.*;

/**
 * Created by user_tb on 02.02.2016.
 */
public class CellPanel extends JPanel {
    boolean used;
    boolean typeOfCell;

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public boolean isPath() {
        return typeOfCell;
    }

    public void setTypeOfCell(boolean typeOfCell) {
        this.typeOfCell = typeOfCell;
    }
}
