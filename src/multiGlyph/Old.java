package multiGlyph;

public class Old {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0,0,0}, //fake bottom row to simulate ground level
                {1,1,2}, //1st row, left (0) to right (2)
                {1,2,2}, //2nd row
                {2,2,1}, //3rd row
                {2,1,1}  //top row of box
        };

        int[][] submatrix = new int[][]{
                {0}, //fake bottom glyph to simulate solid surface below
                {0}, //1st glyph intaked (bottom when placing)
                {0}  //2nd glyph (top when placing)
        };

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
                System.out.println("Found at: " + x + " " + y);
                break loopX;
            }
        System.out.println("Done");
    }

}
