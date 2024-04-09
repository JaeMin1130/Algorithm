import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Stream;

public class Main {
    static int n;
    static int[][] room;
    // 0: 가로, 1: 세로, 2: 대각선
    static Map<Integer, int[]> dirMap = new HashMap<>();
    static int[][] dirIdxArr = { { 0, 2 }, { 1, 2 }, { 0, 1, 2 } };
    // new int[]{{x, y}, dirIdx}
    static Queue<int[][]> q = new LinkedList<>();
    static int count;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        room = new int[n][n];
        for (int i = 0; i < room.length; i++) {
            room[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        if(room[n-1][n-1] == 1) {
            System.out.println(count);
            return;
        }
        
        dirMap.put(0, new int[] { 0, 1 });
        dirMap.put(1, new int[] { 1, 0 });
        dirMap.put(2, new int[] { 1, 1 });

        q.add(new int[][] { { 0, 1 }, dirIdxArr[0] });
        bfs();

        System.out.println(count);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[][] curLoc = q.poll();
            int[] locArr = curLoc[0];
            int[] dirIdx = curLoc[1];
            for (int i : dirIdx) {
                int[] curDir = dirMap.get(i);
                int nx = locArr[0] + curDir[0];
                int ny = locArr[1] + curDir[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (room[nx][ny] == 1) continue;
                if (i == 2 && (room[nx][ny-1] == 1 || room[nx-1][ny] == 1)) continue;
                if (nx == n - 1 && ny == n - 1) {
                    count++;
                    continue;
                }
                q.add(new int[][] { { nx, ny }, dirIdxArr[i] });
            }
        }
    }
}