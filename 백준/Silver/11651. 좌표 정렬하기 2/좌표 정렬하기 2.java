import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.stream.Stream;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int compare(Point p) {
        if (this.y == p.y) {
            return this.x - p.x;
        }
        return this.y - p.y;
    }

    static String toString(Point p) {
        return String.format("%s %s", p.x, p.y);
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Point> q = new PriorityQueue<>((p1, p2) -> p1.compare(p2));

        for (int i = 0; i < N; i++) {
            int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            q.add(new Point(input[0], input[1]));
        }

        while (!q.isEmpty()) {
            bw.write(Point.toString(q.poll()) + "\n");
        }
        bw.flush();
        bw.close();
    }
}