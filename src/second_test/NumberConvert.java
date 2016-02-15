package second_test;

import second_test.CalcConstants.Constants;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by bender on 30.01.16.
 */
public class NumberConvert {
    private int baseFrom;
    private int baseTo;
    private JButton clearButton, previousButton;

    public String setBase (ActionEvent event, String inputNumber) {
        if (baseFrom == 0) {
            JButton pressedButton = (JButton) event.getSource();
            clearButton = pressedButton;
            pressedButton.setBackground(Constants.BUTTON_PRESSED);
            baseFrom = Integer.parseInt(event.getActionCommand());
            return inputNumber;
        } else if (baseTo == 0 /*& baseFrom != 0*/) {
            JButton pressedButton = (JButton) event.getSource();
            previousButton = pressedButton;
            pressedButton.setBackground(Constants.BUTTON_PRESSED);
            baseTo = Integer.parseInt(event.getActionCommand());
            return convertNumberMethod(inputNumber);
        } else {
            clearButton.setBackground(Constants.BUTTON_RELEASED);
            clearButton = previousButton;
            JButton pressedButton = (JButton) event.getSource();
            previousButton = pressedButton;
            pressedButton.setBackground(Constants.BUTTON_PRESSED);
            baseFrom = baseTo;
            baseTo = Integer.parseInt(event.getActionCommand());
            return convertNumberMethod(inputNumber);
        }
    }

    private String convertNumberMethod(String inputNumber) {
        try {
            switch (baseTo) {
                case 2:
                    return Integer.toString(Integer.parseInt(inputNumber, baseFrom), 2);
                case 3:
                    return Integer.toString(Integer.parseInt(inputNumber, baseFrom), 3);
                case 8:
                    return Integer.toString(Integer.parseInt(inputNumber, baseFrom), 8);
                case 10:
                    return Integer.toString(Integer.parseInt(inputNumber, baseFrom), 10);
                case 16:
                    return Integer.toString(Integer.parseInt(inputNumber, baseFrom), 16);
                default:
                    return Constants.ERROR_MESSAGE;
            }
        }
        catch (NumberFormatException ex) {
            baseFrom = baseTo = 0;
            previousButton.setBackground(Constants.BUTTON_RELEASED);
            clearButton.setBackground(Constants.BUTTON_RELEASED);
            return Constants.ERROR_MESSAGE + ex.getMessage();
        }
    }

    public void clear () {
        baseFrom = baseTo = 0;
        if (previousButton != null && clearButton != null) {
            previousButton.setBackground(Constants.BUTTON_RELEASED);
            clearButton.setBackground(Constants.BUTTON_RELEASED);
        }
    }
}
