import java.util.Scanner;

class Main {
    static int[] memo = new int[1000001];

    static int cal(int n) {
        if (memo[n] != 0) {
            return memo[n];
        } else {
            if (n == 1) {
                memo[n] = 0;
                return memo[n];
            } else if (n == 2) {
                memo[n] = 1;
                return memo[n];
            } else if (n == 3) {
                memo[n] = 1;
                return memo[n];
            } else {
                if (n % 3 == 0 && n % 2 == 0) {
                    int a = 1 + cal(n / 3);
                    int b = 1 + cal(n / 2);
                    int c = 1 + cal(n - 1);
                    memo[n] = Math.min(Math.min(a, b), c);
                } else if (n % 3 == 0) {
                    memo[n] = Math.min(1 + cal(n / 3), 1 + cal(n - 1));
                } else if (n % 2 == 0) {
                    if ((n - 1) % 3 == 0) {
                        int a = 2 + cal((n - 1) / 3);
                        int b = 1 + cal(n / 2);
                        memo[n] = Math.min(a, b);
                    } else {
                        memo[n] = Math.min(1 + cal(n / 2), 1 + cal(n - 1));
                    }
                } else {
                    memo[n] = 1 + cal(n - 1);
                }
                return memo[n];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(cal(N));
        scanner.close();
    }
}