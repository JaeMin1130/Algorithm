import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void swap(char arr[], int i, int j) {
        char store = arr[i];
        arr[i] = arr[j];
        arr[j] = store;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((int) arr[i] < (int) arr[j]) {
                    swap(arr, i, j);
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i] + "");
        }
        bw.close();
    }
}