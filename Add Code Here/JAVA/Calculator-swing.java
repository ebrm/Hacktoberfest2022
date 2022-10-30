import javax.swing.*;
import java.awt.event.*;

class Calculator implements ActionListener {
    JFrame			frame;
    JTextField		textField;
    JButton[]		buttonDigits;
    JButton			buttonAdd, buttonSub, buttonMul, buttonDiv, buttonMod;
    JButton			buttonResult, buttonClear, buttonDelete;
    JButton			buttonDecimalPt, buttonSign;

    enum Operator {
        ADD, SUB, MUL, DIV, MOD
    }

    static double		op1, op2, result;
    static Operator		operator;


    private void setBounds() {
        for (int i = 0; i < 3; ++i) {
            buttonDigits[7+i].setBounds(40+70*i, 100, 50, 40);	// Buttons 7 to 9
            buttonDigits[4+i].setBounds(40+70*i, 170, 50, 40);	// Buttons 4 to 6
            buttonDigits[1+i].setBounds(40+70*i, 240, 50, 40);	// Buttons 1 to 3
        }
        buttonDigits[0].setBounds(110, 310, 50, 40);
        buttonDiv.setBounds(250, 100, 50, 40);
        buttonMul.setBounds(250, 170, 50, 40);
        buttonSub.setBounds(250, 240, 50, 40);
        buttonAdd.setBounds(250, 310, 50, 40);
        buttonSign.setBounds(40, 310, 50, 40);
        buttonDecimalPt.setBounds(180, 310, 50, 40);

        buttonClear.setBounds(40, 380, 50, 40);
        buttonResult.setBounds(110, 380, 50, 40);
        buttonDelete.setBounds(180, 380, 50, 40);
        buttonMod.setBounds(250, 380, 50, 40);
    }


    private void initButtons() {
        buttonDigits = new JButton[10];
        for (int i = 0; i < 10; ++i)
            buttonDigits[i] = new JButton(Integer.toString(i));
        buttonAdd = new JButton("+");
        buttonSub = new JButton("-");
        buttonMul = new JButton("x");
        buttonDiv = new JButton("/");
        buttonMod = new JButton("%");
        buttonResult = new JButton("=");
        buttonClear = new JButton("C");
        buttonDelete = new JButton("D");
        buttonDecimalPt = new JButton(".");
        buttonSign = new JButton("+/-");

        setBounds();

        for (int i = 0; i < 10; ++i)
            buttonDigits[i].addActionListener(this);
        buttonAdd.addActionListener(this);
        buttonSub.addActionListener(this);
        buttonMul.addActionListener(this);
        buttonDiv.addActionListener(this);
        buttonMod.addActionListener(this);
        buttonSign.addActionListener(this);
        buttonDecimalPt.addActionListener(this);
        buttonClear.addActionListener(this);
        buttonResult.addActionListener(this);
        buttonDelete.addActionListener(this);
    }


    private String evaluate(double op1, double op2, Operator operator) {
        double result;
        switch(operator) {
            case ADD:
                result = op1 + op2;
                break;
            case SUB:
                result = op1 - op2;
                break;
            case MUL:
                result = op1 * op2;
                break;
            case DIV:
                if (op2 == 0)
                    return "Cannot divide by zero";
                else
                    result = op1 / op2;
                break;
            case MOD:
                if (op2 == 0)
                    return "Cannot divide by zero";
                else
                    result = op1 % op2;
                break;
            default:
                return "";
        }
        if (result == -0.0)
            result = 0.0;

        return Double.toString(result);
    }

    Calculator() {
        frame = new JFrame("Simple Calculator");
        textField = new JTextField();

        initButtons();
        textField.setBounds(30, 40, 280, 30);

        frame.add(textField);
        for (int i = 0; i < 10; ++i)
            frame.add(buttonDigits[i]);
        frame.add(buttonDiv);
        frame.add(buttonMod);
        frame.add(buttonMul);
        frame.add(buttonSub);
        frame.add(buttonAdd);
        frame.add(buttonSign);
        frame.add(buttonDecimalPt);
        frame.add(buttonClear);
        frame.add(buttonResult);
        frame.add(buttonDelete);

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(350, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String field = textField.getText();

        if (source == buttonDigits[0]) {
            textField.setText(field.concat("0"));
        } else if (source == buttonDigits[1]) {
            textField.setText(field.concat("1"));
        } else if (source == buttonDigits[2]) {
            textField.setText(field.concat("2"));
        } else if (source == buttonDigits[3]) {
            textField.setText(field.concat("3"));
        } else if (source == buttonDigits[4]) {
            textField.setText(field.concat("4"));
        } else if (source == buttonDigits[5]) {
            textField.setText(field.concat("5"));
        } else if (source == buttonDigits[6]) {
            textField.setText(field.concat("6"));
        } else if (source == buttonDigits[7]) {
            textField.setText(field.concat("7"));
        } else if (source == buttonDigits[8]) {
            textField.setText(field.concat("8"));
        } else if (source == buttonDigits[9]) {
            textField.setText(field.concat("9"));
        } else if (source == buttonDecimalPt) {
            textField.setText(field.concat("."));
        } else if (source == buttonAdd) {
            op1 = Double.parseDouble(field);
            operator = Operator.ADD;
            textField.setText("");
        } else if (source == buttonSub) {
            op1 = Double.parseDouble(field);
            operator = Operator.SUB;
            textField.setText("");
        } else if (source == buttonDiv) {
            op1 = Double.parseDouble(field);
            operator = Operator.DIV;
            textField.setText("");
        } else if (source == buttonMul) {
            op1 = Double.parseDouble(field);
            operator = Operator.MUL;
            textField.setText("");
        } else if (source == buttonMod) {
            op1 = Double.parseDouble(field);
            operator = Operator.MOD;
            textField.setText("");
        } else if (source == buttonSign) {
            if (field.charAt(0) == '-')
                textField.setText(field.substring(1, field.length()));
            else
                textField.setText("-".concat(field));
        } else if (source == buttonResult) {
            op2 = Double.parseDouble(field);
            textField.setText(evaluate(op1, op2, operator));
        } else if (source == buttonClear) {
            op1 = 0;
            op2 = 0;
            result = 0;
            textField.setText("");
        } else if (source == buttonDelete) {
            textField.setText(field.substring(0, field.length()-1));
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
