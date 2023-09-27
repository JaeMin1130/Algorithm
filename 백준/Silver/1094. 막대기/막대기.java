import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        int[] sticks = new int[] { 64, 32, 16, 8, 4, 2, 1 };
        int count = 0;
        int sum = 0;
        for (int i = 0; i < sticks.length; i++) {
            sum += sticks[i];
            if (sum > X) {
                sum -= sticks[i];
            } else {
                count++;
            }
        }
        System.out.println(count);
        scanner.close();
    }
}