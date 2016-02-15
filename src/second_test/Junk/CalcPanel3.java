package second_test.Junk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcPanel3 extends JPanel {
    private JTextField userInputField;
    private JLabel convertLabel, result;
//    private JTextArea result;
//    private JButton twoB, threeB, eighthB, tenB, sixteenB, copy, convert;
    private JPanel panelButtons, panelTop, panelInput;
//    private String userInput;
    private int baseFrom;
    private int baseTo;

    public CalcPanel3() {

        FromBaseListener fromBaseListener = new FromBaseListener();
        ToBaseListener toBaseListener = new ToBaseListener();
        ActionButtonListener buttonListener = new ActionButtonListener();

        panelTop = new JPanel();
        panelTop.setLayout(new GridLayout(2, 1));
        convertLabel = new JLabel("numbers converting tool");
        convertLabel.setHorizontalAlignment(0);
        userInputField = new JTextField("enter number to convert");
        userInputField.setHorizontalAlignment(0);
        panelTop.add(convertLabel);
        panelTop.add(userInputField);

        panelInput = new JPanel();
        panelInput.setLayout(new GridLayout(1, 2));
        addButtons("copy num", panelInput, buttonListener);
        addButtons("convert", panelInput, buttonListener);

        panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(2, 6));
/*        panelButtons.add(new JLabel("from"));
        addButtons("2", panelButtons, fromBaseListener);
        addButtons("3", panelButtons, fromBaseListener);
        addButtons("8", panelButtons, fromBaseListener);
        addButtons("10", panelButtons, fromBaseListener);
        addButtons("16", panelButtons, fromBaseListener);*/
        panelButtons.add(new JLabel("to"));
        addButtons("2", panelButtons, toBaseListener);
        addButtons("3", panelButtons, toBaseListener);
        addButtons("8", panelButtons, toBaseListener);
        addButtons("10", panelButtons, toBaseListener);
        addButtons("16", panelButtons, toBaseListener);


        result = new JLabel("here you will see the result of conversion");
        result.setHorizontalAlignment(0);

        setLayout(new GridLayout(4, 1));
        add(panelTop);
        add(panelInput);
        add(panelButtons);
        add(result);


    }

    private void addButtons(String name, JPanel panel, ActionListener listener) {
        JButton button = new JButton(name);
        button.setFont(new Font("Courier New", Font.BOLD, 12));
        button.addActionListener(listener);
        panel.add(button);
    }

    private class ToBaseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String baseClick = actionEvent.getActionCommand();
            buttonsToNameChange();
            ((JButton) actionEvent.getSource()).setFont(new Font("Courier New", Font.ITALIC, 12)); /*.setText("\'" + ((JButton) actionEvent.getSource()).getText())*/;
            switch (baseClick) {
                case "2" :
                    baseTo = 2;
                    break;
                case "3" :
                    baseTo = 3;
                    break;
                case "8" :
                    baseTo = 8;
                    break;
                case "10":
                    baseTo = 10;
                    break;
                case "16":
                    baseTo = 16;
            }
//            System.out.println(baseTo);
        }

        private void buttonsToNameChange() {
            ((JButton) panelButtons.getComponent(1)).setFont(new Font("Courier New", Font.BOLD, 12));
            ((JButton) panelButtons.getComponent(2)).setFont(new Font("Courier New", Font.BOLD, 12));
            ((JButton) panelButtons.getComponent(3)).setFont(new Font("Courier New", Font.BOLD, 12));
            ((JButton) panelButtons.getComponent(4)).setFont(new Font("Courier New", Font.BOLD, 12));
            ((JButton) panelButtons.getComponent(5)).setFont(new Font("Courier New", Font.BOLD, 12));
        }
    }

    private class FromBaseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String baseClick = actionEvent.getActionCommand();
            buttonsFromNameChange();
            ((JButton) actionEvent.getSource()).setFont(new Font("Courier New", Font.ITALIC, 12)); /*.setText("\'" + ((JButton) actionEvent.getSource()).getText())*/;
            switch (baseClick) {
                case "2" :
                    baseFrom = 2;
                    break;
                case "3" :
                    baseFrom = 3;
                    break;
                case "8" :
                    baseFrom = 8;
                    break;
                case "10":
                    baseFrom = 10;
                    break;
                case "16":
                    baseFrom = 16;
            }
            System.out.println(baseFrom);
        }

        private void buttonsFromNameChange() {
            ((JButton) panelButtons.getComponent(1)).setFont(new Font("Courier New", Font.BOLD, 12));
            ((JButton) panelButtons.getComponent(2)).setFont(new Font("Courier New", Font.BOLD, 12));
            ((JButton) panelButtons.getComponent(3)).setFont(new Font("Courier New", Font.BOLD, 12));
            ((JButton) panelButtons.getComponent(4)).setFont(new Font("Courier New", Font.BOLD, 12));
            ((JButton) panelButtons.getComponent(5)).setFont(new Font("Courier New", Font.BOLD, 12));
        }
    }

    private class ActionButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String action = actionEvent.getActionCommand();
            if (action.equals("copy num")){

                userInputField.setText("" + (long)Double.parseDouble(CalcPanel1.display.getText()));
            }
            else {
                try {
                    convertNumber();
                }
                catch (NumberFormatException exception){
                    result.setText("Error, probably your number is incorrect");
                }
            }
        }
    }

    private void convertNumber() {
        long userInput = Long.parseLong(userInputField.getText());
            switch (baseTo) {
                case 2:
                    result.setText(Long.toBinaryString(userInput));
                    break;
                case 3:
                    String temp = Long.toString(userInput).startsWith("-") ? "-" + convertToBase3(userInput) : "" + convertToBase3(userInput);
                    result.setText(temp);
                    break;
                case 8:
                    result.setText(Long.toOctalString(userInput));
                    break;
                case 16:
                    result.setText(Long.toHexString(userInput));
                    break;
                default:
                    result.setText("probably your number is an answer");
            }
    }

    private String convertToBase3(long userInput) {
        if (Math.abs(userInput/3) > 0){
            return "" + convertToBase3(Math.abs(userInput/3)) + Math.abs(userInput%3);
        }
        else return "" + Math.abs(userInput%3);
    }

}