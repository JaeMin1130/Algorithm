import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer input = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(input.nextToken());
        int col = Integer.parseInt(input.nextToken());

        int[][] maze = new int[row][col];
        for (int i = 0; i < maze.length; i++) {
            maze[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] memo = new int[row][col];
        memo[0][0] = maze[0][0];
        for (int i = 1; i < col; i++) {
            memo[0][i] = memo[0][i - 1] + maze[0][i];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                memo[i][j] = j == 0 ? memo[i - 1][j] + maze[i][j]
                        : Math.max(memo[i][j - 1], Math.max(memo[i - 1][j], memo[i - 1][j - 1])) + maze[i][j];
            }
        }

        System.out.println(memo[row - 1][col - 1]);
    }
}