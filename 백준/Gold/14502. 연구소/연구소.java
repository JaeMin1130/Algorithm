import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static int row;
    static int col;
    static int[][] lab;
    static Queue<int[][]> labList = new LinkedList<>();
    static List<int[]> viruses = new ArrayList<>();
    static boolean[][] settable;
    static boolean[][] isVisited;
    static int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    static int count = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input1 = new StringTokenizer(br.readLine());
        row = Integer.parseInt(input1.nextToken());
        col = Integer.parseInt(input1.nextToken());

        lab = new int[row][col];
        settable = new boolean[row][col];
        isVisited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            int[] input2 = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < col; j++) {
                if (input2[j] == 0) {
                    settable[i][j] = true;
                } else {
                    isVisited[i][j] = true;
                }
                if (input2[j] == 2) {
                    viruses.add(new int[] { i, j });
                }
                lab[i][j] = input2[j];
            }
        }

        setWall(0, 0, 0, lab);

        int max = 0;
        while (!labList.isEmpty()) {
            int[][] curLab = labList.poll();
            boolean[][] isVisitedCopy = new boolean[row][col];
            for (int i = 0; i < row; i++) {
                isVisitedCopy[i] = isVisited[i].clone();
            }
            bfs(curLab, isVisitedCopy);
            int count = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (curLab[i][j] == 0)
                        count++;
                }
            }
            max = Math.max(count, max);
        }
        System.out.println(max);
    }

    static void setWall(int startX, int startY, int count, int[][] tempLab) {
        if (count == 3) {
            labList.add(tempLab);
        } else {
            for (int i = startX; i < row; i++) {
                for (int j = startY; j < col; j++) {
                    if (settable[i][j]) {
                        int[][] newLab = new int[row][col];
                        for (int k = 0; k < newLab.length; k++) {
                            newLab[k] = tempLab[k].clone();
                        }
                        newLab[i][j] = 3;
                        if (j == col - 1) {
                            setWall(i + 1, 0, count + 1, newLab);
                        } else {
                            setWall(i, j + 1, count + 1, newLab);
                        }
                    }
                }
                startY = 0;
            }
        }
    }

    static void bfs(int[][] curLab, boolean[][] isVisited) {
        Queue<int[]> q = new LinkedList<>();
        for (int[] virus : viruses) {
            q.add(virus);
        }
        while (!q.isEmpty()) {
            int[] curLoc = q.poll();
            for (int[] dir : directions) {
                int nx = curLoc[0] + dir[0];
                int ny = curLoc[1] + dir[1];
                if (nx < 0 || nx >= row || ny < 0 || ny >= col) continue;
                if (isVisited[nx][ny]) continue;
                if (curLab[nx][ny] != 0) continue;
                q.add(new int[] { nx, ny });
                isVisited[nx][ny] = true;
                curLab[nx][ny] = 2;
            }
        }
    }

    static void printLab(int[][] target) {
        for (int i = 0; i < target.length; i++) {
            System.out.println(Arrays.toString(target[i]));
        }
        System.out.println("\n");
    }
}