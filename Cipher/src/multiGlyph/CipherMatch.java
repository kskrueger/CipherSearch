package multiGlyph;

import javax.crypto.Cipher;
import java.util.Arrays;

import static multiGlyph.Ciphers.*;

public class CipherMatch {
    private int column = 0;
    private int height = 0;

    private int vumarkColumn;
    private int vumarkGlyphColor1;
    private int vumarkGlyphColor2;

    private boolean found = false;

    int cipherChosen;

    boolean cipherValid = false;

    private int[][] submatrix = new int[][]{
            {0}, //fake bottom glyph to simulate solid surface below
            {1}, //1st glyph intaked (bottom when placing)
            {2}  //2nd glyph (top when placing)
    };

    public void setHopperGlyphs(int backGlyph, int frontGlyph) {
        submatrix[1][0] = backGlyph;
        submatrix[2][0] = frontGlyph;
    }

    public void setSingleGlyph(int backGlyph, int frontGlyph) {
        submatrix[1][0] = backGlyph;
        submatrix[2][0] = frontGlyph;
    }

    void vumarkGlyph(int glyphColor, int column) {
        this.column = column;
        this.vumarkGlyphColor1 = glyphColor;

        for (int i = 0; i <= 5; i ++) {
            if (CipherOptions[i][1][column] == glyphColor) {
                cipherChosen = i;

                cipherCompatible[i] = true;

                CipherOptions[i][1][column] = 0;
            } else {
                cipherCompatible[i] = false;
            }
        }

        System.out.println("Vumark and bonus glyph scored in "+glyphColumn(getColumn())+" column");
    }

    void vumarkGlyph(int glyphColor, int glyphColor2, int column) {
        this.column = column;

        for (int i = 0; i <= 5; i ++) {
            if (CipherOptions[i][1][column] == glyphColor
                    && CipherOptions[i][2][column] == glyphColor2) {
                cipherChosen = i;

                cipherCompatible[i] = true;

                CipherOptions[i][1][column] = 0;
                CipherOptions[i][2][column] = 0;
            } else {
                cipherCompatible[i] = false;
            }
        }

        System.out.println("Vumark and bonus glyph scored in "+glyphColumn(getColumn())+" column");
    }

    void vumarkGlyph(int[][] hopper, int column) {
        this.column = column;

        for (int i = 0; i <= 5; i ++) {
            if (CipherOptions[i][1][column] == hopper[0][0]
                    && CipherOptions[i][2][column] == hopper[1][0]) {
                cipherChosen = i;

                cipherCompatible[i] = true;

                CipherOptions[i][1][column] = 0;
                CipherOptions[i][2][column] = 0;
            } else {
                cipherCompatible[i] = false;
            }
        }

        //System.out.println("Vumark and bonus glyph scored in "+glyphColumn(getColumn())+" column");
    }

    void search(int[][] hopper) {

        for (int i = 0; i <= 5; i ++) {
            if (searchSingle(CipherOptions[i],hopper) && cipherCompatible[i]) {
                cipherChosen = i;

                cipherCompatible[i] = true;

                CipherOptions[i][height+1][column] = 0;
                CipherOptions[i][height+2][column] = 0;
            } else {
                cipherCompatible[i] = false;
            }
        }

        //System.out.println("Glyphs scored in "+glyphColumn(getColumn())+" column at "+glyphHeight(getHeight())+" height");
    }

    void printCipher () {
        for (int i = 0; i <= 5; i ++) {
            if (cipherCompatible[i]) {
                System.out.println(CipherNumber(i));
                System.out.println(Arrays.deepToString(CipherOptions[i]));
            }
        }
    }

    boolean checkCipherValid () {
        cipherValid = false;
        for (int i = 0; i <=5; i ++) {
            if (cipherCompatible[i]) {
                cipherValid = true;
            }
        }
        return cipherValid;
    }

