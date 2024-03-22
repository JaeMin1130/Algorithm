import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    static Queue<int[]> dirQ = new LinkedList<>();
    static Queue<int[]> tailQ = new LinkedList<>();
    static int n;
    static int[][] board;
    static Worm worm = new Worm(new int[] { 0, 0 }, new int[] { 0, 0 });
    static int temp = -1;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            board[input[0] - 1][input[1] - 1] = 7;
        }
        int x = Integer.parseInt(br.readLine());
        for (int i = 0; i < x; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(input.nextToken());
            int turn = input.nextToken().equals("D") ? 1 : -1;
            dirQ.add(new int[] { time, turn });
        }

        int dirIdx = 0;
        int count = 0;
        System.out.println(move(dirIdx, count));
    }

    static int move(int dirIdx, int count) {
        int[] nextDir = dirQ.peek();
        int changeTime = nextDir[0];
        tailQ.add(new int[]{0, 0});
        board[0][0] = 1;

        while (true) {
            if (count == changeTime) {
                dirIdx += nextDir[1];
                
                if (dirIdx == -1) dirIdx = 3;
                if (dirIdx == 4) dirIdx = 0;
                
                dirQ.poll();
                if(!dirQ.isEmpty()){
                    nextDir = dirQ.peek();
                    changeTime = nextDir[0];
                }
            }
            
            int nx = worm.head[0] + directions[dirIdx][0];
            int ny = worm.head[1] + directions[dirIdx][1];
            
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) return count + 1;
            if (board[nx][ny] == 1) return count + 1;
            
            if (board[nx][ny] != 7) {
                int[] tail = tailQ.poll();
                board[tail[0]][tail[1]] = 0;
            }
            
            board[nx][ny] = 1;
            tailQ.add(new int[]{nx, ny});
            
            worm.head[0] = nx;
            worm.head[1] = ny;
            
            
            count++;
        }
    }

    static void printBoard(int count) {
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println(count);
        if(temp >= 12){
            System.out.println(dirQ.size());
        }
        System.out.println("\n");

    }
}

class Worm {
    int[] head;
    int[] tail;

    Worm(int[] head, int[] tail) {
        this.head = head;
        this.tail = tail;
    }
}