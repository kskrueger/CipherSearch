package old;

import javax.swing.*;

import javax.swing.event.*;

import java.awt.*;

public class Applet extends JApplet implements ChangeListener {

    Container mainContainer;

    JPanel displayContainer;

    JPanel titleContainer;

    JPanel temperatureSliderContainer;

    JSlider temperatureSlider;

    JLabel title;

    JLabel temperatureLabel;

    JTextField temperatureField;

    String tTitle = "My Thermometer";

    String tUnit = "Degrees/Fahrenheit";

    public void init() {

        // setup main container to hold every components

        mainContainer = getContentPane();

        mainContainer.setLayout(new BorderLayout());

        // setup container for title,temperature display,slider components

        titleContainer = new JPanel();

        displayContainer = new JPanel();

        temperatureSliderContainer = new JPanel();

        // create a vertical slider with range from -40 to 120 and default value

        // 60

        temperatureSlider = new JSlider(JSlider.VERTICAL, -40, 120, 60);

        temperatureSlider.setMinorTickSpacing(10);

        temperatureSlider.setMajorTickSpacing(20);

        temperatureSlider.setPaintTicks(true);

        temperatureSlider.setPaintLabels(true);

        // set slider change listener

        temperatureSlider.addChangeListener(this);

        // now add slider to temperatureSliderContainer

        temperatureSliderContainer.add(temperatureSlider);

        // add to main Container

        mainContainer.add(temperatureSliderContainer, BorderLayout.CENTER);

        // temperatureField to display current temperature

        temperatureField = new JTextField("60", 2);

        temperatureField.setEditable(false);

        displayContainer.add(temperatureField);

        // label to display temperature unit

        temperatureLabel = new JLabel(tUnit);

        displayContainer.add(temperatureLabel);

        // add to main Container

        mainContainer.add(displayContainer, BorderLayout.SOUTH);

        // create label for title

        title = new JLabel(tTitle);

        // add title to its container

        titleContainer.add(title);

        // add to main Container

        mainContainer.add(titleContainer, BorderLayout.NORTH);

        resize(300, 300);

    }

    // implement stateChanged method of changeListener

    public void stateChanged(ChangeEvent e) {

        int temp = temperatureSlider.getValue();

        temperatureField.setText(temp + "");

    }

}