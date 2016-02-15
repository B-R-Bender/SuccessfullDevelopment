package second_test.GUI;

import javax.swing.*;
import java.awt.*;

public class CalcFrame extends JFrame {
    public CalcFrame() {
        super("CALC'ZILLA V 1.1");
/*
        CalcPanel1 panel1 = new CalcPanel1();
        CalcPanel2 panel2 = new CalcPanel2();
        CalcPanel3 panel3 = new CalcPanel3();
        add(panel1, BorderLayout.NORTH);
        add(panel2, BorderLayout.CENTER);
        add(panel3, BorderLayout.SOUTH);
*/
        MainPanel calcMainPanel = new MainPanel();
        add(calcMainPanel);
        pack();
    }
}
