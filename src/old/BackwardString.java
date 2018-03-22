package old;

import javax.swing.*;
import java.util.Scanner;


public class BackwardString {
    public static void main(String[] args) {
        //Scanner keyboard = new Scanner(System.in);
        String in;

        //System.out.print("Please enter a word to be reversed: ");
        in = JOptionPane.showInputDialog("Please enter a word to be reversed: ");
        //in = keyboard.nextLine();

        flip(in);
    }

    private static void flip(String word)
    {
        System.out.print("Reversed: ");
        String out = "";
        for (int i = 0; i < word.length(); i++)
            //System.out.print(word.charAt(word.length() - 1 - i) );
            out += word.charAt(word.length() - 1 - i);
        //System.out.println();
        JOptionPane.showMessageDialog(null,out);
    }
}