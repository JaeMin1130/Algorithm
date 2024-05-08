import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int row;
    static int col;
    static char[][] board;
    static boolean[] isAppeared = new boolean[26];
    static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int count = 0;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        board = new char[row][col];
        for (int i = 0; i < row; i++) {
            board[i] = br.readLine().toCharArray();
        }
        
        isAppeared[board[0][0] - 65] = true;

        dfs(new int[]{0, 0}, 1);
        System.out.println(count);
    }

    static void dfs(int[] curLoc, int value){
        for(int[] dir : directions){
            int nx = curLoc[0] + dir[0];
            int ny = curLoc[1] + dir[1];
            
            if(nx < 0 || nx >= row || ny < 0 || ny >= col) continue;
            if(isAppeared[board[nx][ny] - 'A']) continue;

            isAppeared[board[nx][ny] - 'A'] = true;
            dfs(new int[]{nx, ny}, value + 1);
            isAppeared[board[nx][ny] - 'A'] = false;
        }

        count = Math.max(count, value);
    }
}