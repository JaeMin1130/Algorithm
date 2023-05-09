import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] mush = new int[10];
        int sumOver = 0;
        int sumUnder = 0;
        for (int i = 0; i < 10; i++) {
            mush[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < mush.length; i++) {
            sumOver += mush[i];
            if (sumOver >= 100) {
                sumUnder = sumOver - mush[i];
                break;
            }
        }
        if (sumOver == 100) {
            bw.write("100");
        } else if (sumOver - 100 > 100 - sumUnder) {
            bw.write(String.valueOf(sumUnder));
        } else {
            bw.write(String.valueOf(sumOver));
        }

        bw.close();
    }
}