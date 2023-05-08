import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String[] strArr = br.readLine().split(" ");
            int[] arr = new int[10];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = Integer.parseInt(strArr[j]);
            }
            Arrays.sort(arr);
            int count = 0;
            for (int j = arr.length - 1; j >= 1; j--) {
                if (arr[j] - arr[j - 1] != 0)
                    count++;
                if (count == 2) {
                    bw.write(String.valueOf(arr[j - 1]) + "\n");
                    break;
                }
            }
        }
        bw.close();
    }
}