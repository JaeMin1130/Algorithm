import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int row;
    static int col;
    static int[][] maze;
    static boolean[][] isVisited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        row = Integer.parseInt(input.nextToken());
        col = Integer.parseInt(input.nextToken());

        maze = new int[row][col];
        isVisited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < col; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        int answer = bfs();
        System.out.println(answer);
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1}); 

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int steps = current[2];

            if (x == row - 1 && y == col - 1) {
                return steps;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && nx < row && ny >= 0 && ny < col
                        && maze[nx][ny] == 1 && !isVisited[nx][ny]) {
                    queue.offer(new int[]{nx, ny, steps + 1});
                    isVisited[nx][ny] = true;
                }
            }
        }

        return -1; 
    }
}