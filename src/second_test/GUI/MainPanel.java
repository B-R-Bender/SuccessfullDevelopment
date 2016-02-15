package second_test.GUI;

import second_test.Calculator;
import second_test.CalcConstants.Constants;
import second_test.NumberConvert;
import second_test.PostfixNotation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EmptyStackException;

/**
 * Created by bender on 29.01.16.
 */
public class MainPanel extends JPanel {
    static JTextField display;
    private JPanel mainCalcButtonsPanel, convertingPanel;
    private String userInput = "0";
    private String prevAction = "=";
    private JLabel convertLabel;
    private NumberConvert convert = new NumberConvert();

    public MainPanel() {
        setLayout(new BorderLayout());

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

        ActionListener convert = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                convertNumber(actionEvent);
            }
        };

        display = new JTextField(userInput);
        display.setEnabled(true);
        display.setHorizontalAlignment(SwingConstants.CENTER);
        display.setFont(Constants.DISPLAY_FONT);
        add(display, BorderLayout.NORTH);

        mainCalcButtonsPanel = new JPanel();
//        mainCalcButtonsPanel.setLayout(new GridLayout(5, 4));
        mainCalcButtonsPanel.setLayout(new FlowLayout());

        addMainButton("7", input);
        addMainButton("8", input);
        addMainButton("9", input);
        addMainButton("+", action);

        addMainButton("4", input);
        addMainButton("5", input);
        addMainButton("6", input);
        addMainButton("-", action);

        addMainButton("1", input);
        addMainButton("2", input);
        addMainButton("3", input);
        addMainButton("*", action);

        addMainButton("0", input);
        addMainButton("sqrt", action);
        addMainButton("^", action);
        addMainButton("/", action);

        addMainButton("+/-", input);
        addMainButton(".", input);
        addMainButton("=", action);
        addMainButton("c", input);
        convertLabel = new JLabel(Constants.CONVERT_LABEL_TEXT);
        mainCalcButtonsPanel.add(convertLabel);

        add(mainCalcButtonsPanel, BorderLayout.CENTER);

        convertingPanel = new JPanel();

        addConvertingButtons("2", convert);
        addConvertingButtons("3", convert);
        addConvertingButtons("8", convert);
        addConvertingButtons("10", convert);
        addConvertingButtons("16", convert);

        add(convertingPanel, BorderLayout.SOUTH);
    }

    private void convertNumber(ActionEvent actionEvent) {
        display.setText(convert.setBase(actionEvent, display.getText()));
    }

    private void setAction(String actionCommand) {
            if (actionCommand.equals("sqrt")) {
                Calculator.setAction("sqrt");
                Calculator.setOperand1(Double.parseDouble(display.getText()));
                display.setText(isInteger(Calculator.performAction()));
                userInput = display.getText();
            } else if (actionCommand.equals("=")) {
                if (!prevAction.equals("=")) {
                    Calculator.setOperand2(Double.parseDouble(display.getText()));
                    display.setText(isInteger(Calculator.performAction()));
                    prevAction = actionCommand;
                    setNull();
                }
                else if (!isNumber(display.getText())) {
                    try {
                        PostfixNotation parser = new PostfixNotation(display.getText());
                        String result = parser.calculateExpression();
                        display.setText(result);
                    }
                    catch (EmptyStackException exception) {
                        display.setText("Something went wrong: mismatch in brackets");
                    }
                    catch (Exception exception) {
                        display.setText("Something went wrong: " + exception.getMessage());
                    }

                }
            } else {
                Calculator.setOperand1(Double.parseDouble(display.getText()));
                Calculator.setAction(actionCommand);
                userInput = "0";
                display.setText(userInput);
                prevAction = actionCommand;
            }
    }

    private boolean isNumber(String input) {
        try {
            Double.parseDouble(input);
        }
        catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    private void setNull() {
        Calculator.setOperand1(0);
        Calculator.setOperand2(0);
        userInput = "0";
    }

    public static String isInteger(double result) {
        return result % 1 == 0 ? "" + (int)result : "" + result;
    }

    private void setInput(String actionCommand) {
        if (actionCommand.equals(".")){
            userInput = userInput.isEmpty() ? userInput.concat("0.") : userInput;
            if (userInput.isEmpty() || userInput.equals("0")){
                userInput += ".";
                display.setText(userInput);
            }
            else {
                userInput = userInput.contains(".") ? userInput.concat("") : userInput.concat(".");
                display.setText(userInput);
            }
        }
        else if (actionCommand.equals("+/-")) {
            userInput = display.getText();
            userInput = userInput.charAt(0) != '-' ? "-" + userInput : userInput.substring(1);
            display.setText(userInput);

        } else if (actionCommand.equals("c")) {
            Calculator.setOperand1(0);
            Calculator.setOperand2(0);
            Calculator.setAction(null);
            userInput = "0";
            convert.clear();
            display.setText(userInput);

        } else {
            userInput = userInput.equals("0") ? actionCommand : userInput + actionCommand;
            display.setText(userInput);

        }
    }

    private void addMainButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.setPreferredSize(Constants.MAIN_BUTTONS_SIZE);
        button.addActionListener(listener);
        mainCalcButtonsPanel.add(button);
    }

    private void addConvertingButtons(String name, ActionListener listener) {
        JButton button = new JButton(name);
        button.addActionListener(listener);
        button.setPreferredSize(Constants.CONVERTING_BUTTONS_SIZE);
        convertingPanel.add(button);
    }
}
