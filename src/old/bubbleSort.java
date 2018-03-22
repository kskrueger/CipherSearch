package old;

import java.util.Scanner;

public class bubbleSort {
    public static void main(String[] args) {
        Scanner inputNumbers = new Scanner(System.in);
        double[] numbers = new double[10];

        System.out.print("Please enter ten numbers: ");
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = inputNumbers.nextDouble();

        sort(numbers);

        for (double e: numbers) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    /*public static void sort(double[] list) {
        double temp;
        boolean swap;

        do {
            swap = false;
            for (int i = 0; i < list.length - 1; i++) {

                if (list[i] > list[i + 1]) {
                    temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    swap = true;
                }

            }

        } while (swap);

    }*/

    public static void sort(double[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for(int j = i; j < list.length-1; j++){
                if(list[i] > list[j]){
                    //swap them!
                }
            }
        }
    }

}