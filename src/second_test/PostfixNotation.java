package second_test;

import second_test.CalcConstants.Constants;

import java.util.Stack;

/**
 * Created by user_tb on 19.01.2016.
 */
public class PostfixNotation {
    String inputString;
    String outputString = "";
    Stack<String> operandStack;
    boolean start = true;

/*
    public static void main(String[] args) {
        PostfixNotation invers = new PostfixNotation("");
        invers.inputString = "  -    32.5+(+10)+(8+2*5)/(1+3*2+(-4)) +  ( -4)/   -         2";
//        invers.inputString = "(4/2)-(43*2-(33+255)/(43-23))";
//        invers.operandStack = new Stack<>();
        invers.convert(invers.inputString);
        System.out.println(invers.outputString);
        System.out.println(invers.calculate(invers.outputString));
    }
*/

    public PostfixNotation(String inputString) {
        this.inputString = inputString;
        this.operandStack = new Stack<>();
    }

    public String calculateExpression () {
        convert(this.inputString);
        String result = calculate(this.outputString);
        return Character.isDigit(result.charAt(0)) || result.startsWith("-") ? result : "Incorrect expression";
    }

    private String calculate(String outputString) {
        Stack<String> result = new Stack<>();
        String[] expression = outputString.split(" ");
        double temp = 0;
        double rightOperand, leftOperand;
        for (String element:
             expression) {
            if (element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/")) {
                switch (element){
                    case "+":
                        rightOperand = Double.parseDouble(result.pop());
                        leftOperand = Double.parseDouble(result.pop());
                        temp = leftOperand + rightOperand;
                        result.push(temp + "");
                        break;
                    case "-":
                        rightOperand = Double.parseDouble(result.pop());
                        leftOperand = Double.parseDouble(result.pop());
                        temp = leftOperand - rightOperand;
                        result.push(temp + "");
                        break;
                    case "*":
                        rightOperand = Double.parseDouble(result.pop());
                        leftOperand = Double.parseDouble(result.pop());
                        temp = leftOperand * rightOperand;
                        result.push(temp + "");
                        break;
                    case "/":
                        rightOperand = Double.parseDouble(result.pop());
                        if (rightOperand == 0) {
                            throw new ArithmeticException(Constants.DIV_BY_ZERO_MSG);
                        }
                        leftOperand = Double.parseDouble(result.pop());
                        temp = leftOperand / rightOperand;
                        result.push(temp + "");
                        break;
                }
            } else {
                result.push(element);
            }
        }
        return result.peek();
    }

    public String convert(String inputString) {
        char inputElement;
        for (int index = 0; index<inputString.length(); index++){
            inputElement = inputString.charAt(index);
            if (index != inputString.length()-1 && (Character.isDigit(inputElement)
                                                & Character.isDigit(inputString.charAt(index+1)))) {
                outputString += Character.toString(inputElement);
            }
            else if ((inputElement == '-' || inputElement == '+') && determineUnary(inputString.substring(0, index))){
                outputString += Character.toString(inputElement);
            }
            else if (index != inputString.length()-1 && Character.isDigit(inputElement)
                    & (inputString.charAt(index+1) == '.' || inputString.charAt(index+1) == ',')) {
                outputString += Character.toString(inputElement) + ".";
                index++;
            }
            else if (Character.isDigit(inputElement)){
                outputString += Character.toString(inputElement) + " ";
            }
            else { putInStack(inputElement); }
        }
        while (!operandStack.isEmpty()){
            outputString += operandStack.pop();
        }
        return outputString;
    }

    private boolean determineUnary(String substring) {
        if (substring.length() == 1)
            return true;
        else {
            for (int count = substring.length() - 1; count >= 0; count--) {
                if (Character.isDigit(substring.charAt(count)) || substring.charAt(count) == ')')
                    return false;
                else if (substring.charAt(count) == ' ');
//                NOP
                else break;
            }
            return true;
        }
    }

    private void putInStack(char inputElement) {
        switch (inputElement) {
            case '(':
                operandStack.push("( ");
                break;
            case ')':
                while (!operandStack.isEmpty() && !operandStack.peek().equals("( ")) {
                    outputString += operandStack.pop();
//                    operandStack.pop();
                }
                operandStack.pop();
                break;
            case '*':
                if (start){
                    operandStack.push("* ");
                    start = false;
                    break;
                }
                while (!operandStack.isEmpty() && compare('*', operandStack.peek())){
                    outputString += operandStack.pop();
                }
                operandStack.push("* ");
                break;
            case '/':
                if (start){
                    operandStack.push("/ ");
                    start = false;
                    break;
                }
                while (!operandStack.isEmpty() && compare('/', operandStack.peek())){
                    outputString += operandStack.pop();
                }
                operandStack.push("/ ");
                break;
            case '+':
                if (start){
                    operandStack.push("+ ");
                    start = false;
                    break;
                }
                while (!operandStack.isEmpty() && compare('+', operandStack.peek())){
                    outputString += operandStack.pop();
                }
                operandStack.push("+ ");
                break;
            case '-':
                if (start){
                    operandStack.push("- ");
                    start = false;
                    break;
                }
                while (!operandStack.isEmpty() && compare('-', operandStack.peek())){
                    outputString += operandStack.pop();
                }
                operandStack.push("- ");
                break;
            case ' ':
                break;
            default:
                throw new NumberFormatException("Operand is invalid");
//                решил не заморачиватся с созданием нового класса исключений, и решил выбрасывать такое )
        }
    }

    private boolean compare(char c, String peek) {
        switch (c){
            case '-':
                return !peek.equals("( ");
            case '+':
                return !peek.equals("( ");
            case '*':
                return peek.equals("* ") || peek.equals("/ ");
            case '/':
                return peek.equals("* ") || peek.equals("/ ");
            default: return false;
        }
    }
}