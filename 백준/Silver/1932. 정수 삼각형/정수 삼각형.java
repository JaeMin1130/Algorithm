import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

class Main {
    static int N;
    static int[][] triangle;
    static int[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        triangle = new int[N][];
        memo = new int[N][N];
        for (int i = 0; i < N; i++) {
            int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            triangle[i] = input;
        }

        System.out.println(recur(0, 0));
    }

    static int recur(int x, int y) {
        if (x == N) {
            return 0;
        } else {
            if (memo[x][y] != 0) {
                return memo[x][y];
            } else {
                memo[x][y] = triangle[x][y] + Math.max(recur(x + 1, y), recur(x + 1, y + 1));
                return memo[x][y];
            }
        }
    }
}