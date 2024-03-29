import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    static int[][] dp;
    static Item[] items;
    static int n;
    static int k;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        k = input[1];

        items = new Item[n];
        for (int i = 0; i < n; i++) {
            input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            items[i] = new Item(input);
        }

        dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (items[i - 1].w <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items[i - 1].w] + items[i - 1].v);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}

class Item {
    int w;
    int v;

    Item(int[] input) {
        this.w = input[0];
        this.v = input[1];
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", w, v);
    }
}