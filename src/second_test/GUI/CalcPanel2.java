package second_test.GUI;

import second_test.PostfixNotation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EmptyStackException;

public class CalcPanel2 extends JPanel {
    private JTextField expressionInput, resultText;
    private JLabel expressionLabel;
    private JButton result;
    private JPanel panel;
    private String inputExpression;

    public CalcPanel2() {

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
        resultText.setPreferredSize(new Dimension(290, 20));
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
                    resultText.setText("integer result is: " + result);
                }
                catch (EmptyStackException exception) {
                    resultText.setText("Something went wrong: mismatch in brackets");
                }
                catch (Exception exception) {
                    resultText.setText("Something went wrong: " + exception.getLocalizedMessage() + exception.getClass());
                }
            }
        };
        result.addActionListener(input);
    }
};