import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int big = Arrays.stream(input).max().getAsInt();
            int small = Arrays.stream(input).min().getAsInt();
            int num = 1;
            int result = 1;

            while (num <= small) {
                if (big * num % small == 0) {
                    result = big * num;
                    break;
                } else {
                    num++;
                }
            }
            bw.write(String.valueOf(result) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
