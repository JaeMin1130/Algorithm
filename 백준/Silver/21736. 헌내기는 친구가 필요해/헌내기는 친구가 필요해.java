import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Direction {
    int x;
    int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    static char[][] campus;
    static boolean[][] visited;
    static Direction[] dir = { new Direction(-1, 0), new Direction(0, 1), new Direction(1, 0), new Direction(0, -1) };
    static int[] idx;
    static int count = 0;

    static void move(int[] start, char[][] campus) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (campus[x][y] == 'P') {
                count++;
            }

            for (Direction d : dir) {
                int newX = x + d.x;
                int newY = y + d.y;

                if (newX >= 0 && newX < campus.length && newY >= 0 && newY < campus[0].length
                        && !visited[newX][newY] && campus[newX][newY] != 'X') {
                    visited[newX][newY] = true;
                    queue.offer(new int[] { newX, newY });
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] rowcol = parseToIntArray(br.readLine().split(" "));

        campus = new char[rowcol[0]][rowcol[1]];
        visited = new boolean[rowcol[0]][rowcol[1]];

        for (int i = 0; i < campus.length; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == 'I') {
                    idx = new int[] { i, j };
                    visited[i][j] = true;
                }
                campus[i][j] = arr[j];
            }
        }

        move(idx, campus);
        System.out.println(count == 0 ? "TT" : count);
    }

    private static int[] parseToIntArray(String[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = Integer.parseInt(arr[i]);
        }
        return result;
    }
}
