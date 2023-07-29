import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(input.nextToken());
        int N = Integer.parseInt(input.nextToken());

        boolean[] primes = new boolean[N + 1];
        Arrays.fill(primes, true);
        primes[1] = false;

        for (int i = 2; i < Math.sqrt(primes.length); i++) {
            if (primes[i]) {
                for (int j = i * i; j < primes.length; j += i) {
                    primes[j] = false;
                }
            }
        }

        for (int i = M; i < primes.length; i++) {
            if (primes[i]) {
                System.out.println(i);
            }
        }
    }
}