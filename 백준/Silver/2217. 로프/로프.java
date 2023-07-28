import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> rope = new PriorityQueue<>();
        PriorityQueue<Integer> result = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < N; i++) {
            rope.add(Integer.parseInt(br.readLine()));
        }

        for (int i = N; i > 0; i--) {
            result.add(rope.poll() * i);
        }

        System.out.println(result.poll());
    }
}