package second_test.Junk;

import second_test.PostfixNotation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcPanel2Old extends JPanel {
    private JTextField expressionInput, resultText;
    private JLabel expressionLabel;
    private JButton result;
    private JPanel panel;
    private String inputExpression;

    public CalcPanel2Old() {

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        expressionLabel = new JLabel("expression parsing tool");
        expressionLabel.setHorizontalAlignment(0);
        panel.add(expressionLabel);
        expressionInput = new JTextField();
        expressionInput.setHorizontalAlignment(0);
        panel.add(expressionInput);
        result = new JButton("calculate");
        result.setHorizontalAlignment(0);
        panel.add(result);
        resultText = new JTextField("here you will see the result of calculation");
        resultText.setHorizontalAlignment(0);
        resultText.setEditable(false);
        panel.add(resultText);

        add(panel, BorderLayout.CENTER);

        ActionListener input = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                inputExpression = expressionInput.getText();
//                resultText.setText(CalcPanel1.isInteger(expressionParser(inputExpression)));
                try {
                    PostfixNotation parser = new PostfixNotation(inputExpression);
                    String result = parser.calculateExpression();
                    if (result.equals("0"))
                        resultText.setText("result is in interval {-1 : 1}");
                    else resultText.setText(result);
                }
                catch (Exception exception) {
                    resultText.setText("Something went wrong: " + exception.getLocalizedMessage());                }
            }
        };

        result.addActionListener(input);
    }

    public double expressionParser (String expression) {
        String temp = "";
        double tempResult = 0;
        double result = 0;
        if (expression.startsWith("(")) {
            int index = 1;
            while (expression.charAt(index) != ')') {
                temp += expression.charAt(index);
                index++;
            }
            if (temp.contains("(")) {
                while (index < expression.length() && expression.charAt(index) == ')') {
                    temp += expression.charAt(index);
                    index++;
                }
                index--;
            }

            return index == expression.length()-1 ? expressionParser(temp) : calculate(expression.charAt(index+1), expressionParser(temp), expressionParser(expression.substring(index+2)));
//            tempResult = expressionParser(temp);
//            System.out.println(temp + " " + tempResult);
//            return tempResult;
        }
        else {
            int position = 0;
            while (position < expression.length() - 1) {
//            for (int index = 0; index<expression.length(); index++){
                if (expression.length() != 1 && Character.isDigit(expression.charAt(position)) && (expression.charAt(position+1) == '.')) {
                    position++;
                    continue;
                }
                if (Character.isDigit(expression.charAt(position)) || expression.charAt(position) == '.'){
                    position++;
                }
                else if (expression.length()!=1 & Character.isDigit(expression.charAt(position - 1))) {
                    double leftOperand = Double.valueOf(expression.substring(0, position));
                    char operation = expression.charAt(position);
                    double rigthOperand = expressionParser(expression.substring(position+1));
                    return calculate(operation, leftOperand, rigthOperand);
                }
            }
            return !haveDigit(expression) ? 0 : Double.valueOf(expression);
        }
    }

    private boolean haveDigit(String expression) {
        boolean result = false;
        for (int index = 0; index<expression.length(); index++){
            result = Character.isDigit(expression.charAt(index));
        }
        return result;
    }


    private double calculate(char operation, double leftOperand, double rigthOperand) {
        switch (operation){
            case '+' :
                return leftOperand + rigthOperand;
            case '-' :
                return leftOperand - rigthOperand;
            case '*' :
                return leftOperand * rigthOperand;
            case '/' :
                return leftOperand / rigthOperand;
            default:return leftOperand;
        }
    }

};