import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] relations = new int[n + 1][n + 1];
        Queue<int[]> q = new LinkedList<>();

        while (true) {
            int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (input[0] == -1) break;

            relations[input[0]][input[1]] = 1;
            relations[input[1]][input[0]] = 1;
        }

        for (int i = 0; i < relations.length; i++) {
            for (int j = 0; j < relations.length; j++) {
                if (relations[i][j] == 1) {
                    // {targetRow, originalRow, depth}
                    q.add(new int[] { j, i, 2 });
                }
            }
            markRelation(relations, q);
        }

        int[] scores = new int[n + 1];
        scores[0] = 999;
        for (int i = 1; i < scores.length; i++) {
            scores[i] = IntStream.of(relations[i]).max().getAsInt();
        }

        int minScore = IntStream.of(scores).min().getAsInt();
        int[] candidates = IntStream.rangeClosed(1, n).filter(i -> scores[i] == minScore).toArray();

        System.out.println(minScore + " " + candidates.length);
        for (int i = 0; i < candidates.length; i++) {
            System.out.print(candidates[i] + " ");
        }
    }

    static void markRelation(int[][] relations, Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] info = q.poll();
            int targetRow = info[0];
            int originalRow = info[1];
            int depth = info[2];

            for (int j = 1; j < relations.length; j++) {
                if (j == targetRow || j == originalRow) continue;

                if (relations[targetRow][j] == 1) {
                    if (relations[originalRow][j] == 0) {
                        relations[originalRow][j] = depth;
                    }

                    for (int i = 1; i < relations.length; i++) {
                        if (i == targetRow || i == originalRow) continue;

                        if (relations[originalRow][i] == 0) {
                            q.add(new int[] { j, originalRow, depth + 1 });
                            break;
                        }
                    }
                }
            }
        }
    }
}