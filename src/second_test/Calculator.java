package second_test;

import second_test.CalcConstants.Constants;
import second_test.GUI.CalcFrame;

import javax.swing.*;

public class Calculator {
    private static double operand1;
    private static double operand2;
    private static String action;

    public static double getOperand1() {
        return operand1;
    }

    public static void setOperand1(double operand1In) {
        operand1 = operand1In;
    }

    public static double getOperand2() {
        return operand2;
    }

    public static void setOperand2(double operand2In) {
        operand2 = operand2In;
    }

    public static String getAction() {
        return action;
    }

    public static void setAction(String actionIn) {
        action = actionIn;
    }

    public static double multiplication(double operand1, double operand2) {
        return operand1 * operand2;
    }

    public static double division (double operand1, double operand2) {
        if (operand2 == 0){
            System.out.println(Constants.DIV_BY_ZERO_MSG);
            return 0;
        }
        else
            return operand1/operand2;
    }

    public static double addition (double operand1, double operand2) {
        return operand1 + operand2;
    }

    public static double substaction (double operand1, double operand2) {
        return operand1 - operand2;
    }

    public static double involution (double operand1, double operand2) {
        return Math.pow(operand1, operand2);
    }

    public static double squareRoot (double operand1) {
        return Math.sqrt(operand1);
    }

    public static double performAction () {
        switch (action){
            case "*" :
                return multiplication(operand1, operand2);
            case "/" :
                return division(operand1, operand2);
            case "+" :
                return addition(operand1, operand2);
            case "-" :
                return substaction(operand1, operand2);
            case "^" :
                return involution(operand1, operand2);
            case "sqrt" :
                return squareRoot(operand1);
            default:
                throw new RuntimeException("Unknown operation");
         }
    }

    public void work() {
        CalcFrame frame = new CalcFrame();
        frame.setVisible(true);
        frame.setSize(290, 250);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
