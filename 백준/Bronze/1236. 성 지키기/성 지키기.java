import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static int countFalse(boolean[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i])
                count++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] idx = br.readLine().split(" ");
        boolean[] row = new boolean[Integer.parseInt(idx[0])];
        boolean[] col = new boolean[Integer.parseInt(idx[1])];

        for (int i = 0; i < row.length; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == 'X') {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        bw.write(
                countFalse(row) >= countFalse(col) ? String.valueOf(countFalse(row)) : String.valueOf(countFalse(col)));
        bw.close();
    }
}