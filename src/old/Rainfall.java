package old;

import java.util.Scanner;

public class Rainfall {
    public static String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Oct","Nov","Dec"};
    public static double[] rainfall = new double[12];
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 0;i<12;i++) {
            inputRainfall(months,rainfall,i);
        }

        System.out.println("The total rainfall for the year: "+yearlyTotal(rainfall));
        System.out.println("The average monthly rainfall: "+monthlyAverage(rainfall));
        System.out.println("The month with the most rain: "+highestMonth(rainfall));
        System.out.println("The month with the least rain: "+lowestMonth(rainfall));

        System.exit(0);
    }

    public static void inputRainfall(String[] month, double[] rain, int count) {
        double in = -1;
        while (in<0) {
            System.out.println("Enter the total rainfall for "+month[count]);
            in = input.nextDouble();
        }
        rain[count] = in;
    }

    public static double yearlyTotal(double[] rain) {
        double total = 0;
        for (int i=0;i<12;i++) {
            total+=rain[i];
        }
        return total;
    }

    public static double monthlyAverage(double[] rain) {
        double average = yearlyTotal(rain)/months.length;
        return average;
    }

    public static double highestMonth(double[] rain) {
        double high = 0;
        for (int i=0;i<12;i++) {
            if (rain[i]>high) {
                high = rain[i];
            }
        }
        return high;
    }

    public static double lowestMonth(double[] rain) {
        double low = rain[0];
        for (int i=0;i<12;i++) {
            if (rain[i]<low) {
                low = rain[i];
            }
        }
        return low;
    }
}