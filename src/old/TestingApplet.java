package old;

import javax.swing.*;

import javax.swing.event.*;

import java.awt.*;



public class TestingApplet extends JApplet implements ChangeListener{
  int height = 100;
    
    Container mainContainer;

    JPanel displayContainer;

    JPanel titleContainer;

    JPanel temperatureSliderContainer;

    JSlider temperatureSlider;

    JLabel title;

    JLabel temperatureLabel;

    JTextField temperatureField;

    String theTitle = "Thermometer Applet";

    String theUnit = "Degrees in Fahrenheit";

    public void init() {
        mainContainer = getContentPane();
        mainContainer.setLayout(new BorderLayout());
        titleContainer = new JPanel();
        displayContainer = new JPanel();
        temperatureSliderContainer = new JPanel();

        //temperature slider
        temperatureSlider = new JSlider(JSlider.VERTICAL, 0, 200, 60);
        temperatureSlider.setMinorTickSpacing(10);
        temperatureSlider.setMajorTickSpacing(20);
        temperatureSlider.setPaintTicks(true);
        temperatureSlider.setPaintLabels(true);
        temperatureSlider.addChangeListener(this);
        temperatureSliderContainer.add(temperatureSlider);

        mainContainer.add(temperatureSliderContainer, BorderLayout.CENTER);
        temperatureField = new JTextField("60", 2);
        temperatureField.setEditable(false);
        displayContainer.add(temperatureField);
        temperatureLabel = new JLabel(theUnit);
        displayContainer.add(temperatureLabel);
        mainContainer.add(displayContainer, BorderLayout.SOUTH);
        title = new JLabel(theTitle);
        titleContainer.add(title);
        mainContainer.add(titleContainer, BorderLayout.NORTH);

        resize(500, 500);

    }

    // implement stateChanged method of changeListener

    public void stateChanged(ChangeEvent e) {

        int temp = temperatureSlider.getValue();

        temperatureField.setText(temp + "");
        height = temp;

    }


    public void paint(Graphics g) {
        // Call the superclass paint method.
        super.paint(g);

        // Draw a black unfilled rectangle.
        g.setColor(Color.black);
        g.drawRect(10, 20, 75, 180);

        // Draw a red filled rectangle.
        g.setColor(Color.red);
        g.fillRect(12, 200-height, 71, height);
    }
}