import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class Main {
    static int[] input;
    static int row;
    static int col;
    static int time;
    static int[][] room;
    static int cleanerX = 51;
    static int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        row = input[0];
        col = input[1];
        time = input[2];

        room = new int[row][col];
        for (int i = 0; i < room.length; i++) {
            input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (input[0] == -1) {
                cleanerX = Math.min(i, cleanerX);
            }
            for (int j = 0; j < input.length; j++) {
                room[i][j] = input[j];
            }
        }

        // printRoom();

        for (int i = 0; i < time; i++) {
            // 미세먼지 확산
            spread();
            // 공기청정기 작동
            operateCleaner();
        }
        System.out.println(sumDust());
    }

    static void spread() {
        int[][] newRoom = cloneRoom();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int spreadAmount = room[i][j] / 5;
                int spreadCount = 0;
                for (int[] dir : directions) {
                    int nx = i + dir[0];
                    int ny = j + dir[1];

                    if (nx < 0 || nx >= row || ny < 0 || ny >= col) continue;
                    if (room[nx][ny] == -1) continue;

                    newRoom[nx][ny] += spreadAmount;
                    spreadCount++;
                }
                newRoom[i][j] -= spreadAmount * spreadCount;
            }
        }
        room = newRoom;
    }

    static void operateCleaner() {
        Queue<Integer> q = new LinkedList<>();
        // 위
        for (int i = cleanerX - 1; i > 0; i--) {
            q.add(room[i][0]);
        }
        for (int i = 0; i < col; i++) {
            q.add(room[0][i]);
        }
        for (int i = 1; i < cleanerX; i++) {
            q.add(room[i][col - 1]);
        }
        for (int i = col - 1; i >= 0; i--) {
            if (room[cleanerX][i] != -1) {
                q.add(room[cleanerX][i]);
            }
        }
        q.poll();
        q.add(0);
        for (int i = cleanerX - 1; i > 0; i--) {
            room[i][0] = q.poll();
        }
        for (int i = 0; i < col; i++) {
            room[0][i] = q.poll();
        }
        for (int i = 1; i < cleanerX; i++) {
            room[i][col - 1] = q.poll();
        }
        for (int i = col - 1; i > 0; i--) {
            room[cleanerX][i] = q.poll();
        }

        // 아래
        for (int i = cleanerX + 2; i < row - 1; i++) {
            q.add(room[i][0]);
        }
        for (int i = 0; i < col; i++) {
            q.add(room[row - 1][i]);
        }
        for (int i = row - 2; i > cleanerX + 1; i--) {
            q.add(room[i][col - 1]);
        }
        for (int i = col - 1; i >= 0; i--) {
            if (room[cleanerX + 1][i] != -1) {
                q.add(room[cleanerX + 1][i]);
            }
        }
        q.poll();
        q.add(0);
        for (int i = cleanerX + 2; i < row - 1; i++) {
            room[i][0] = q.poll();
        }
        for (int i = 0; i < col; i++) {
            room[row - 1][i] = q.poll();
        }
        for (int i = row - 2; i > cleanerX + 1; i--) {
            room[i][col - 1] = q.poll();
        }
        for (int i = col - 1; i > 0; i--) {
            room[cleanerX + 1][i] = q.poll();
        }
    }

    static int sumDust() {
        int sum = 0;
        for (int i = 0; i < room.length; i++) {
            sum += Arrays.stream(room[i]).sum();
        }
        return sum + 2;
    }

    static int[][] cloneRoom() {
        int[][] newRoom = new int[row][col];
        for (int i = 0; i < newRoom.length; i++) {
            newRoom[i] = room[i].clone();
        }
        return newRoom;
    }

    static void printRoom() {
        for (int i = 0; i < room.length; i++) {
            System.out.println(Arrays.toString(room[i]));
        }
        System.out.println("\n");
    }
}