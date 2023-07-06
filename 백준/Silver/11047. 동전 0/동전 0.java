import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int target = input[1];

        Queue<Integer> q = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            if (val <= target) {
                q.add(val);
            }
        }
        
        int count = 0;
        while (true) {
            int val = q.poll();
            int num = target / val;
            if (num != 0) {
                target -= val * num;
                count += num;
            }
            if (target == 0)
                break;
        }

        System.out.println(count);
    }
}