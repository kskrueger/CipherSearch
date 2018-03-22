package old;

import java.io.*;
import java.util.Arrays;

public class FileArray {
    private static String fileName = "File1";
    private static int[] inputArray = { 1, 2, 3, 4, 5, 6, 7 };
    private static int[] outputArray = new int[7];

    public static void main(String[] args) {
        try {
            writeArray(fileName,inputArray);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            readFile(fileName,outputArray);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.toString(FileArray.outputArray));

        System.exit(0);
    }

    private static void writeArray(String fileName, int[] intArray) throws IOException {
        System.out.println("Writing the array to file...");
        FileOutputStream fileStream = new FileOutputStream(fileName);
        DataOutputStream fileOut = new DataOutputStream(fileStream);
        for (int anIntArray : intArray) fileOut.writeInt(anIntArray);
        System.out.println("Done: File written");
        fileOut.close();
    }

    private static void readFile(String fileName, int[] outputArray) throws IOException {
        System.out.println("Reading the array from file...");
        int number;
        boolean endOfFile = false;
        int i = 0;

        FileInputStream fstream = new FileInputStream(fileName);
        DataInputStream inputFile = new DataInputStream(fstream);

        while (!endOfFile) {
            try {
                number = inputFile.readInt();
                outputArray[i] = number;
                i++;
            } catch (EOFException e) {
                endOfFile = true;
            }
        }
        System.out.println("Done: File has been read");
        inputFile.close();
    }


}
