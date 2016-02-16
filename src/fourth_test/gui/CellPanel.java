package fourth_test.gui;

import fourth_test.constants.MazeConstants;

import javax.swing.*;

/**
 * Created by user_tb on 02.02.2016.
 */
public class CellPanel extends JPanel {
    boolean used;
    String typeOfCell;

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
//        this.setLayout(new BorderLayout());
//        this.setBackground(Color.CYAN);
    }

    public String getTypeOfCell() {
        return typeOfCell;
    }

    public void setTypeOfCell(String typeOfCell) {
        this.typeOfCell += typeOfCell;
    }
}
