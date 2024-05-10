import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class Main {
    static int len;
    static int[][] board;
    static boolean[][] isVisited;
    static int[] departures;
    static int[] arrivals;
	static int[][] directions = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            len = Integer.parseInt(br.readLine());
            board = new int[len][len];
            isVisited = new boolean[len][len];
            
            departures = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arrivals = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{departures[0], departures[1], 0});
            isVisited[departures[0]][departures[1]] = true;

            answer = Integer.MAX_VALUE;
            bfs(q);

            bw.write(answer + "\n");
        }   
        bw.flush();
        bw.close();
    }

    static void bfs(Queue<int[]> q){
        while(!q.isEmpty()){
            int[] info = q.poll();
            int cx = info[0];
            int cy = info[1];
            int count = info[2];

            if(cx == arrivals[0] && cy == arrivals[1]){
                answer = Math.min(answer, count);
                break;
            }

            for(int[] dir : directions){
                int nx = cx + dir[0];
                int ny = cy + dir[1];
                if(nx < 0 || nx >= len || ny < 0 || ny >= len) continue;
                if(isVisited[nx][ny]) continue;

                q.add(new int[]{nx, ny, count + 1});
                isVisited[nx][ny] = true;
            }
        }
    }
}