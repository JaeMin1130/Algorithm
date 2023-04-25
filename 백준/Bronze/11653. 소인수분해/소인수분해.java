import java.util.Scanner;

public class Main {
    public static void factorization() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int count = 0;
        int div = 2;
        int i = 1;

        while (num != 1) {

            if (div % i == 0)
                count++;

            if (count > 2) {
                div++;
                count = 0;

            } else if (count == 2) {
                if (num % div == 0) {
                    num /= div;
                    System.out.println(div);
                    count = 0;
                } else {
                    div++;
                    count = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        factorization();
    }
}