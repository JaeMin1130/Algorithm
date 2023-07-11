
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int num = input[0] % 10;
            for (int j = 1; j < input[1]; j++) {
                num = input[0] * num % 10;
            }
            if (num == 0) {
                System.out.println(10);
            } else {
                System.out.println(num);
            }
        }
    }
}