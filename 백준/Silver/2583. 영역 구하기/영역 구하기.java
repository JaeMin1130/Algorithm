import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] board = new int[row][col];
        for (int i = 0; i < k; i++) {
            int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = input[1]; j < input[3]; j++) {
                for (int j2 = input[0]; j2 < input[2]; j2++) {
                    board[j][j2] = 8;
                }
            }
        }

        int count = 0;
        int area = 1;
        PriorityQueue<Integer> areas = new PriorityQueue<>();
        boolean[][] isVisited = new boolean[row][col];
        Queue<int[]> q = new LinkedList<>();
        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (isVisited[i][j]) continue;
                if (board[i][j] != 0) continue;

                q.add(new int[] { i, j, count++, area });
                board[i][j] = count;
                isVisited[i][j] = true;
                while (!q.isEmpty()) {
                    int[] curLoc = q.poll();
                    for (int[] dir : directions) {
                        int nx = curLoc[0] + dir[0];
                        int ny = curLoc[1] + dir[1];

                        if (nx < 0 || nx >= row || ny < 0 || ny >= col) continue;
                        if(isVisited[nx][ny]) continue;
                        if (board[nx][ny] == 8) continue;

                        q.add(new int[] { nx, ny, count, area++ });
                        board[nx][ny] = count;
                        isVisited[nx][ny] = true;
                    }
                    if (q.isEmpty()) {
                        areas.add(area);
                        area = 1;
                    }
                }
            }
        }

        System.out.println(count);
        while(!areas.isEmpty()){
            System.out.print(areas.poll() + " ");
        }
    }
}