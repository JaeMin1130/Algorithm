import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer size = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(size.nextToken());
        int col = Integer.parseInt(size.nextToken());
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            arr[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x1 = input[0] - 1;
            int y1 = input[1] - 1;
            int x2 = input[2] - 1;
            int y2 = input[3] - 1;
            int sum = 0;
            for (int j = x1; j <= x2; j++) {
                for (int j2 = y1; j2 <= y2; j2++) {
                    sum += arr[j][j2];
                }
            }
            System.out.println(sum);
        }
    }
}