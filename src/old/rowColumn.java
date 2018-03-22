package old;

import java.util.Random;

public class rowColumn {

    public static void main(String[] args) {
        int[][] matrix1 = new int[4][4];

        matrix(matrix1);

        for (int row = 0; row < 4; row++) {
            System.out.println("" + matrix1[0][row] + matrix1[1][row] + matrix1[2][row] + matrix1[3][row]);
        }
        System.out.println("The largest row index: "+largestRow(matrix1));
        System.out.println("The largest column index: "+largestColumn(matrix1));
    }

    public static void matrix(int[][] matrix1) {
        Random random = new Random();

        int n = 4;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix1[i][j] = random.nextInt(2);
            }

        }

    }

    public static int largestRow(int[][] matrix1) {
        int value;
        int highestRow = 0;
        int highestValue = 0;
        for (int row = 0; row < 4; row++) {
            value = (matrix1[0][row] + matrix1[1][row] + matrix1[2][row] + matrix1[3][row]);
            if (value>highestValue) {
                highestRow = row;
                highestValue = value;
            }
        }
        return highestRow;
    }
    public static int largestColumn(int[][] matrix1) {
        int value;
        int highestCol = 0;
        int highestValue = 0;
        for (int col = 0; col < 4; col++) {
            value = (matrix1[col][0] + matrix1[col][1] + matrix1[col][2] + matrix1[col][3]);
            if (value>highestValue) {
                highestCol = col;
                highestValue = value;
            }
        }
        return highestCol;
    }

}