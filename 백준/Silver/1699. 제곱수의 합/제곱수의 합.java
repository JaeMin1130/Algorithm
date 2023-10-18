import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] memo = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int count = dp(input);
        System.out.println(count);
    }

    static int dp(int input) {
        if (memo[input] == 0) {
            if (input == 0 || input == 1) {
                memo[input] = input;
            } else {
                int minCount = input;
                int startNum = (int) Math.sqrt(input);
                for (int i = startNum; i >= 1; i--) {
                    int value = i * i;
                    int subproblem = dp(input - value);
                    minCount = Math.min(minCount, 1 + subproblem);
                }
                memo[input] = minCount;
            }
        }
        return memo[input];
    }
}