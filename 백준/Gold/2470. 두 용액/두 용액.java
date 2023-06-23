import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        int p1 = 0;
        int p2 = arr.length - 1;
        StringBuilder result = new StringBuilder(String.valueOf(arr[p1]) + " " + String.valueOf(arr[p2]));
        int val = arr[p1] + arr[p2];
        int min = Math.abs(val);

        if (arr[p2] <= 0) {

            result = new StringBuilder(String.valueOf(arr[arr.length - 2]) + " " + String.valueOf(arr[arr.length - 1]));
        } else if (arr[p1] >= 0) {
            result = new StringBuilder(String.valueOf(arr[0]) + " " + String.valueOf(arr[1]));
        } else {
            while (p2 - p1 > 1) {
                if (val < 0) {
                    val = arr[++p1] + arr[p2];
                    if (min > Math.abs(val)) {
                        min = Math.abs(val);
                        result = new StringBuilder(String.valueOf(arr[p1]) + " " + String.valueOf(arr[p2]));
                    }
                } else if (val > 0) {
                    val = arr[p1] + arr[--p2];
                    if (min > Math.abs(val)) {
                        min = Math.abs(val);
                        result = new StringBuilder(String.valueOf(arr[p1]) + " " + String.valueOf(arr[p2]));
                    }
                } else {
                    break;
                }
            }
        }
        System.out.println(result);
    }
}