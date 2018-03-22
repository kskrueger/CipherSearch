package multiGlyph;

public class Test1 {
    private static SearchArray cipherTest = new SearchArray();

    private static int[][] load1 = new int[][]{
            {0}, //1st glyph preload glyph
            {0}  //2nd glyph intaked
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

    public static void main(String[] args) {

        //cipherTest.vumarkGlyph(1,0);
        cipherTest.vumarkGlyphDouble(0,0,2);

        System.out.println("Vumark and bonus glyph scored in "+glyphColumn(cipherTest.getColumn())+" column");

        cipherTest.selectCipher3glyph(load2);

        String column = "none";
        column = glyphColumn(cipherTest.getColumn());
        System.out.println("Column: "+column);

        String height = "none";
        height = glyphHeight(cipherTest.getHeight());
        System.out.println("Height: "+height);

        //System.out.println("3 glyph done");
        System.out.println("4 glyph done");

        /*cipherTest.followCipher5glyph(load3);

        column = "none";
        if (cipherTest.getColumn()==0) {
            column = "Left";
        } else if (cipherTest.getColumn()==1) {
            column = "Center";
        } else if (cipherTest.getColumn()==2) {
            column = "Right";
        }
        System.out.println("Column: "+column);

        height = "none";
        if (cipherTest.getHeight()==0) {
            height = "Low";
        } else if (cipherTest.getHeight()==1) {
            height = "Mid";
        } else if (cipherTest.getHeight()==2) {
            height = "High";
        }
        System.out.println("Height: "+height);

        System.out.println("5 glyph done");*/

        cipherTest.printCipher();

        cipherTest.printCurrent();
    }

    private static String glyphColor(int color) {
        if (color==1) {
            return "Grey";
        } else {
            return "Brown";
        }
    }

    private static String glyphColumn(int column) {
        if (column==0) {
            return "Left";
        } else if (column==1) {
            return "Middle";
        } else {
            return "Right";
        }
    }

    private static String glyphHeight(int height) {
        if (cipherTest.getHeight()==0) {
            return  "Low";
        } else if (cipherTest.getHeight()==1) {
            return  "Mid";
        } else {
            return "High";
        }
    }

}
