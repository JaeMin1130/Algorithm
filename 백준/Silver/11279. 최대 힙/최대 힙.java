import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {
    static PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int key = Integer.parseInt(br.readLine());
            if (key == 0) {
                if (heap.isEmpty()) {
                    result.append(0).append("\n");
                } else {
                    result.append(heap.poll()).append("\n");
                }
            } else {
                heap.offer(key);
            }
        }
        System.out.println(result);
    }
}