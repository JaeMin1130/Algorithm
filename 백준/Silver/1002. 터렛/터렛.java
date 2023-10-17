import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    boolean equals(Point p) {
        if (this.x == p.x && this.y == p.y) {
            return true;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Point p1 = new Point(input[0], input[1]);
            Point p2 = new Point(input[3], input[4]);
            int r1 = input[2];
            int r2 = input[5];

            if (p1.equals(p2)) { // 두 점이 같을 때 -> 일치(-1) or 포함(0)
                if (r1 == r2) {
                    System.out.println(-1);
                } else {
                    System.out.println(0);
                }
            } else { // 두 점이 다를 때 -> 한 점이 다른 한 원 안에 위치 or 밖에 위치
                double r3 = Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
                int r4 = r1 + r2;
                if (r3 > r4) {
                    System.out.println(0);
                } else if (r3 == r4) {
                    System.out.println(1);
                } else {
                    double r5 = r3 + Math.min(r1, r2);
                    int r6 = Math.max(r1, r2);
                    if (r5 == r6) {
                        System.out.println(1);
                    } else if (r5 < r6) {
                        System.out.println(0);
                    } else {
                        System.out.println(2);
                    }
                }
            }
        }
    }
}