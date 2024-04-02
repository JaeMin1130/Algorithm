import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n + 1][10];
        Arrays.fill(dp[1], 1);

        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                int temp = i;
                dp[i][j] += IntStream.rangeClosed(0, j).mapToLong((idx) -> dp[temp - 1][idx]).sum() % 10007;
            }
        }

        System.out.println(LongStream.of(dp[n]).sum() % 10007);
    }
}