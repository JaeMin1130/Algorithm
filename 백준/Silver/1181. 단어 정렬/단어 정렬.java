import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        String[] arr = new String[num];
        String store;
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < num; i++) {
            arr[i] = br.readLine();
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].length() > arr[j].length()) {
                    store = arr[i];
                    arr[i] = arr[j];
                    arr[j] = store;
                }
            }
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].length() == arr[j].length() && arr[i].compareTo(arr[j]) > 0) {
                    store = arr[i];
                    arr[i] = arr[j];
                    arr[j] = store;
                }
            }
        }
        result.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (result.indexOf(arr[i]) == -1) {
                result.add(arr[i]);
            }
        }
        for (int i = 0; i < result.size(); i++) {
            bw.write(result.get(i) + "\n");
        }
        bw.close();
    }
}