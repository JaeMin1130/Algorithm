import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static int[] toIntArr() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arrStr[] = br.readLine().split(" ");
        int arr[] = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        return arr;
    }

    public static void printArr(BufferedWriter bw, int[] arr) throws IOException {
        for (int i = 0; i < arr.length; i++) {
            bw.write(String.valueOf(arr[i] + " "));
        }
        bw.flush();
        bw.write("\n");
    }

    public static void main(String[] args) throws IOException {
        int[] arr = toIntArr();
        int[] sortedArr = {1, 2, 3, 4, 5};
        int store = 0;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while (!Arrays.equals(arr, sortedArr)) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    store = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = store;
                    printArr(bw, arr);
                }
            }
        }
        bw.close();
    }
}