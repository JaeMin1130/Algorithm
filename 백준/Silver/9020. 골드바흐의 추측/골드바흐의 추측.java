import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        boolean[] primes = new boolean[10000];
        Arrays.fill(primes, true);
        primes[1] = false;
        for (int i = 2; i < Math.sqrt(primes.length); i++) {
            if (primes[i]) {
                for (int j = i * i; j < primes.length; j += i) {
                    primes[j] = false;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            int start = input / 2;
            for (int j = start; j > 0; j--) {
                if (primes[j] && primes[input - j]) {
                    System.out.println(j + " " + (input - j));
                    break;
                }
            }
        }
    }
}