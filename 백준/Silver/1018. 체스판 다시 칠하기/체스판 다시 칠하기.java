import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(input.nextToken());
        int col = Integer.parseInt(input.nextToken());
        char[][] board = new char[row][col];

        char[][] bstart = new char[8][8];
        char[][] wstart = new char[8][8];
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                bstart[i] = new char[] { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' };
                wstart[i] = new char[] { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' };
            } else {
                bstart[i] = new char[] { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' };
                wstart[i] = new char[] { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' };
            }
        }
        for (int i = 0; i < row; i++) {
            board[i] = br.readLine().toCharArray();
        }
        PriorityQueue<Integer> result = new PriorityQueue<>();
        int x = 0;
        while (x + 8 <= row) {
            int y = 0;
            while (y + 8 <= col) {
                int[] count = new int[2];
                for (int i = 0; i < 2; i++) {
                    for (int j = x; j < x + 8; j++) {
                        for (int k = y; k < y + 8; k++) {
                            if (i == 0) {
                                if (bstart[j - x][k - y] != board[j][k]) {
                                    count[i]++;
                                }
                            } else {
                                if (wstart[j - x][k - y] != board[j][k]) {
                                    count[i]++;
                                }
                            }
                        }
                    }
                }
                result.add(Math.min(count[0], count[1]));
                y++;
            }
            x++;
        }
        System.out.println(result.peek());
    }
}