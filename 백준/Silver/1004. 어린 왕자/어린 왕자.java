import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static boolean check(String[] circle, Point p) throws IOException {
        double leftX = Math.pow(p.x - Integer.parseInt(circle[0]), 2);
        double leftY = Math.pow(p.y - Integer.parseInt(circle[1]), 2);
        double right = Math.pow(Integer.parseInt(circle[2]), 2);
        if (leftX + leftY < right) {
            return true;
        } else
            return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            Point start = new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            Point end = new Point(Integer.parseInt(input[2]), Integer.parseInt(input[3]));
            int num = Integer.parseInt(br.readLine());

            for (int j = 0; j < num; j++) {
                String[] circle = br.readLine().split(" ");
                if (check(circle, start) ^ check(circle, end))
                    count += 1;
            }
            System.out.println(count);
            count = 0;
        }
    }
}