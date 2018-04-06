public class Main {

    static int count = 0;

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        stats();
    }

    public static void stats() {
        for (int i = 1; i <= 6; i++) {
            for (int i2 = 1; i2 <= 6; i2++) {
                System.out.println("Count "+count+": "+i+", "+i2);
                count++;
            }
        }

        System.out.println("Total: "+count);
    }
}