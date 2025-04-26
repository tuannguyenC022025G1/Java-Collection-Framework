public class DemoDebug {
    public static void main(String[] args) {
        int[] numbers = {2, 5, 7, 10, 15};
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            int square = square(numbers[i]);
            sum += square;

            if (square % 2 == 0) {
                System.out.println(numbers[i] + " squared is even: " + square);
            } else {
                System.out.println(numbers[i] + " squared is odd: " + square);
            }
        }

        System.out.println("Total sum of squares = " + sum);
    }

    private static int square(int n) {
        return n * n;
    }
}
