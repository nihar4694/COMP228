public class Main {

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int multiply(int a, int b, int c) {
        return a * b * c;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static void main(String[] args) {
        int result1 = multiply(5, 3);
        System.out.println("Multiplying two integers (5 * 3): " + result1);

        int result2 = multiply(2, 3, 4);
        System.out.println("Multiplying three integers (2 * 3 * 4): " + result2);

        double result3 = multiply(2.5, 4.5);
        System.out.println("Multiplying two doubles (2.5 * 4.5): " + result3);
    }
}
