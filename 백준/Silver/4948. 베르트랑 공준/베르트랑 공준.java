import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] primes = new boolean[246913];
        Arrays.fill(primes, true);
        searchPrime(primes);

        int count = 0;
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                break;
            } else {
                for (int i = num + 1; i <= 2 * num; i++) {
                    if (primes[i]) {
                        count++;
                    }
                }
                System.out.println(count);
                count = 0;
            }
        }
    }

    static void searchPrime(boolean[] array) {
        for (int i = 2; i < Math.sqrt(array.length); i++) {
            if (array[i]) {
                for (int j = i * i; j < array.length; j += i) {
                    array[j] = false;
                }
            }
        }
    }
}