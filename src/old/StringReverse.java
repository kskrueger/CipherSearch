package old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringReverse {

    String reverse = "";

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter a string of text here - ");
            String inputStr = br.readLine();
            String reverseStr = new StringReverse().reverseString(inputStr);
            System.out.println("The reverse of your string is - " + reverseStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String reverseString(String inputString){

        if(inputString.length() == 1){
            return inputString;
        } else {
            reverse += inputString.charAt(inputString.length()-1)
                    + reverseString(inputString.substring(0,inputString.length()-1));
            return reverse;
        }
    }
}