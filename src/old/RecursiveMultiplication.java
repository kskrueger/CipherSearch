package old;

import java.util.*;

public class RecursiveMultiplication {
    public static void main(String[] args) {
        int n, m;
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        n = in.nextInt();
        System.out.print("Please enter the second number: ");
        m = in.nextInt();
        System.out.println(n + " * " + m + " = " + multiply(n, m));
    }

    public static int multiply(int x, int y) {
        if(y<0)
            return -multiply(x, -y);
        else if(y==0)
            return 0;
        else
            return multiply(x+x, y>>1) + (y&1) * x;
    }
}