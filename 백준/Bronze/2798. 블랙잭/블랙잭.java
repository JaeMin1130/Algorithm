import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(input.nextToken());
        int M = Integer.parseInt(input.nextToken());
        int[] nums = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        PriorityQueue<Integer> result = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum <= M) {
                        result.add(sum);
                    }
                }
            }
        }
        System.out.println(result.peek());
    }
}