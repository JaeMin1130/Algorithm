import java.util.Scanner;

public class Main {
    public static void divisor() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int divisorArr[] = new int[num];
        int max = 2;
        int min = 1000000;

        for (int i = 0; i < num; i++) {
            divisorArr[i] = scanner.nextInt();
            if (divisorArr[i] > max) {
                max = divisorArr[i];
            }
            if (divisorArr[i] < min) {
                min = divisorArr[i];
            }
        }
        System.out.println(max * min);
    }

    public static void main(String[] args) {
        divisor();
    }
}