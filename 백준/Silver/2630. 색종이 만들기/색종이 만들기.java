import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

class Main {
    static int[][] board;
    static int[] count = new int[2];

    static void drawLine(int startNum, int[] idx, int len) {
        boolean flag = false;
        if (len == 1) {
            count[startNum]++;
            return;
        } else {
            for (int i = idx[0]; i < idx[0] + len; i++) {
                for (int j = idx[1]; j < idx[1] + len; j++) {
                    if (board[i][j] != startNum) {

                        int[] idx1 = { idx[0], idx[1] + len / 2 };
                        int[] idx2 = { idx[0] + len / 2, idx[1] };
                        int[] idx3 = { idx[0] + len / 2, idx[1] + len / 2 };

                        drawLine(startNum, idx, len / 2);
                        drawLine(board[idx1[0]][idx1[1]], idx1, len / 2);
                        drawLine(board[idx2[0]][idx2[1]], idx2, len / 2);
                        drawLine(board[idx3[0]][idx3[1]], idx3, len / 2);

                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            if (!flag) {
                count[startNum]++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < board.length; i++) {
            board[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int startNum = board[0][0];
        int[] idx = { 0, 0 };
        drawLine(startNum, idx, N);
        for (int i : count) {
            System.out.println(i);
        }
    }
}