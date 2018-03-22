package old;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TranslateController
{
    @FXML
    private RadioButton sinisterButton;

    @FXML
    private ToggleGroup myToggleGroup;

    @FXML
    private Label outputLabel;

    @FXML
    private RadioButton dexterButton;

    @FXML
    private RadioButton mediumButton;

    // Event listener for the showChoiceButton component
    public void showChoiceListener()
    {
        if (sinisterButton.isSelected())
            outputLabel.setText("left");

        if (sinisterButton.isSelected())
            outputLabel.setText("right");

        if (sinisterButton.isSelected())
            outputLabel.setText("center");
    }
}