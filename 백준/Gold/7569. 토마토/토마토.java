import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer boxSize = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(boxSize.nextToken());
        int row = Integer.parseInt(boxSize.nextToken());
        int height = Integer.parseInt(boxSize.nextToken());

        int[][][] boxes = new int[height][row][col];
        boolean[][][] isVisited = new boolean[height][row][col];
        Queue<int[]> q = new LinkedList<>();
        int count = 0; // 저장될 때 덜 익은 토마토 갯수
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < row; j++) {
                int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int k = 0; k < col; k++) {
                    boxes[i][j][k] = input[k];
                    if (input[k] == 1) {
                        q.add(new int[] { i, j, k, 0 });
                        isVisited[i][j][k] = true;
                    } else if (input[k] == 0) {
                        count++;
                    }
                }
            }
        }
        int day = 0;
        if (count == 0) { // 저장될 때부터 모든 토마토가 익어있는 상태
            System.out.println(0);
        } else {
            // 북, 동, 남, 서, 위, 아래 / {height, row, col}
            int[][] directions = { new int[] { 0, -1, 0 }, new int[] { 0, 0, 1 }, new int[] { 0, 1, 0 },
                    new int[] { 0, 0, -1 }, new int[] { -1, 0, 0 }, new int[] { 1, 0, 0 } };
            while (!q.isEmpty()) {
                int[] tomato = q.poll();
                day = tomato[3];
                for (int i = 0; i < 6; i++) {
                    int nextZ = directions[i][0] + tomato[0];
                    int nextX = directions[i][1] + tomato[1];
                    int nextY = directions[i][2] + tomato[2];
                    if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col && nextZ >= 0 && nextZ < height) {
                        if (!isVisited[nextZ][nextX][nextY] && boxes[nextZ][nextX][nextY] == 0) {
                            q.add(new int[] { nextZ, nextX, nextY, day + 1 });
                            isVisited[nextZ][nextX][nextY] = true;
                            count--;
                        }
                    }
                }
            }
            if (count == 0) {
                System.out.println(day);
            } else { // 토마토가 모두 익지는 못하는 상황
                System.out.println(-1);
            }
        }
    }
}