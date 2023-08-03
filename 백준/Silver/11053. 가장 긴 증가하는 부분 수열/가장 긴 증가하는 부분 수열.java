import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Stream;

class Main {
    static int N;
    static int[] input;
    static int[] memo;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        memo = new int[N];
        for (int i = 0; i < N; i++) {
            dp(i);
        }
        Arrays.sort(memo);
        System.out.println(memo[N - 1]);
    }

    static int dp(int idx) {
        if (idx == N - 1) {
            memo[idx] = 1;
            return memo[idx];
        } else {
            if (memo[idx] != 0) {
                return memo[idx];
            } else {
                PriorityQueue<Integer> q = new PriorityQueue<>((v1, v2) -> v2 - v1);
                for (int j = idx + 1; j < N; j++) {
                    if (input[idx] < input[j]) {
                        q.add(1 + dp(j));
                    }
                    q.add(1);
                    memo[idx] = q.peek();
                }
                return memo[idx];
            }
        }
    }
}