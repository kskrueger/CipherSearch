package old;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalesTax extends JFrame {
    private JPanel panel;
    private JLabel messageLabelCounty;
    private JLabel messageLabelState;
    private JLabel messageLabelTotal;
    private JTextField kiloTextField;
    private double countyTax;
    private double stateTax;

    public static void main(String[] args) {
        SalesTax window = new SalesTax();
    }

    SalesTax() {
        final int WINDOW_WIDTH = 180;   // Window width in pixels
        final int WINDOW_HEIGHT = 250;  // Window height in pixels

        setTitle("Tax Calculator");

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        buildPanel();

        add(panel);

        setVisible(true);
    }

    private void buildPanel() {
        JLabel messageLabel = new JLabel("Enter Amount of Sales $");
        kiloTextField = new JTextField(10);
        JButton calcButton = new JButton("Calculate");
        messageLabelCounty = new JLabel("County Tax: "+countyTax);
        messageLabelState = new JLabel("State Tax: "+stateTax);
        messageLabelTotal = new JLabel("Total Tax: "+(countyTax+stateTax));

        calcButton.addActionListener(new CalcButtonListener());

        panel = new JPanel();
        panel.add(messageLabel);
        panel.add(kiloTextField);
        panel.add(calcButton);
        panel.add(messageLabelCounty);
        panel.add(messageLabelState);
        panel.add(messageLabelTotal);
    }

    private void calculate(String text) {
        double kilos = Double.parseDouble(text);
        double stateTaxRate = .04;
        double countyTaxRate = .02;
        stateTax = Math.round(stateTaxRate*kilos);
        countyTax = Math.round(countyTaxRate*kilos);
        messageLabelCounty.setText("County Tax: $"+countyTax);
        messageLabelState.setText("State Tax: $"+stateTax);
        messageLabelTotal.setText("Total Tax: $"+(countyTax+stateTax));
        panel.updateUI();
    }

    private class CalcButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input = kiloTextField.getText();
            calculate(input);
        }
    }
}