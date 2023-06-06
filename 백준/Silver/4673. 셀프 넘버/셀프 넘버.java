import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
    static int d(int n) {
        int sum = n;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] arr = new boolean[10001];
        for (int i = 1; i < arr.length; i++) {
            int idx = d(i);
            if (idx <= 10000) {
                arr[idx] = true;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i]) {
                bw.write(String.valueOf(i) + "\n");
            }
        }
        bw.close();
    }
}