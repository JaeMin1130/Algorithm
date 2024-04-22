import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int[][] board = new int[8][8];
    static Map<String, int[]> map = new HashMap<>();
    static int[] curKing;
    static int[] curStone;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] king = st.nextToken().split("");
        curKing = new int[]{Integer.parseInt(king[1]) - 1, king[0].charAt(0) - 65};
        String[] stone = st.nextToken().split("");
        curStone = new int[]{Integer.parseInt(stone[1]) - 1, stone[0].charAt(0) - 65};
        int n = Integer.parseInt(st.nextToken());

        board[curKing[0]][curKing[1]] = 1;
        board[curStone[0]][curStone[1]] = 1;
        
        map.put("R", new int[] { 0, 1 });
        map.put("L", new int[] { 0, -1 });
        map.put("B", new int[] { -1, 0 });
        map.put("T", new int[] { 1, 0 });
        map.put("RT", new int[] { 1, 1 });
        map.put("LT", new int[] { 1, -1 });
        map.put("RB", new int[] { -1, 1 });
        map.put("LB", new int[] { -1, -1 });

        for (int i = 0; i < n; i++) {
            String order = br.readLine();
            move(map.get(order));
        }

        System.out.printf("%s%d", (char)(65 + curKing[1]), curKing[0] + 1);
        System.out.println();
        System.out.printf("%s%d", (char)(65 + curStone[1]), curStone[0] + 1);
    }

    static void move(int[] dir) {
        int nxKing = curKing[0] + dir[0];
        int nyKing = curKing[1] + dir[1];
        int nxStone = curStone[0] + dir[0];
        int nyStone = curStone[1] + dir[1];

        if(nxKing < 0 || nxKing >= 8 || nyKing < 0 || nyKing >= 8) return;
        if(board[nxKing][nyKing] == 1){
            if(nxStone < 0 || nxStone >= 8 || nyStone < 0 || nyStone >= 8) return;
            board[curStone[0]][curStone[1]] = 0;
            board[nxStone][nyStone] = 1;
            curStone = new int[]{nxStone, nyStone};
        } 

        board[curKing[0]][curKing[1]] = 0;
        board[nxKing][nyKing] = 1;
        curKing = new int[]{nxKing, nyKing};
    }
}