import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] ableMap = new char[N][N];
        char[][] disableMap = new char[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                char color = input.charAt(j);
                ableMap[i][j] = color;
                if (color == 'G') {
                    disableMap[i][j] = 'R';
                } else {
                    disableMap[i][j] = color;
                }
            }
        }
        Map<Character, Integer> rgb = new HashMap<>();
        rgb.put('R', 0);
        rgb.put('G', 0);
        rgb.put('B', 0);
        
        bfs(N, ableMap, rgb);
        int able = rgb.get('R') + rgb.get('G') + rgb.get('B');

        rgb.put('R', 0);
        rgb.put('B', 0);

        bfs(N, disableMap, rgb);
        int disable = rgb.get('R') + rgb.get('B');
        System.out.println(able + " " + disable);
    }

    static void bfs(int N, char[][] map, Map<Character, Integer> rgb) {
        int[] dx = new int[] { -1, 0, 1, 0 };
        int[] dy = new int[] { 0, 1, 0, -1 };
        boolean[][] isVisited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j]) {
                    q.add(new int[] { i, j });
                    isVisited[i][j] = true;
                    char color = map[i][j];
                    int count = rgb.get(color);
                    rgb.put(color, ++count);
                }
                while (!q.isEmpty()) {
                    int[] point = q.poll();
                    char color = map[point[0]][point[1]];
                    for (int k = 0; k < 4; k++) {
                        int nextX = point[0] + dx[k];
                        int nextY = point[1] + dy[k];
                        if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                            if (map[nextX][nextY] == color && !isVisited[nextX][nextY]) {
                                q.add(new int[] { nextX, nextY });
                                isVisited[nextX][nextY] = true;
                            }
                        }
                    }
                }
            }
        }
    }
}