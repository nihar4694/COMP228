import java.util.Random;

public class Lotto {
    int[] numbers;

    public Lotto() {
        numbers = new int[3];
        Random rand = new Random();

        for (int i = 0; i < 3; i++) {
            numbers[i] = rand.nextInt(9) + 1;
        }
    }

    public int[] getNumbers() {
        return numbers;
    }

    public int getSum() {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}
