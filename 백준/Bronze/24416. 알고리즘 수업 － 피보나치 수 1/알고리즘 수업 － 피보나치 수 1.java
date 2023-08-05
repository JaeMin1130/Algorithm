import java.util.Scanner;

class Main {
    static int[] memo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        memo = new int[41];
        System.out.printf("%d %d", fib(N), N - 2);
        scanner.close();
    }

    static int fib(int n) {
        if (memo[n] != 0) {
            return memo[n];
        } else {
            if (n == 1 || n == 2) {
                memo[n] = 1;
                return memo[n];
            } else {
                memo[n] = fib(n - 1) + fib(n - 2);
                return memo[n];
            }
        }
    }
}