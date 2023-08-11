import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] target = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int E = 1;
        int S = 1;
        int M = 1;
        int count = 1;

        while (!(E == target[0] && S == target[1] && M == target[2])) {
            E++;
            S++;
            M++;
            if (E == 16)
                E = 1;
            if (S == 29)
                S = 1;
            if (M == 20)
                M = 1;
            count++;
        }
        System.out.println(count);
    }
}