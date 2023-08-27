import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        boolean[][] isVisited = new boolean[N][N];
        int[][] direction = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<Integer> result = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j] && map[i][j] != 0) {
                    isVisited[i][j] = true;
                    q.add(new int[] { i, j });
                    int count = 1;
                    while (!q.isEmpty()) {
                        int[] curLoc = q.poll();
                        for (int[] dir : direction) {
                            int x = curLoc[0] + dir[0];
                            int y = curLoc[1] + dir[1];
                            if (x >= 0 && x < N && y >= 0 && y < N && !isVisited[x][y]) {
                                if (map[x][y] == 1) {
                                    q.add(new int[] { x, y });
                                    count++;
                                }
                                isVisited[x][y] = true;
                            }
                        }
                    }
                    result.add(count);
                }
            }
        }
        System.out.println(result.size());
        while (!result.isEmpty()) {
            System.out.println(result.poll());
        }
    }
}