import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Integer, Integer> answer = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            paper[i] = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).mapToInt(Integer::intValue)
                    .toArray();
        }
        answer.put(-1, 0);
        answer.put(0, 0);
        answer.put(1, 0);

        checkPaper(N, 0, 0, paper);

        System.out.println(answer.get(-1));
        System.out.println(answer.get(0));
        System.out.println(answer.get(1));
    }

    static void checkPaper(int N, int row, int col, int[][] paper) {
        if (isUniform(N, row, col, paper)) {
            answer.put(paper[row][col], answer.get(paper[row][col]) + 1);
        } else {
            int newN = N / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    checkPaper(newN, row + i * newN, col + j * newN, paper);
                }
            }
        }
    }

    static boolean isUniform(int N, int row, int col, int[][] paper) {
        int num = paper[row][col];
        for (int i = row; i < row + N; i++) {
            for (int j = col; j < col + N; j++) {
                if (paper[i][j] != num) {
                    return false;
                }
            }
        }
        return true;
    }
}