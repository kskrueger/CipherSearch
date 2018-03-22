package old;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScrollTax extends JFrame{
    private JPanel panel;
    private JSlider slider;
    private JLabel sliderLabel;
    private JTextField purchaseTextField;
    private JLabel messageLabelSalesTax;
    private double salesTax = 0;

    public static void main(String[] args) {
        ScrollTax window = new ScrollTax();
    }

    private ScrollTax() {
        final int WINDOW_WIDTH = 200;   // Window width in pixels
        final int WINDOW_HEIGHT = 250;  // Window height in pixels

        setTitle("Scrollable Tax Calculator");

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        buildPanel();

        add(panel);

        setVisible(true);
    }

    private void buildPanel() {
        JLabel messageLabel = new JLabel("Enter Amount of Purchase $");
        purchaseTextField = new JTextField(10);
        sliderLabel = new JLabel("Tax Rate Slider (%)");
        slider = new JSlider(SwingConstants.HORIZONTAL,0,10,5);
        slider.setMajorTickSpacing(2);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        JButton calcButton = new JButton("Calculate");
        messageLabelSalesTax = new JLabel("Total Sales Tax: "+salesTax);

        calcButton.addActionListener(new CalcButtonListener2());

        panel = new JPanel();
        panel.add(messageLabel);
        panel.add(purchaseTextField);
        panel.add(sliderLabel);
        panel.add(slider);
        panel.add(calcButton);
        panel.add(messageLabelSalesTax);
    }

    private class CalcButtonListener2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            update();
        }
    }

    private void update () {
        int input = slider.getValue();
        int purchaseAmount = Integer.parseInt(purchaseTextField.getText());
        salesTax = input*purchaseAmount/100;
        messageLabelSalesTax.setText("Total Sales Tax: "+Double.toString(salesTax));
        panel.updateUI();
    }
}
