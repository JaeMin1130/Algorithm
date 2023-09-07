import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class Main {
    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        while (true) {
            String input = br.readLine();
            if (input.equals("0 0")) {
                break;
            }

            String[] inputParts = input.split(" ");
            int col = Integer.parseInt(inputParts[0]);
            int row = Integer.parseInt(inputParts[1]);

            int[][] map = new int[row][col];
            int[][] directions = new int[][] { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 },
                    { -1, -1 } };
            boolean[][] isVisited = new boolean[row][col];
            Queue<Point> singleIsland = new LinkedList<>();
            for (int i = 0; i < row; i++) {
                map[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            }

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    int point = map[i][j];
                    if (!isVisited[i][j] && point == 1) {
                        isVisited[i][j] = true;
                        singleIsland.add(new Point(i, j));
                        while (!singleIsland.isEmpty()) {
                            Point p = singleIsland.poll();
                            for (int[] direction : directions) {
                                int nextX = p.x + direction[0];
                                int nextY = p.y + direction[1];
                                if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col) {
                                    if (!isVisited[nextX][nextY] && map[nextX][nextY] == 1) {
                                        isVisited[nextX][nextY] = true;
                                        singleIsland.add(new Point(nextX, nextY));
                                    }
                                }
                            }
                        }
                        count++;
                    }
                }
            }
            System.out.println(count);
            count = 0;
        }
    }
}