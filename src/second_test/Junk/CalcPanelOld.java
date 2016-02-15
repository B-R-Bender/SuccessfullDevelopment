package second_test.Junk;

import second_test.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcPanelOld extends JPanel {
    private JTextField display;
    private JPanel panel;
    private String userInput = "0";
    private boolean beginning = true;

    public CalcPanelOld() {
        setLayout(new BorderLayout());

        display = new JTextField(userInput);
        display.setEnabled(false);
        display.setHorizontalAlignment(0);
        add(display, BorderLayout.NORTH);

        ActionListener input = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setInput(actionEvent.getActionCommand());
            }
        };

        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setAction(actionEvent.getActionCommand());
            }
        };

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4));

        addButton("7", input);
        addButton("8", input);
        addButton("9", input);
        addButton("+", action);

        addButton("4", input);
        addButton("5", input);
        addButton("6", input);
        addButton("-", action);

        addButton("1", input);
        addButton("2", input);
        addButton("3", input);
        addButton("*", action);

        addButton("0", input);
        addButton("sqrt", action);
        addButton("^", action);
        addButton("/", action);

        addButton("+/-", input);
        addButton(".", input);
        addButton("=", action);
        addButton("c", input);

        add(panel, BorderLayout.CENTER);
    }

    private void setAction(String actionCommand) {
        if (actionCommand.equals("sqrt")) {
            Calculator.setAction("sqrt");
            Calculator.setOperand1(Double.parseDouble(display.getText()));
            display.setText(isInteger(Calculator.performAction()));
            userInput = "0";
            beginning = false;
        }
        else if (actionCommand.equals("=")) {
            if (beginning){
                display.setText("0");
            }
            else {
                Calculator.setOperand2(Double.parseDouble(userInput));
                double temp = Calculator.performAction();
                display.setText(isInteger(temp));
                Calculator.setOperand1(temp);
//                userInput = "0";
                beginning = false;
            }
        }
        else {
            if (beginning) {
                Calculator.setOperand1(Double.parseDouble(display.getText()));
                Calculator.setAction(actionCommand);
                userInput = "0";
                display.setText(userInput);
                beginning = false;
            }
            else {
                double temp1 = Double.parseDouble(userInput);
                Calculator.setOperand2(temp1);
                double temp2 = Calculator.performAction();
                display.setText(isInteger(temp2));
                Calculator.setOperand1(temp2);
                userInput = "0";
                Calculator.setAction(actionCommand);
            }
        }
/*
        if (actionCommand.equals("=")) {
            Calculator.setOperand2(Double.parseDouble(userInput));
            display.setText(""+Calculator.performAction(Calculator.getAction()));
            userInput = "0";
        }
        else if (actionCommand.equals("sqrt")){
            Calculator.setOperand1(Double.parseDouble(userInput));
            display.setText("" + Calculator.performAction("sqrt"));
        }
        else {
            Calculator.setOperand1(Double.parseDouble(userInput));
            Calculator.setAction(actionCommand);
            userInput = "0";
            display.setText(userInput);

        }
*/
    }

    private String isInteger(double result) {
        return result % 1 == 0 ? "" + (int)result : "" + result;
    }

    private void setInput(String actionCommand) {
        if (actionCommand.equals("+/-")){
            userInput = userInput.charAt(0) != '-' ? "-" + userInput : userInput.substring(1);
            display.setText(userInput);
        }
        else if (actionCommand.equals("c")){
            Calculator.setOperand1(0);
            Calculator.setOperand2(0);
            Calculator.setAction(null);
            userInput = "0";
            display.setText(userInput);
            beginning = true;
        }
        else {
            userInput = userInput.startsWith("0") ? actionCommand : userInput + actionCommand;
            display.setText(userInput);
        }

    }

    private void addButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        panel.add(button);
    }

};