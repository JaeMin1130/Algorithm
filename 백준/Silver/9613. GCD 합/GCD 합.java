import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(input.nextToken());
            }
            Arrays.sort(arr);
            long sum = 0L;
            for (int j = 0; j < arr.length - 1; j++) {
                for (int j2 = j + 1; j2 < arr.length; j2++) {
                    sum += gcd(arr[j2], arr[j]);
                }
            }
            bw.write(String.valueOf(sum) + "\n");
        }
        bw.flush();
        bw.close();
    }

    static int gcd(int x, int y) {
        if (y == 0)
            return x;
        else
            return gcd(y, x % y);
    }
}