    private boolean searchSingle(int[][] matrix, int[][] submatrix) {
        found = false;
        loopX: for (int x = 0; x < matrix.length - submatrix.length + 1; ++x)
            loopY: for (int y = 0; y < matrix[x].length - submatrix[0].length + 1; ++y)
            {
                for (int xx = 0; xx < submatrix.length; ++xx)
                    for (int yy = 0; yy < submatrix[0].length; ++yy)
                    {
                        if (matrix[x + xx][y + yy] != submatrix[xx][yy])
                        {
                            continue loopY;
                        }
                    }

                // Found the pattern in a cipher!
                found = true;
                this.column = y;
                this.height = x;
                //System.out.println("Found at: " + x + " " + y);
                break loopX;
            }

            if (found) {
                matrix[height+1][column] = 0;
                matrix[height+2][column] = 0;
                //System.out.println("Updated positions");
            }

            return found;
    }

    int getColumn() {
        return column;
    }

    int getHeight() {
        return height;
    }

    String CipherNumber (int number) {
        switch (number) {
            case 0:
                return "Grey Frog";
            case 1:
                return "Brown Frog";
            case 2:
                return "Grey Snake";
            case 3:
                return "Brown Snake";
            case 4:
                return "Grey Bird";
            case 5:
                return "Brown Bird";
        }
        return "None";
    }

    private String glyphColor(int color) {
        if (color==1) {
            return "Grey";
        } else {
            return "Brown";
        }
    }

    private String glyphColumn(int column) {
        if (column==0) {
            return "Left";
        } else if (column==1) {
            return "Center";
        } else {
            return "Right";
        }
    }

    private String glyphHeight(int height) {
        if (getHeight()==0) {
            return  "Low";
        } else if (getHeight()==1) {
            return  "Mid";
        } else if (getHeight()==2) {
            return "High";
        } else {
            return "hmm?";
        }
    }

}

/**
 public void vumarkGlyphDouble(int glyphColor1, int glyphColor2, int column) {
 this.vumarkColumn = column;
 this.vumarkGlyphColor1 = glyphColor1;
 this.vumarkGlyphColor2 = glyphColor2;

 int[][] hopper = new int[][]{
 {0},
 {glyphColor1},
 {glyphColor2}
 };

 if (searchSingle(GreyFrog,hopper)) {
 Ciphers.GreyFrog[1][column] = 0;
 Ciphers.GreyFrog[2][column] = 0;
 GreyFrogWorks = true;
 cipherCompatible = true;
 }
 if (Ciphers.BrownFrog[1][column]==vumarkGlyphColor1
 &&Ciphers.BrownFrog[2][column]==vumarkGlyphColor2) {
 Ciphers.BrownFrog[1][column] = 0;
 Ciphers.BrownFrog[2][column] = 0;
 BrownFrogWorks = true;
 cipherCompatible = true;
 }
 if (Ciphers.GreyBird[1][column]==vumarkGlyphColor1
 &&Ciphers.GreyBird[2][column]==vumarkGlyphColor2) {
 Ciphers.GreyBird[1][column] = 0;
 Ciphers.GreyBird[2][column] = 0;
 GreyBirdWorks = true;
 cipherCompatible = true;
 }
 if (Ciphers.BrownBird[1][column]==vumarkGlyphColor1
 &&Ciphers.BrownBird[2][column]==vumarkGlyphColor2) {
 Ciphers.BrownBird[1][column] = 0;
 Ciphers.BrownBird[2][column] = 0;
 BrownBirdWorks = true;
 cipherCompatible = true;
 }
 if (Ciphers.GreySnake[1][column]==vumarkGlyphColor1
 &&Ciphers.GreySnake[2][column]==vumarkGlyphColor2) {
 GreySnake[1][column] = 0;
 GreySnake[2][column] = 0;
 GreySnakeWorks = true;
 cipherCompatible = true;
 }
 if (Ciphers.BrownSnake[1][column]==vumarkGlyphColor1
 &&Ciphers.BrownSnake[2][column]==vumarkGlyphColor2) {
 Ciphers.BrownSnake[1][column] = 0;
 Ciphers.BrownSnake[2][column] = 0;
 BrownSnakeWorks = true;
 cipherCompatible = true;
 }
 }

 */

