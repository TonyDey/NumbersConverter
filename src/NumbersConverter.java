/**
 * The NumbersConverter program implements conversion of decimal numbers
 * into binary, octal and hexadecimal numbers
 *
 * @author  Anatoly Dubinsky
 * @version 1.0
 * @since   09.04.2023
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumbersConverter implements ActionListener {
    JFrame frame = new JFrame();
    JTextField textFieldDecimal = new JTextField();
    JTextField textFieldBinary = new JTextField();
    JTextField textFieldOctal = new JTextField();
    JTextField textFieldHexadecimal = new JTextField();
    JTextField[] textFields = {textFieldDecimal, textFieldBinary, textFieldOctal, textFieldHexadecimal};
    JLabel labelDecimal = new JLabel();
    JLabel labelBinary = new JLabel();
    JLabel labelOctal = new JLabel();
    JLabel labelHexadecimal = new JLabel();

    JLabel[] labels = {labelDecimal, labelBinary, labelOctal, labelHexadecimal};

    Font font1 = new Font("Apple Casual", Font.BOLD, 16);
    public NumbersConverter() {
        frame.setTitle("Number system converter");
        frame.setSize(800, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        labelDecimal.setText("Decimal");
        labelBinary.setText("Binary");
        labelOctal.setText("Octal");
        labelHexadecimal.setText("Hexadecimal");

        for (int i = 0; i < labels.length; i++) {
            int y = 50 + (i * 80);
            labels[i].setBounds(10, y, 100, 50);
            labels[i].setFont(font1);
            frame.add(labels[i]);

            textFields[i].setBounds(150, y, 575, 50);
            frame.add(textFields[i]);
            textFields[i].addActionListener(this);
        }

        for (int i = 1; i < textFields.length; i++) {
            textFields[i].setEditable(false);
            textFields[i].setBackground(Color.WHITE);
        }



        frame.setVisible(true);
    }

    /**
     * toBinary converts a decimal number to a binary number
     * @param n represents an integer
     * @return binary number
     */
    public static String toBinary(int n){
        return Integer.toBinaryString(n);
    }

    /**
     * toBinary converts a decimal number to an octal number
     * @param n represents an integer
     * @return octal number
     */
    public static String toOctal(int n){
        return Integer.toOctalString(n);
    }

    /**
     * toBinary converts a decimal number to a hexadecimal number
     * @param n represents an integer
     * @return hexadecimal number
     */
    public static String toHexadecimal(int n){
        return Integer.toHexString(n);
    }

    /**
     * event handler
     * @param e represents the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int decimalValue = Integer.parseInt(textFieldDecimal.getText());
            textFieldBinary.setText(toBinary(decimalValue));
            textFieldOctal.setText(toOctal(decimalValue));
            textFieldHexadecimal.setText(toHexadecimal(decimalValue));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid decimal number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * main method which creates an instance of NumbersConverter class
     * @param args unused
     */
    public static void main(String[] args) {
        new NumbersConverter();
    }
}
