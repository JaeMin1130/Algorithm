import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Main {

    static boolean[] getPrimeArr(int n) {
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (primes[i]) {
                for (int j = i * i; j <= n; j += 2 * i) {
                    primes[j] = false;
                }
            }
        }
        return primes;
    }

    static String findFactor(int input, boolean[] primes) {

        for (int i = 3; i <= input / 2; i += 2) {
            if (primes[input - i] && primes[i]) {
                return input + " = " + i + " + " + (input - i);
            }
        }

        return "Goldbach's conjecture is wrong.";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] primes = getPrimeArr(1000001);

        while (true) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                break;
            } else {
                bw.write(findFactor(input, primes) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}