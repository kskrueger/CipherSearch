import java.util.ArrayList;
import java.util.List;

public class random {
    private static ArrayList<ArrayList<String>> test = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("(-180) % 360");
        System.out.println( (-180) % 360 );
        System.out.println();
        System.out.println("(-180 + 360) % 360");
        System.out.println( (-180 + 360) % 360 );

    }

    static void set () {

    }

    public static List<List<String>> transpose(ArrayList<ArrayList<String>> matrixIn) {
        List<List<String>> matrixOut = new ArrayList<List<String>>();
        if (!matrixIn.isEmpty()) {
            int noOfElementsInList = matrixIn.get(0).size();
            for (int i = 0; i < noOfElementsInList; i++) {
                List<String> col = new ArrayList<String>();
                for (List<String> row : matrixIn) {
                    col.add(row.get(i));
                }
                matrixOut.add(col);
            }
        }

        return matrixOut;
    }

}
