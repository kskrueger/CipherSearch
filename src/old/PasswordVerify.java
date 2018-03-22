package old;

import java.util.Scanner;

public class PasswordVerify {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String input;

        System.out.println("---------------Password Verify Tool---------------");
        System.out.println("6 Characters, 1 Number, 1 Uppercase &  1 Lowercase");
        System.out.println("Please enter a password: ");
        input = keyboard.nextLine();

        if (verify(input)) {
            System.out.println("You entered a valid password!");
        } else {
            System.out.println("Error: You entered an invalid password!");
        }
    }

    private static boolean verify(String password) {
        char ch;
        boolean length;
        if (password.length()>=6) {length = true;} else length = false;
        boolean uppercase = false;
        boolean lowercase = false;
        boolean number = false;
        for(int i=0;i < password.length();i++) {
            ch = password.charAt(i);
            if( Character.isDigit(ch)) {
                number = true;
            }
            else if (Character.isUpperCase(ch)) {
                uppercase = true;
            } else if (Character.isLowerCase(ch)) {
                lowercase = true;
            }
            if(length && uppercase && lowercase && number)
                return true;
        }
        return false;
    }
}