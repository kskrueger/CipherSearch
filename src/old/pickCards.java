package old;

import javax.print.DocFlavor;
import java.util.*;
import java.util.Random;


public class pickCards {
    public static void main(String[] args) {
        int card1 = randomCard();
        int card2 = randomCard();
        int card3 = randomCard();
        int card4 = randomCard();

        int sum = card1 + card2 + card3 + card4;

        while (sum!=24) {
            card1 = randomCard();
            card2 = randomCard();
            card3 = randomCard();
            card4 = randomCard();
            sum = card1 + card2 + card3 + card4;
        }

        System.out.println("The cards that summed 24 were ");
        System.out.println(cardType(card1));
        System.out.println(cardType(card2));
        System.out.println(cardType(card3));
        System.out.println(cardType(card4));
    }


        public static int randomCard() {
            int cardNumber;
            Random randomCard = new Random(13);
            cardNumber = randomCard.nextInt();

            return cardNumber;
        }

        public static String cardType(int cardNumber){
        /*
        1 = Ace
        2-10 = 2-10
        11 = Jack
        12 = Queen
        13 = King
        */
            String out = "";

            if (cardNumber>=2&&cardNumber<=10) {
                out = cardNumber+"";
            } else if (cardNumber==1) {
                out = "Ace";
            } else if (cardNumber==11) {
                out = "Jack";
            } else if (cardNumber==12) {
                out = "Queen";
            } else if (cardNumber==13) {
                out = "King";
            } else {
                out = "";
            }

            return out;
        }
    }