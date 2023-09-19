/* This program converts from dollar to rupee and rupee to dollar.
It utilizes Javax Swing and AWT for a JFrame and ActionListeners. */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class CurrencyConverter {
    public static void converter()
    {
        JFrame frame = new JFrame("Currency Converter");
        frame.setResizable(false);
        
        JLabel rupeeLabel, dollarLabel;
        JTextField rupeeText, dollarText;
        JButton rupeeButton, dollarButton, exitButton;

        rupeeLabel = new JLabel("₹:");
        rupeeLabel.setBounds(60, 40, 60, 30);
        dollarLabel = new JLabel("$:");
        dollarLabel.setBounds(220, 40, 60, 30);

        rupeeText = new JTextField("0");
        rupeeText.setBounds(80, 40, 100, 30);
        dollarText = new JTextField("0");
        dollarText.setBounds(240, 40, 100, 30);

        rupeeButton = new JButton("Convert Rupee");
        rupeeButton.setBounds(80, 120, 80, 25);
        rupeeButton.setToolTipText("Convert Rupee to USD.");
        dollarButton = new JButton("Convert USD");
        dollarButton.setBounds(240, 120, 80, 25);
        dollarButton.setToolTipText("Convert USD to Rupee.");
        exitButton = new JButton("Exit");
        exitButton.setBounds(170, 185, 60, 30);
        exitButton.setToolTipText("Exit the program.");

        DecimalFormat decFor = new DecimalFormat("0.00");

        rupeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double rupeeValue = Double.parseDouble(rupeeText.getText());
                double rupToDolNum = (rupeeValue / 65.25);
                String rupToDolText = String.valueOf(decFor.format(rupToDolNum));
                dollarText.setText(rupToDolText);
            }
        });

        dollarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double dollarValue = Double.parseDouble(dollarText.getText());
                double dolToRupNum = (dollarValue * 65.25);
                String dolToRupText = String.valueOf(decFor.format(dolToRupNum));
                rupeeText.setText(dolToRupText);
            }
        });

        // logic for exiting the program
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
            }
        });

        // default logic to close frame
        frame.addWindowListener(new WindowAdapter() {
            public void closeWindow(WindowEvent e)
            {
                System.exit(0);
            }
        });

        // add objects to frame/form
        frame.add(rupeeLabel);
        frame.add(rupeeText);
        frame.add(dollarLabel);
        frame.add(dollarText);
        frame.add(rupeeButton);
        frame.add(dollarButton);
        frame.add(exitButton);

        frame.setLayout(null);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    public static void main(String args[])
    {
        converter();
    }
}