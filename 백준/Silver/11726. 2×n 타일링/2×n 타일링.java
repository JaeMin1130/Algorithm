import java.util.Scanner;

public class Main {
    static int[] memo = new int[1001];

    static int arrange(int a) {
        if (a <= 2) {
            memo[a] = a;
            return memo[a];
        } else {
            if (memo[a] != 0) {
                return memo[a];
            } else {
                memo[a] = (arrange(a - 1) + arrange(a - 2)) % 10007;
                return memo[a];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(arrange(n));
        scanner.close();
    }
}