import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int len = String.valueOf(num).length();

        int start = 0;
        for (int i = 0; i < len - 1; i++) {
            start += 7 * Math.pow(10, i);
        }

        int result = 0;
        for (int i = start; i <= num; i++) {
            if (Pattern.matches("^(4|7)+$", String.valueOf(i))) {
                if (num - result > num - i) {
                    result = i;
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.close();
    }
}