import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int jimin = input[1];
        int hansoo = input[2];
        int round = 1;

        while (Math.abs(jimin - hansoo) != 1 || Math.max(jimin, hansoo) % 2 != 0) {
            round++;
            N = (N + 1) / 2;
            jimin = (jimin + 1) / 2;
            hansoo = (hansoo + 1) / 2;
        }
        System.out.println(round);
    }
}