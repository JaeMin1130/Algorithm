import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int[] resultArr = new int[n];
        int sum = 0;
        int startIdx = 0;
        while (startIdx < arr.length) {
            sum += Integer.parseInt(arr[startIdx]);
            resultArr[startIdx] = sum;
            startIdx++;
            if (sum < 0) {
                sum = 0;
            }
        }
        int max = resultArr[0];
        for (int i = 0; i < resultArr.length; i++) {
            if (max < resultArr[i]) {
                max = resultArr[i];
            }
        }
        System.out.println(max);
    }
}