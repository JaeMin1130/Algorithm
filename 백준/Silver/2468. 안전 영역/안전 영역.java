import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        Set<Integer> heights = new HashSet<>(Arrays.asList(0));
        for (int i = 0; i < N; i++) {
            int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < input.length; j++) {
                int height = input[j];
                heights.add(height);
                map[i][j] = height;
            }
        }

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        int result = 1;
        Iterator<Integer> iter = heights.iterator();
        while (iter.hasNext()) {
            int height = iter.next();
            Queue<int[]> q = new LinkedList<>();
            boolean[][] isVisited = new boolean[N][N];
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!isVisited[i][j] && map[i][j] > height) {
                        q.add(new int[] { i, j });
                        isVisited[i][j] = true;
                        while (!q.isEmpty()) {
                            int[] point = q.poll();
                            for (int k = 0; k < 4; k++) {
                                int nextX = point[0] + dx[k];
                                int nextY = point[1] + dy[k];
                                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                                    int[] nextP = new int[] { nextX, nextY };
                                    if (!isVisited[nextP[0]][nextP[1]] && map[nextP[0]][nextP[1]] > height) {
                                        q.add(nextP);
                                        isVisited[nextP[0]][nextP[1]] = true;
                                    }
                                }
                            }
                        }
                        count++;
                    }
                }
            }
            if (result < count) {
                result = count;
            }
        }
        System.out.println(result);
    }
}
