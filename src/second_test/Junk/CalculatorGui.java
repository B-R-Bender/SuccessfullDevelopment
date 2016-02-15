package second_test.Junk;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGui extends JFrame implements ActionListener {
    JButton button1 = new JButton("Hey hey!");
    JButton button2 = new JButton("Hey hey!");

    public static void main(String[] args) {

        CalculatorGui calc = new CalculatorGui();
        calc.make();
    }

    private void make() {
        JFrame calcWindow = new JFrame();
        calcWindow.getContentPane().add(button1);
        calcWindow.getContentPane().add(button2);
        button1.addActionListener(this);
        button2.addActionListener(this);
        calcWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calcWindow.setSize(200, 300);
        calcWindow.setResizable(false);
        calcWindow.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            button1.setText("Pressed1!");
            button2.setText("Pressed2!");
    }
}
