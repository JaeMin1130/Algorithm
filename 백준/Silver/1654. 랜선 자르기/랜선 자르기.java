import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(input.nextToken());
        int N = Integer.parseInt(input.nextToken());

        long[] lines = new long[K];
        for (int i = 0; i < K; i++) {
            lines[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(lines);

        long left = 1;
        long right = lines[K - 1];
        while (left <= right) {
            long count = 0;
            long mid = (left + right) / 2;
            for (int i = 0; i < lines.length; i++) {
                count += lines[i] / mid;
            }
            if (count >= N) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}