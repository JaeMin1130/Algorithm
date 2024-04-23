import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] arr = new int[n + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = input[i - 1];
        }

        int[] dp = new int[n + 1];
        for (int i = 1; i < arr.length; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int j = i; j >= 1; j--) {
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
                dp[i] = Math.max(dp[i], max - min + dp[j - 1]);
            }
        }

        System.out.println(dp[n]);
    }
}