import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        String arrStr[] = br.readLine().split(" ");
        int arr[] = new int[num];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }

        int start = arr[0];
        int height = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] <= 0) {
                if (height < arr[i] - start) {
                    height = arr[i] - start;
                }
                start = arr[i + 1];
            }
            if (i == arr.length - 2) {
                if (height < arr[i + 1] - start) {
                    height = arr[i + 1] - start;
                }
            }
        }
        bw.write(String.valueOf(height));
        bw.close();
    }
}