import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] stairs;
    static int[][] memo;

    static int upStairs(int idx, int seq) {
        if (memo[idx][seq] != 0) {
            return memo[idx][seq];
        } else {
            if (idx == N) {
                memo[idx][seq] = stairs[idx];
                return memo[idx][seq];
            } else if (idx == N - 1) {
                if (seq <= 1) {
                    memo[idx][seq] = stairs[idx] + upStairs(idx + 1, seq + 1);
                    return memo[idx][seq];
                } else {
                    return 0;
                }
            } else if (idx == N - 2) {
                if (seq == 0) {
                    int step1 = upStairs(idx + 1, seq + 1);
                    int step2 = upStairs(idx + 2, 1);
                    memo[idx][seq] = stairs[idx] + Math.max(step1, step2);
                    return memo[idx][seq];
                } else {
                    memo[idx][seq] = stairs[idx] + upStairs(idx + 2, 1);
                    return memo[idx][seq];
                }
            } else {
                if (seq == 2) {
                    memo[idx][seq] = stairs[idx] + upStairs(idx + 2, 1);
                    return memo[idx][seq];
                } else {
                    int step1 = upStairs(idx + 1, seq + 1);
                    int step2 = upStairs(idx + 2, 1);
                    memo[idx][seq] = stairs[idx] + Math.max(step1, step2);
                    return memo[idx][seq];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        stairs = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        memo = new int[N + 1][3];

        System.out.println(upStairs(0, 0));
    }
}