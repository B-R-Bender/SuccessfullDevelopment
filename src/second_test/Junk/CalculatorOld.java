package second_test.Junk;

import second_test.GUI.CalcFrame;

import javax.swing.*;

public class CalculatorOld {
    private static double operand1;
    private static double operand2;
    private static String action;
    private static String prevAction;

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
        prevAction = prevAction == null? actionIn : action;
        action = actionIn;
    }

    public static double multiplication(double operand1, double operand2) {
        return operand1*operand2;
    }

    public static double division (double operand1, double operand2) {
        if (operand2 == 0){
            System.out.println("Division by zero, achievement unlock!!! Congrats!");
            return 0;
        }
        else
            return operand1/operand2;
    }

    public static double addition (double operand1, double operand2) {
        return operand1+operand2;
    }

    public static double substaction (double operand1, double operand2) {
        return operand1-operand2;
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
            default: return 0;
         }
    }

    public static void work() {
        CalcFrame frame = new CalcFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static String getPrevAction() {
        return prevAction;
    }
}
