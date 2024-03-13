import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static ArrayList<Point> homes;
    static ArrayList<Point> chickens;
    static ArrayList<int[]> selectedChickenIdxList;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        int m = Integer.parseInt(input.nextToken());

        int[][] city = new int[n + 1][n + 1];
        for (int i = 1; i < city.length; i++) {
            int[] line = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < line.length; j++) {
                city[i][j + 1] = line[j];
            }
        }

        homes = selectPoints(city, 1);
        chickens = selectPoints(city, 2);
        selectedChickenIdxList = new ArrayList<>();
        getPermutation(0, 0, new int[m], selectedChickenIdxList);

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int[] chickenIdx : selectedChickenIdxList) {
            q.add(calChickenDistance(chickenIdx));
        }

        System.out.println(q.peek());
    }

    static int calChickenDistance(int[] chickenIdx) {
        int sum = 0;
        for (Point p1 : homes) {
            int minVal = 99;
            for (int idx : chickenIdx) {
                Point p2 = chickens.get(idx);
                int val = calDistance(p1, p2);
                if (val < minVal) {
                    minVal = val;
                }
            }
            sum += minVal;
        }
        return sum;
    }

    static void getPermutation(int idx, int num, int[] arr, ArrayList<int[]> selectedChickenIdxList) {
        if (idx == arr.length) {
            selectedChickenIdxList.add(arr);
        } else {
            for (int i = num; i < chickens.size(); i++) {
                arr[idx] = i;
                getPermutation(idx + 1, i + 1, arr.clone(), selectedChickenIdxList);
            }
        }
    }

    static ArrayList<Point> selectPoints(int[][] city, int target) {
        ArrayList<Point> chickens = new ArrayList<>();
        for (int i = 0; i < city.length; i++) {
            for (int j = 0; j < city.length; j++) {
                if (city[i][j] == target) {
                    chickens.add(new Point(i, j));
                }
                ;
            }
        }
        return chickens;
    }

    static int calDistance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", x, y);
    }
}