import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            Queue<Integer> q = new LinkedList<>();
            PriorityQueue<Integer> list = new PriorityQueue<>((v1, v2) -> v2 - v1);

            int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < input[0]; j++) {
                q.add(arr[j]);
                list.add(arr[j]);
            }

            int order = input[1];
            int count = 0;
            while (!q.isEmpty()) {
                if (order == 0 && list.peek() == arr[input[1]]) {
                    count++;
                    break;
                }
                if (q.peek() == list.peek()) {
                    q.poll();
                    list.poll();
                    count++;
                } else {
                    int num = q.poll();
                    q.add(num);
                }
                if (order == 0) {
                    order = q.size() - 1;
                } else {
                    order--;
                }
            }
            System.out.println(count);
        }
    }
}
