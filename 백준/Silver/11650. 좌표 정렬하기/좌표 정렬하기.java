import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

class Point {
    int X;
    int Y;

    Point(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public String toString() {
        return (X + " " + Y);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        Point[] arr = new Point[num];
        for (int i = 0; i < arr.length; i++) {
            String[] list = br.readLine().split(" ");
            arr[i] = new Point(Integer.parseInt(list[0]), Integer.parseInt(list[1]));
        }

        Comparator<Point> comparator = new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.X == p2.X) {
                    return Integer.compare(p1.Y, p2.Y);
                } else {
                    return Integer.compare(p1.X, p2.X);
                }
            }
        };
        Arrays.sort(arr, comparator);
        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i].toString() + "\n");
        }
        bw.close();
    }
}