/**
 * STEP 2 select cipher for which hopper load fits in
 *//*
    void selectCipher3glyph(int[][] hopper) {
        cipherCompatible = false;
        if (searchSingle(Ciphers.GreyFrog,hopper) && GreyFrogWorks) {
            selectedCipher = cipherType.GreyFrog;
            CurrentCipher = GreyFrog;
            cipherCompatible = true;
        }
        else if (searchSingle(Ciphers.BrownFrog,hopper) && BrownFrogWorks) {
            selectedCipher = cipherType.BrownFrog;
            CurrentCipher = BrownFrog;
            cipherCompatible = true;
        }
        else if (searchSingle(Ciphers.GreyBird,hopper) && GreyBirdWorks) {
            selectedCipher = cipherType.GreyBird;
            CurrentCipher = GreyBird;
            cipherCompatible = true;
        }
        else if (searchSingle(Ciphers.BrownBird,hopper) && BrownBirdWorks) {
            selectedCipher = cipherType.BrownBird;
            CurrentCipher = BrownBird;
            cipherCompatible = true;
        }
        else if (searchSingle(Ciphers.GreySnake,hopper) && GreySnakeWorks) {
            selectedCipher = cipherType.GreySnake;
            CurrentCipher = GreySnake;
            cipherCompatible = true;
        }
        else if (searchSingle(Ciphers.BrownSnake,hopper) && BrownSnakeWorks) {
            selectedCipher = cipherType.BrownSnake;
            CurrentCipher = BrownSnake;
            cipherCompatible = true;
        } else if (column==0) {
            selectedCipher = cipherType.Unknown;
            column = 2;
            height = 1;
            cipherCompatible = false;
        } else {
            selectedCipher = cipherType.Unknown;
            column = 0;
            height = 1;
            cipherCompatible = false;
        }

        CurrentCipher[height+1][column] = 0;
        CurrentCipher[height+2][column] = 0;

        if (cipherCompatible) {
            System.out.println("Selected Cipher: "+selectedCipher);
        } else {
            System.out.println("No Cipher Compatible, placed additional glyphs in "+column+" at "+height+" height");
        }

    }

    void followCipher5glyph(int[][] hopper) {
        switch (selectedCipher) {
            case GreyFrog:
                CurrentCipher = GreyFrog;
                cipherCompatible = searchSingle(GreyFrog,hopper);
                System.out.println("Compatible: "+cipherCompatible);
                break;
            case BrownFrog:
                CurrentCipher = BrownFrog;
                cipherCompatible = searchSingle(BrownFrog,hopper);
                System.out.println("Compatible: "+cipherCompatible);
                break;
            case GreyBird:
                CurrentCipher = GreyBird;
                cipherCompatible = searchSingle(GreyBird,hopper);
                System.out.println("Compatible: "+cipherCompatible);
                break;
            case BrownBird:
                CurrentCipher = BrownBird;
                cipherCompatible = searchSingle(BrownBird,hopper);
                System.out.println("Compatible: "+cipherCompatible);
                break;
            case GreySnake:
                CurrentCipher = GreySnake;
                cipherCompatible = searchSingle(GreySnake,hopper);
                System.out.println("Compatible: "+cipherCompatible);
                break;
            case BrownSnake:
                CurrentCipher = BrownSnake;
                cipherCompatible = searchSingle(BrownSnake,hopper);
                System.out.println("Compatible: "+cipherCompatible);
                break;
            case Unknown:
                System.out.println("NOT Compatible");
                break;
        }

        if (!cipherCompatible) {
            if ((CurrentCipher[1][0]!=0)) {
                column = 0;
            } else if ((CurrentCipher[1][1]!=0)) {
                column = 1;
            } else if ((CurrentCipher[1][2]!=0)) {
                column = 2;
            }
        }

    }*/