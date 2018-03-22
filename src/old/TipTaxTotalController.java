package old;

import java.text.NumberFormat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TipTaxTotalController {
    @FXML
    private Button tttButton;
    @FXML
    private TextField mealCost;
    @FXML
    private Label tipLabel;
    @FXML
    private Label taxLabel;
    @FXML
    private Label totalLabel;

    private final NumberFormat nf = NumberFormat.getNumberInstance();

    {
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
    }

    public void getTipTaxTotal() {
        double cost = Double.parseDouble(mealCost.getText());
        double tip = cost * .18;
        double tax = cost * .07;
        double total = (cost + tip + tax);

        tipLabel.setText("$" + nf.format(tip));
        taxLabel.setText("$" + nf.format(tax));
        totalLabel.setText("$" + nf.format(total));
    }
}