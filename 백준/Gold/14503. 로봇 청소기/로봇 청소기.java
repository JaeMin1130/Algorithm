import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input1 = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(input1.nextToken());
        int col = Integer.parseInt(input1.nextToken());

        StringTokenizer input2 = new StringTokenizer(br.readLine());
        int[] curPoint = { Integer.parseInt(input2.nextToken()), Integer.parseInt(input2.nextToken()) };
        int curDir = Integer.parseInt(input2.nextToken());

        int[][] room = new int[row][col];
        for (int i = 0; i < room.length; i++) {
            room[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int count = 0;
        boolean canBack = true;
        while (canBack) {
            // 현재 칸이 청소 가능하면 청소
            if (room[curPoint[0]][curPoint[1]] == 0) {
                room[curPoint[0]][curPoint[1]] = 2;
                count++;
            }

            // 주변 4칸 중 청소 가능한 곳이 있는지 검사
            boolean isPresent = false;
            for (int[] dir : directions) {
                int nx = curPoint[0] + dir[0];
                int ny = curPoint[1] + dir[1];
                if (room[nx][ny] == 0) {
                    isPresent = true;
                    break;
                }
            }

            // 주변 4칸 중 청소 가능한 곳이 없으면, 후진 가능 체크 후 후진 or 종료
            if (!isPresent) {
                int backDir = (curDir + 2) % 4;
                int bx = curPoint[0] + directions[backDir][0];
                int by = curPoint[1] + directions[backDir][1];

                if (room[bx][by] == 1) { // 후진 불가능 -> 종료
                    System.out.println(count);
                    canBack = false;
                } else { // 후진 가능 -> 후진
                    curPoint = new int[] { bx, by };
                }
            }

            // 주변 4칸 중 청소 가능한 곳이 있으면 반시계 방향으로 돌고, 앞 칸이 청소 가능하면 직진
            if (isPresent) {
                while (true) {
                    curDir = (curDir + 3) % 4;
                    int nx = curPoint[0] + directions[curDir][0];
                    int ny = curPoint[1] + directions[curDir][1];
                    if (room[nx][ny] == 0) {
                        curPoint = new int[] { nx, ny };
                        break;
                    }
                }
            }
        }
    }
}