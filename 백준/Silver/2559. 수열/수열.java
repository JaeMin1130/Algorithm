import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(input.nextToken());
        int M = Integer.parseInt(input.nextToken());
        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        PriorityQueue<Integer> result = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int i = 0; i <= N - M; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += arr[i + j];
            }
            result.add(sum);
        }
        System.out.println(result.peek());
    }
}