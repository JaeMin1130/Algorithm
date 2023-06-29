import java.util.Scanner;

class Main {
    static int[] memo = new int[1001];

    static int tile(int n) {
        if (memo[n] != 0) {
            return memo[n];
        } else {
            if (n == 1) {
                memo[n] = 1;
                return memo[n];
            } else if (n == 2) {
                memo[n] = 3;
                return memo[n];
            } else {
                memo[n] = (tile(n - 2) * 2 + tile(n - 1)) % 10007;
                return memo[n];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(tile(n));
        scanner.close();
    }
}