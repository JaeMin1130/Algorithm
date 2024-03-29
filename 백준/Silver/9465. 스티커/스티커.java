import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] board = new int[2][n];
            for (int j = 0; j < board.length; j++) {
                board[j] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int[][] dp = new int[2][n];
            dp[0][0] = board[0][0];
            dp[1][0] = board[1][0];
            if(n != 1){
                dp[0][1] = board[1][0] + board[0][1];
                dp[1][1] = board[0][0] + board[1][1];
            }

            for (int k = 2; k < n; k++) {
                for (int j = 0; j < 2; j++) {
                    dp[j][k] = (j == 0 ? Math.max(dp[j + 1][k - 1], dp[j + 1][k - 2])
                            : Math.max(dp[j - 1][k - 1], dp[j - 1][k - 2]))
                            + board[j][k];
                }
            }

            System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
        }
    }
}