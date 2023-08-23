import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(input.nextToken());
        int M = Integer.parseInt(input.nextToken());

        List<String> input2 = new ArrayList<>(Arrays.asList(br.readLine().split(" ")));
        int[] arr = input2.stream().mapToInt(Integer::parseInt).toArray();

        int first = 0;
        int sum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > M) {
                while (sum > M) {
                    sum -= arr[first++];
                }
            }
            if (sum == M) {
                count++;
                sum -= arr[first++];
            }
        }
        System.out.println(count);
    }
}