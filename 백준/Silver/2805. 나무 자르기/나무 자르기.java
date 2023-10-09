import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(input.nextToken());
        long M = Integer.parseInt(input.nextToken());
        Long[] trees = Stream.of(br.readLine().split(" "))
                .map(Long::valueOf)
                .toArray(Long[]::new);
        Arrays.sort(trees);
        int idx = N - 2;
        int count = 1;
        long sum = 0L;
        while (idx != -1) {
            sum += (trees[idx + 1] - trees[idx]) * count;
            if (sum >= M) {
                break;
            }
            idx--;
            count++;
        }
        if (idx == -1) {
            System.out.println((int) (trees[0] - (double) (M - sum) / count));
        } else {
            if (sum == M) {
                System.out.println(trees[idx]);
            } else {
                System.out.println(trees[idx] + (sum - M) / count);
            }
        }
    }
}