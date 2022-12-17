package org.college.projects;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    JFrame frame;   JPanel numbers_panel, operators_panel;   JTextField text_field;
    Font font = new Font(Font.SANS_SERIF, Font.BOLD, 20);

    String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    JButton[] number_buttons = new JButton[numbers.length]; // numbers buttons

    //                            0     1    2    3    4    5    6    7   8        9       10
    String[] operation_symbols = {"+", "-", "/", "*", "%", "^", "!", ".", "=", "Delete", "Clear"};
    JButton[] operation_buttons = new JButton[operation_symbols.length];
    
    JButton[] func_buttons = new JButton[operation_symbols.length];

    String operator = "";
    Double text_field_numbers1, text_field_numbers2;    Double result;

    public static void set_buttons_colors(JButton[] buttons){
        for(int i = 0; i < buttons.length; i++){
            buttons[i].setBackground(Color.getHSBColor(350, 46, 90));
        }
    }
    public static void add_to_panel(JPanel panel, JButton[] buttons){
        for(int i = 0; i < buttons.length; i++){
            panel.add(buttons[i]);
        }
    }
    public static void set_numbers(JButton[] number_buttons, String[] numbers){
        for(int i = 0; i < numbers.length; i++){
            number_buttons[i] = new JButton(numbers[i]);
        }
    }
    public void create_buttons(JButton[] buttons){
        for(int i = 0; i < buttons.length; i++){
            buttons[i].addActionListener(this);
            buttons[i].setFont(font);
        }
    }
    // set buttons to functions
    public static JButton[] func_buttons(JButton[] func_buttons, JButton[] buttons){
        for(int i = 0; i < buttons.length; i++){
            func_buttons[i] = buttons[i];
        }
        return func_buttons;
    }
    // set operation symbols
    public static void set_buttons(JButton[] operators, String[] symbols){
        for(int i = 0; i < operators.length; i++){
            operators[i] = new JButton(symbols[i]);
        }
    }
    Calculator(){
        frame = new JFrame("Calculator"); // initialize the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to close the window
        frame.setSize(600, 480); // size of the frame
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.getHSBColor(255, 229, 204));

        text_field = new JTextField();
        text_field.setBounds(50, 25, 500, 70);
        text_field.getBorder();
        text_field.setEditable(false);
        text_field.setBackground(Color.WHITE);

        set_buttons(operation_buttons, operation_symbols); // set operations buttons
        create_buttons(func_buttons(func_buttons, operation_buttons));

        set_numbers(number_buttons, numbers);
        create_buttons(number_buttons);

        numbers_panel = new JPanel(); // create a panel for buttons
        numbers_panel.setBounds(50, 110, 300, 300);
        numbers_panel.setLayout(new GridLayout(4, 2, 5, 5));
        numbers_panel.setBackground(Color.getHSBColor(255, 229, 204));

        number_buttons[9].setBounds(51, 338, 298, 70); // Zero Button

        add_to_panel(numbers_panel, number_buttons);

        operators_panel = new JPanel();
        operators_panel.setBounds(355, 110, 195, 300);
        operators_panel.setLayout(new GridLayout(4, 6, 5, 5));
        operators_panel.setBackground(Color.getHSBColor(255, 229, 204));

        operation_buttons[9].setBounds(356, 338, 95, 70); // Delete Buttons
        operation_buttons[10].setBounds(454, 338, 95, 70); // Clear Button

        add_to_panel(operators_panel, operation_buttons);

       // set_buttons_colors(number_buttons);
       // set_buttons_colors(operation_buttons);

        frame.add(number_buttons[9]); // Zero Button
        frame.add(operation_buttons[9]); // Delete Button
        frame.add(operation_buttons[10]); // Clear Button
        frame.add(operators_panel);
        frame.add(numbers_panel);
        text_field.setFont(font);
        frame.add(text_field);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        for(int i = 0; i < number_buttons.length; i++){
            if(event.getSource() == number_buttons[i]){
                text_field.setText(text_field.getText()
                          .concat(String.valueOf(numbers[i])));
            }
        }
        if(event.getSource() == operation_buttons[10]){ // Clear Button
            text_field.setText("");
        }
        if(event.getSource() == operation_buttons[9]){ // Delete Button
            String text = text_field.getText(); // get the text from the text field
            text_field.setText(""); // clear all text
            for(int i = 0; i < (text.length() - 1); i++){
                text_field.setText(text_field.getText() + text.charAt(i)); // set the current text - one char
            }
        }
        if(event.getSource() == operation_buttons[0]){
            text_field_numbers1 = Double.parseDouble(text_field.getText());
            operator = operation_symbols[0]; // addition
            text_field.setText("");
        }
        if(event.getSource() == operation_buttons[1]){
            text_field_numbers1 = Double.parseDouble(text_field.getText());
            operator = operation_symbols[1]; // subtraction
            text_field.setText("");
        }
        if(event.getSource() == operation_buttons[2]){
            text_field_numbers1 = Double.parseDouble(text_field.getText());
            operator = operation_symbols[2]; // division
            text_field.setText("");
        }
        if(event.getSource() == operation_buttons[3]){
            text_field_numbers1 = Double.parseDouble(text_field.getText());
            operator = operation_symbols[3]; // multiplication
            text_field.setText("");
        }
        if(event.getSource() == operation_buttons[4]){
            text_field_numbers1 = Double.parseDouble(text_field.getText());
            operator = operation_symbols[4]; // modulus
            text_field.setText("");
        }
        if(event.getSource() == operation_buttons[5]){
            text_field_numbers1 = Double.parseDouble(text_field.getText());
            operator = operation_symbols[5]; // power
            text_field.setText("");
        }
        if(event.getSource() == operation_buttons[6]){
            text_field_numbers1 = Double.parseDouble(text_field.getText());
            operator = operation_symbols[6]; // factorial
            text_field.setText("");
            int result = Operations.factorial(text_field_numbers1.intValue());
            text_field.setText(String.valueOf(result));
        }
        if(event.getSource() == operation_buttons[7]){ // Decimal Button
            text_field.setText( text_field.getText() + operation_symbols[7]);
        }
        if(event.getSource() == operation_buttons[8]){
            text_field_numbers2 = Double.parseDouble(text_field.getText());
            switch (operator) {
                case "+":
                    result = Operations.addition(text_field_numbers1, text_field_numbers2);
                    break;
                case "-":
                    result = Operations.subtraction(text_field_numbers1, text_field_numbers2);
                    break;
                case "/":
                    result = Operations.division(text_field_numbers1, text_field_numbers2);
                    break;
                case "%":
                    result = Operations.modulus(text_field_numbers1, text_field_numbers2);
                    break;
                case "*":
                    result = Operations.multiplication(text_field_numbers1, text_field_numbers2);
                    break;
                case "^":
                    result = Operations.power(text_field_numbers1, text_field_numbers2);
                    break;
                default:
            }
            text_field.setText(String.valueOf(result));
            text_field_numbers1 = result;
        }
    }
}
