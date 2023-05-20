import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
    static int sum(int i) {
        return i * (i + 1) / 2;
    }

    static ArrayList<Integer> locationArr(int X) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int i = 1;
        while (true) {
            if (X > sum(i) && X <= sum(i + 1)) {
                for (int j = sum(i) + 1; j <= sum(i + 1); j++) {
                    arr.add(j);
                }
                break;
            }
            i++;
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int X = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = locationArr(X);
        int num = arr.size() + 1;
        int[] result = new int[arr.size()];
        for (int i = 0, j = 1; i < result.length; i++, j++) {
            result[i] = j;
        }
        int idx = arr.indexOf(X);
        if (X == 1) {
            bw.write("1/1");
        } else {
            if (num % 2 == 0) {
                String output = (num - result[idx]) + "/" + result[idx];
                bw.write(output);
            } else {
                String output = result[idx] + "/" + (num - result[idx]);
                bw.write(output);
            }
        }
        bw.close();
    }
}