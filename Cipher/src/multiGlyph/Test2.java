package multiGlyph;

import java.util.Arrays;

import static multiGlyph.Ciphers.CipherOptions;
import static multiGlyph.Ciphers.PermanentCipherCopy;

public class Test2 {
    private static CipherMatch cipherTest = new CipherMatch();

    private static int[][] load1 = new int[][]{
            {0}, //1st glyph preload glyph
            {2},  //2nd glyph intaked
            {2}  //2nd glyph intaked
    };

    private static int[][] load2 = new int[][]{
            {0}, //fake bottom glyph to simulate solid surface below
            {1}, //1st glyph intaked (bottom when placing)
            {1}  //2nd glyph (top when placing)
    };

    private static int[][] load3 = new int[][]{
            {0}, //fake bottom glyph to simulate solid surface below
            {1}, //1st glyph intaked (bottom when placing)
            {0}  //2nd glyph (top when placing)
    };

    static int[][][] load = new int[][][] {
            {
                    {0}, //fake bottom glyph to simulate solid surface below
                    {1}, //1st glyph intaked (bottom when placing)
                    {1}  //2nd glyph (top when placing)
            },
            {
                    {0}, //fake bottom glyph to simulate solid surface below
                    {1}, //1st glyph intaked (bottom when placing)
                    {2}  //2nd glyph (top when placing)
            },
            {
                    {0}, //fake bottom glyph to simulate solid surface below
                    {2}, //1st glyph intaked (bottom when placing)
                    {1}  //2nd glyph (top when placing)
            },
            {
                    {0}, //fake bottom glyph to simulate solid surface below
                    {2}, //1st glyph intaked (bottom when placing)
                    {2}  //2nd glyph (top when placing)
            }
    };

    static int[][][] vumarkLoad = new int[][][] {
            {
                    {1}, //1st glyph intaked (bottom when placing)
                    {1}  //2nd glyph (top when placing)
            },
            {
                    {1}, //1st glyph intaked (bottom when placing)
                    {2}  //2nd glyph (top when placing)
            },
            {
                    {2}, //1st glyph intaked (bottom when placing)
                    {1}  //2nd glyph (top when placing)
            },
            {
                    {2}, //1st glyph intaked (bottom when placing)
                    {2}  //2nd glyph (top when placing)
            }
    };

    static int cipherCount = 0;
    static int totalCount = 0;

    public static void main(String[] args) {

        for (int vumarkColumn = 0; vumarkColumn <=2; vumarkColumn ++) {

            for (int firstLoad = 0; firstLoad <= 3; firstLoad ++) {

                for (int secondLoad = 0; secondLoad <= 3; secondLoad ++) {

                    cipherTest.vumarkGlyph(vumarkLoad[firstLoad],vumarkColumn);

                    cipherTest.search(load[secondLoad]);

                    System.out.println("Vumark Column: "+vumarkColumn
                            +", Vumark Load: "+ Arrays.deepToString(vumarkLoad[firstLoad])
                            +", Second Load: "+Arrays.deepToString(load[secondLoad])
                            +", Valid: "+cipherTest.checkCipherValid());

                    totalCount += 1;

                    if (cipherTest.checkCipherValid()) {
                        cipherCount += 1;
                    }

                    resetCipher();
                }
            }
        }

        System.out.println("Total Count: "+totalCount);
        System.out.println("Compatible Count: "+cipherCount);

    }

    static void complete4glyph() {
        //cipherTest.vumarkGlyph(2,2,2);
        cipherTest.vumarkGlyph(load1,2);

        cipherTest.search(load2);

        cipherTest.printCipher();

        System.out.println(cipherTest.checkCipherValid());
    }

    static void resetCipher () {
        cipherTest = new CipherMatch();
        cipherTest.printCipher();
    }

}
