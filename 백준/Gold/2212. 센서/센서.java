import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] sensors = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        if (k >= n) {
            System.out.println(0);
            return;
        }

        int[] distances = new int[n - 1];
        for (int i = 0; i < distances.length; i++) {
            distances[i] = sensors[i + 1] - sensors[i];
        }

        Arrays.sort(distances);
        int sum = 0;
        for (int i = 0; i < distances.length - k + 1; i++) {
            sum += distances[i];
        }

        System.out.println(sum);
    }
}