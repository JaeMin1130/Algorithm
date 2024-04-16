import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] board = new String[n][n];
        for (int i = 0; i < board.length; i++) {
            board[i] = br.readLine().split("");
        }

        int rowCount = 0;
        int colCount = 0;
        int[] answer = new int[2];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j].equals(".")) rowCount++;
                if(board[j][i].equals(".")) colCount++;

                if(board[i][j].equals("X") || j == n - 1){
                    if(rowCount >= 2) answer[0]++;
                    rowCount = 0;
                } 
                if(board[j][i].equals("X") || j == n - 1){
                    if(colCount >= 2) answer[1]++;
                    colCount = 0;
                } 
            }
        }

        System.out.printf("%s %s", answer[0], answer[1]);
    }
}