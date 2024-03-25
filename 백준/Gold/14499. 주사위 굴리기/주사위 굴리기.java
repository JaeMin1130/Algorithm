import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;

public class Main {
    static int row;
    static int col;
    static int x;
    static int y;
    static int[][] board;
    static int[][] directions = { {}, { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
    static int[] curLoc;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        row = input[0];
        col = input[1];
        x = input[2];
        y = input[3];
        int k = input[4];

        curLoc = new int[]{x, y};
        board = new int[row][col];
        for (int i = 0; i < row; i++) {
            board[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[] dice = new int[6];
        int[] orders = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < k; i++) {
            int dir = orders[i];

            int nx = curLoc[0] + directions[dir][0];
            int ny = curLoc[1] + directions[dir][1];
            
            if (nx < 0 || nx >= row || ny < 0 || ny >= col) continue;
            curLoc = new int[] { nx, ny };

            dice = roll(dir, dice);
            mark(dice, bw);
        }

        bw.flush();
        bw.close();
    }

    static int[] roll(int dir, int[] dice) {
        int[] newDice = dice.clone();
        switch (dir) {
            case 1:
                newDice[0] = dice[2];
                newDice[2] = dice[5];
                newDice[4] = dice[0];
                newDice[5] = dice[4];
                break;
            case 2:
                newDice[0] = dice[4];
                newDice[2] = dice[0];
                newDice[4] = dice[5];
                newDice[5] = dice[2];
                break;
            case 3:
                newDice[0] = dice[3];
                newDice[1] = dice[0];
                newDice[3] = dice[5];
                newDice[5] = dice[1];
                break;
            case 4:
                newDice[0] = dice[1];
                newDice[1] = dice[5];
                newDice[3] = dice[0];
                newDice[5] = dice[3];
                break;
        }
        return newDice;
    }

    static void mark(int[] dice, BufferedWriter bw) throws IOException {
        if (board[curLoc[0]][curLoc[1]] == 0) {
            board[curLoc[0]][curLoc[1]] = dice[5];

        } else {
            dice[5] = board[curLoc[0]][curLoc[1]];
            board[curLoc[0]][curLoc[1]] = 0;
        }

        bw.write(dice[0] + "\n");
    }
}