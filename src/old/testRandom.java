package old;

import javax.swing.*;
import java.util.Random;


public class testRandom {
    public void main(String[] args) {
        int cardNumber;

        Random randomCard = new Random();

        cardNumber = randomCard.nextInt(10);

        JOptionPane.showMessageDialog(null,cardNumber);
    }
}