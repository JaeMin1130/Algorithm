import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;

public class Main {
    static final int INF = 987654321;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] costs = new int[n + 1][n + 1];

        for (int i = 0; i < costs.length; i++) {
            for (int j = 0; j < costs.length; j++) {
                costs[i][j] = i == j ? 0 : INF;
            }
        }

        int b = Integer.parseInt(br.readLine());
        for (int i = 0; i < b; i++) {
            int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = input[0];
            int y = input[1];
            int val = input[2];

            costs[x][y] = Math.min(costs[x][y], val);
        }

        floyd(costs);
        printCosts(costs);

    }

    static void floyd(int[][] costs) {
        for (int mid = 1; mid < costs.length; mid++) {
            for (int j = 1; j < costs.length; j++) {
                for (int k = 1; k < costs.length; k++) {
                    if (j == k || mid == j || mid == k) continue;

                    int newVal = costs[j][mid] + costs[mid][k];
                    if (costs[j][k] > newVal) {
                        costs[j][k] = newVal;
                    }
                }
            }
        }
    }

    static void printCosts(int[][] costs) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < costs.length; i++) {
            for (int j = 1; j < costs.length; j++) {
                bw.write(costs[i][j] == INF? 0 + " " : costs[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}